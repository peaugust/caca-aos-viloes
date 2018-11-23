package osvinga;

import java.util.ArrayList;

public class ControladorJogo {

    protected Mesa mesa;
    protected String nomeJogador;
    protected boolean conectado;
    protected AtorJogador atorJogador;
    protected AtorNetGames atorNetGames;

    public int conectar() {
        throw new UnsupportedOperationException();
    }

    public boolean isConectado() {
        return this.conectado;
    }

    public void setNomeJogador(String aNomeJogador) {
        this.nomeJogador = aNomeJogador;
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
                
                if (semConexao) {
                    this.getAtorJogador().notificarNaoConectado();
                    return;
                } else {
                    this.getAtorJogador().notificarSucessoIniciarPartida();
                    this.receberSolicitacaoDeInico();
                    return;
                }
            }
        }
        
        this.getAtorJogador().notificarNaoConectado();
        return;
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public boolean getPartidaEmAndamento() {
        return this.mesa.isPartidaEmAndamento();
    }

    public boolean desconectar() {
        throw new UnsupportedOperationException();
    }

    public boolean passarTurno() {
        
        boolean ehSeuTurno = this.verificarJogadorDoTurno();
        
        throw new UnsupportedOperationException();
    }

    public boolean verificarJogadorDoTurno() {
        ArrayList<Jogador> jogadores = this.mesa.getColecaoJogadores();
        
        boolean encontrou = false;
        for (Jogador jogador : jogadores) {
            encontrou = jogador.ehSeuNome(this.nomeJogador);
            
        }
        
        throw new UnsupportedOperationException();
    }

    public boolean capturarVilao(Monte cartasCapturar, Carta vilao) {
        boolean resultado = false;
        int somatorioDePontos = this.calcularSomatorioDePoder(cartasCapturar);
        int poderVilao = vilao.getPoder();
        
        if(somatorioDePontos >= poderVilao) {
            Jogador jogador = this.recuperarInstanciaJogador();
            
            jogador.adicionarVilao(vilao);
            jogador.retirarConjuntoDaMao(cartasCapturar);
            
            this.getMesa().removerVilao(vilao);
            
            resultado = true;
            
        }
        
        this.verificarEstadoDoJogo();
        
        return resultado;
        
    }

    public int calcularSomatorioDePoder(Monte cartasCapturar) {
        return cartasCapturar.calcularSomatorioDePoder();
    }

    public Jogador recuperarInstanciaJogador(){
        ArrayList<Jogador> jogadorRef = this.mesa.getColecaoJogadores();
        for(int i = 0; i < 2; i++){
            Jogador ref = jogadorRef.get(i);
            if(ref.ehSeuNome(nomeJogador)){
                return ref;
            }
        }
        return null;
    }

    public void receberEstadoDaMesa(Mesa mesa) {
        this.setMesa(mesa);
        this.atorJogador.atualizarInterface(mesa);
        this.verificarEstadoDoJogo();
    }

    public boolean verificarEstadoDoJogo() {
        Jogador jogadorRef = this.mesa.temJogadorVencedor();
        if(jogadorRef != null){
            this.atorJogador.notificarJogadorVencedor(jogadorRef);
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

    public boolean cartaLocalizadaEmMaos() {
        throw new UnsupportedOperationException();
    }

    public void usarJoia(Artefato aCartaJoia) {
        TipoArtefato tipo = this.verificarQualArtefato(aCartaJoia);
        switch(tipo){
            case MENTE: 
                this.mesa.trocarMaosDosJogadores();
                break;
            case TEMPO:
                Jogador jogador = this.recuperarInstanciaJogador();
                int x = 0;
                while(x < 3){
                    Carta carta = this.mesa.comprarCartaDoMonteCompra();
                    jogador.adicionarCartaAMaoDoJogador(carta);
                }
                break;
        }
        throw new UnsupportedOperationException();
    }

    public TipoArtefato verificarQualArtefato(Artefato carta) {
        return this.mesa.verificarQualArtefato(carta);
    }

    public void atualizarEstadoJogo() {
        throw new UnsupportedOperationException();
    }

    public void enviarJogada(Mesa mesa) {
        throw new UnsupportedOperationException();
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

    private void receberSolicitacaoDeInico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
