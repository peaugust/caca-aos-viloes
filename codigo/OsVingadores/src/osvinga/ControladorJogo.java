package osvinga;

import osvinga.netgames.AtorNetGames;
import java.util.ArrayList;
import osvinga.gui.InterfaceMesa;

public class ControladorJogo {

    protected Mesa mesa;
    protected String nomeJogador;
    protected boolean conectado;
    protected AtorJogador atorJogador;
    protected AtorNetGames atorNetGames;

    public ControladorJogo() {
        this.atorJogador = new AtorJogador(this);
        this.atorNetGames = new AtorNetGames(this);
        this.mesa = new Mesa();
        this.conectado = false;
    }

    public void conectar() {

        int resultado = 0;
        if (!this.isConectado()) {
            String nomeServidor = this.atorJogador.solictarEnderecoServidor();
            String nomeJogador = this.atorJogador.solicitarNomeJogador();
            //this.nomeJogador = nomeJogador;

            this.setNomeJogador(nomeJogador);

            resultado = this.atorNetGames.conectar(nomeJogador, nomeServidor);

        }
        this.conectado = resultado == 1;
        this.atorJogador.mostrarResultadoConectar(resultado);
    }

    public boolean isConectado() {
        return this.conectado;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void iniciarPartida() {
        boolean conectado = this.isConectado();
        boolean emAndamento = false;
        if (conectado) {
            Mesa mesa = this.getMesa();

            if (mesa != null) {
                emAndamento = mesa.isPartidaEmAndamento();
            }

            if (emAndamento) {
                this.getAtorJogador().notificarPartidaEmAndamento();
                return;
            } else {
                boolean semConexao = this.getAtorNetGames().iniciarPartida();
                System.out.println(this.nomeJogador + "CONEXÃO:" + semConexao);
                if (semConexao) {
                    this.getAtorJogador().notificarNaoConectado();
                } else {
                    this.getAtorJogador().notificarSucessoIniciarPartida();
                }
            }
        }
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public boolean getPartidaEmAndamento() {
        return this.mesa.isPartidaEmAndamento();
    }

    public boolean desconectar() {
        return this.atorNetGames.desconectar();
    }

    public boolean passarTurno() {
         boolean ehSeuTurno = this.verificarJogadorDoTurno();

        if (ehSeuTurno) {
            boolean passarTurno = this.atorJogador.solicitarConfirmacaoPassarTurno();
            
            this.passarTurnoDosJogadores();

            if (passarTurno) {
                this.verificarEstadoDoJogo();
                //Adicionar na modelagem
                this.enviarJogada(this.mesa);
                return true;
            }
        }

        return false;
    }

    /**
     * Retorna um boolean se eh a vez do jogador dessa instancia do jogo
     * realizar seuas jogadas.
     *
     * @return true se for a vez do jogador desse controlador jogar
     */
    public boolean verificarJogadorDoTurno() {
        ArrayList<Jogador> jogadores = this.mesa.getColecaoJogadores();

        boolean encontrou = false;
        for (Jogador jogador : jogadores) {
            encontrou = jogador.ehSeuNome(this.nomeJogador);
            if (encontrou) {
                return jogador.isJogadorDaVez();
            }
        }

        return false;
    }

    public boolean capturarVilao(Monte cartasCapturar, Carta vilao) {
        boolean resultado = false;
        int somatorioDePontos = this.calcularSomatorioDePoder(cartasCapturar);
        int poderVilao = vilao.getPoder();

        if (somatorioDePontos >= poderVilao) {
            Jogador jogador = this.recuperarInstanciaJogador();

            jogador.adicionarVilao(vilao);
            jogador.retirarConjuntoDaMao(cartasCapturar);

            this.getMesa().removerVilao(vilao);
            
            this.atualizarEstadoJogo(); //Colocar no diagrama

            resultado = true;

        }

        this.verificarEstadoDoJogo();

        return resultado;

    }

    public int calcularSomatorioDePoder(Monte cartasCapturar) {
        return cartasCapturar.calcularSomatorioDePoder();
    }

    public Jogador recuperarInstanciaJogador() {
        ArrayList<Jogador> jogadorRef = this.mesa.getColecaoJogadores();
        for (int i = 0; i < 2; i++) {
            Jogador ref = jogadorRef.get(i);
            if (ref.ehSeuNome(nomeJogador)) {
                return ref;
            }
        }
        return null;
    }

    //Importante
    public void receberEstadoDaMesa(Mesa mesa) {
        this.mesa = mesa;
        this.comprarCartaParaJogadorAtivo();
        this.atorJogador.atualizarInterface(mesa, 0);
        this.verificarEstadoDoJogo();
    }

    public boolean verificarEstadoDoJogo() {
        Jogador jogadorVencedor = this.mesa.temJogadorVencedor();
        if (jogadorVencedor != null) {
            this.atorJogador.notificarJogadorVencedor(jogadorVencedor);
            return true;
        }
        return false;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public boolean verificarEstadoJogo() {
        return this.verificarEstadoDoJogo();
    }

    public void usarJoia(Artefato aCartaJoia) {
        TipoArtefato tipo = this.verificarQualArtefato(aCartaJoia);
        Jogador jogador = this.recuperarInstanciaJogador();
        ArrayList<Jogador> jogadores = mesa.getColecaoJogadores();
        switch (tipo) {
            case MENTE:
                this.mesa.trocarMaosDosJogadores();
                break;

            case TEMPO:

                jogador = this.recuperarInstanciaJogador();
                int x = 0;
                while (x < 3) {
                    Carta carta = this.mesa.comprarCartaDoMonteCompra();
                    jogador.adicionarCartaAMaoDoJogador(carta);
                }
                break;

            case ESPACO:
                jogador = this.recuperarInstanciaJogador();
                Carta carta = this.getMesa().comprarCartaDoMonteCompra();
                jogador.adicionarCartaAMaoDoJogador(carta);
                break;

            case REALIDADE:
                jogador = this.recuperarInstanciaJogador();
                jogadores = mesa.getColecaoJogadores();
                for (Jogador jogadorIteracao : jogadores) {
                    boolean ehSeuNome = jogadorIteracao.ehSeuNome(this.nomeJogador);
                    if (!ehSeuNome) {
                        for (int i = 0; i < 3; i++) {
                            jogadorIteracao.removerCartaAleatoriamente();
                        }
                    }
                }
                break;

            case PODER:
                jogador = this.recuperarInstanciaJogador();
                jogadores = mesa.getColecaoJogadores();
                Carta cartaAux;
                for (Jogador jogadorIteracao : jogadores) {
                    boolean ehSeuNome = jogadorIteracao.ehSeuNome(this.nomeJogador);
                    if (!ehSeuNome) {
                        cartaAux = jogadorIteracao.removerVilaoAleatoriamente();
                        jogador.adicionarVilao(cartaAux);
                    }
                }
                break;
        }

        this.enviarJogada(this.mesa);
    }

    public TipoArtefato verificarQualArtefato(Artefato carta) {
        return this.mesa.verificarQualArtefato(carta);
    }

    public void atualizarEstadoJogo() {
        Monte monteVilaosAtivos = this.mesa.getMonteVilaosAtivos();
        if (monteVilaosAtivos.tamanhoMonte() < 2) {
            Monte monteVilao = this.mesa.getMonteVilao();
            Carta novoVilao = monteVilao.comprarCarta();
            if (novoVilao == null) {
                return;
            }
            monteVilaosAtivos.adicionarCarta(novoVilao);
            return;
        }
        
        Jogador jogadorPrincipal = this.recuperarInstanciaJogador();
        String nome = jogadorPrincipal.getNomeJogador();
        ArrayList<Jogador> jogadores = this.mesa.getColecaoJogadores();
        for (Jogador jogador : jogadores) {
            boolean ehSeuNome = jogador.ehSeuNome(this.nomeJogador);
            if (ehSeuNome) {
                jogador.setJogadorDaVez(false);
            } else {
                jogador.setJogadorDaVez(true);
            }
        }

    }

    public void enviarJogada(Mesa mesa) {
        this.atorNetGames.enviaJogada(mesa);
    }

    public AtorJogador getAtorJogador() {
        return atorJogador;
    }

    public void setAtorJogador(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
    }

    public AtorNetGames getAtorNetGames() {
        return atorNetGames;
    }

    public void setAtorNetGames(AtorNetGames atorNetGames) {
        this.atorNetGames = atorNetGames;
    }

    public void receberSolicitacaoDeInicio(int posicao, String[] nomeJogadores) {
        if (posicao == 1) {
            System.out.print("EU INICIEI: " + this.nomeJogador);
            Mesa varMesa = this.getMesa();
            this.mesa.criarMonteDeCompra();
            this.mesa.criarMonteVilao();
            this.mesa.criarMonteDescarte();
            this.mesa.criarMonteViloesAtivos();
            this.mesa.instanciaJogadores(nomeJogadores[0], nomeJogadores[1]);
            this.receberEstadoDaMesa(mesa);
            this.atorNetGames.enviaJogada(varMesa);
        } else {
            System.out.println("EU NÃO INICIEI: " + this.nomeJogador);
        }
    }

    public void passarTurnoDosJogadores() {
        ArrayList<Jogador> jogadores = this.mesa.getJogadores();
        Jogador jogador1 = jogadores.get(0);
        Jogador jogador2 = jogadores.get(1);

        boolean vezJogador1 = jogador1.isJogadorDaVez();
        boolean vezJogador2 = jogador2.isJogadorDaVez();

        jogador1.setJogadorDaVez(vezJogador2);
        jogador2.setJogadorDaVez(vezJogador1);

        jogadores.remove(1);
        jogadores.remove(0);
        jogadores.add(0, jogador1);
        jogadores.add(1, jogador2);
        
        return;
    }

    private void comprarCartaParaJogadorAtivo() {
        Jogador jogadorAtual = this.recuperarInstanciaJogador();
        Mesa mesa = this.getMesa();
        Carta cartaNova = mesa.comprarCartaDoMonteCompra();
        jogadorAtual.adicionarCartaAMaoDoJogador(cartaNova);
        
        return;
    }
}
