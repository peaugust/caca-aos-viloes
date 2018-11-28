package osvinga;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.Collections;

public class Mesa implements Jogada {

    protected Monte monteCompra;
    protected Monte monteVilao;
    protected Monte monteDescarte;
    protected Monte monteVilaosAtivos;
    protected boolean partidaEmAndamento;
    protected ArrayList<Jogador> jogadores;
    protected boolean comJogadorVencedor;

    public Mesa() {
        monteCompra = new Monte();
        monteVilao = new Monte();
        monteDescarte = new Monte();
        monteVilaosAtivos = new Monte();
        partidaEmAndamento = false;
        jogadores = new ArrayList();
        comJogadorVencedor = false;

    }

    public boolean isPartidaEmAndamento() {
        return this.partidaEmAndamento;
    }

    public void setPartidaEmAndamento(boolean partidaEmAndamento) {
        this.partidaEmAndamento = partidaEmAndamento;
    }

    public ArrayList<Jogador> getColecaoJogadores() {
        return this.jogadores;
    }

    public void removerVilao(Carta vilao) {
        this.monteVilaosAtivos.removerCarta(vilao);
    }

    public boolean isJogadorVencedor() {
        return comJogadorVencedor;
    }

    public Jogador temJogadorVencedor() {
        Jogador jogadorVencedor = new Jogador("Vencedor");
        int tamanho = this.monteVilaosAtivos.tamanhoMonte();
        if (tamanho == 0) {
            this.setComJogadorVencedor(comJogadorVencedor);
            jogadorVencedor = encontrarJogadorVencedor();
            return jogadorVencedor;
        }

        return null;
    }

    public void setComJogadorVencedor(boolean temjogadorVencedor) {
        this.comJogadorVencedor = temjogadorVencedor;
    }

    public Jogador encontrarJogadorVencedor() {
        Jogador jogador1 = this.jogadores.get(0);
        Jogador jogador2 = this.jogadores.get(1);

        if (jogador2.temPontuacaoMaior(jogador1.getPontuacao())) {
            return jogador2;
        } else {
            return jogador1;
        }

    }

    public TipoArtefato verificarQualArtefato(Artefato cartaArtefato) {
        return cartaArtefato.getTipo();
    }

    public Carta comprarCartaDoMonteCompra() {
        Carta novaCarta = this.monteCompra.comprarCarta();
        return novaCarta;
    }

    public void trocarMaosDosJogadores() {
        Jogador jogador1 = this.jogadores.get(0);
        Jogador jogador2 = this.jogadores.get(1);

        Monte maoJogador1 = jogador1.getMao();
        Monte maoJogador2 = jogador2.getMao();

        jogador1.setMaoJogador(maoJogador2);
        jogador2.setMaoJogador(maoJogador1);

        return;
    }

    public Monte getMonteCompra() {
        return monteCompra;
    }

    public void setMonteCompra(Monte monteCompra) {
        this.monteCompra = monteCompra;
    }

    public Monte getMonteVilao() {
        return monteVilao;
    }

    public void setMonteVilao(Monte monteVilao) {
        this.monteVilao = monteVilao;
    }

    public Monte getMonteDescarte() {
        return monteDescarte;
    }

    public void setMonteDescarte(Monte monteDescarte) {
        this.monteDescarte = monteDescarte;
    }

    public Monte getMonteVilaosAtivos() {
        return monteVilaosAtivos;
    }

    public void setMonteVilaosAtivos(Monte monteVilaosAtivos) {
        this.monteVilaosAtivos = monteVilaosAtivos;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void criarMonteDeCompra() {
        Monte novoMonteCompra = new Monte();

        novoMonteCompra.adicionarCarta(new Personagem("Groot", 1, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Bucky", 1, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Shuri", 1, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Wong", 1, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Mantis", 1, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Falcão", 1, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Homem-Aranha", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Thor", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Okoye", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Feiticeira Escarlate", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Rocky", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Pantera Negra", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Hulk", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Gamora", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Doutor Estranho", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Drax", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Máquina de Combate", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Visão", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Senhor das Estrelas", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Viúva Negra", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Hulkbuster", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Nebulosa", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Capitão América", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Homem de Ferro", 2, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Pantera Negra e Shuri", 3, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Doutro Estranho e Wong", 3, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Groot e Rocky", 3, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Homem de Ferro e Homem-Aranha", 4, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Senhor das Estrelas e Gamora", 4, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Personagem("Thor e Hulk", 4, TipoPersonagem.HEROI));
        novoMonteCompra.adicionarCarta(new Artefato("JOIA DO ESPAÇO", 2, TipoArtefato.ESPACO));
        novoMonteCompra.adicionarCarta(new Artefato("JOIA DO TEMPO", 3, TipoArtefato.TEMPO));
        novoMonteCompra.adicionarCarta(new Artefato("JOIA DA MENTE", 4, TipoArtefato.MENTE));
        novoMonteCompra.adicionarCarta(new Artefato("JOIA DA REALIDADE", 5, TipoArtefato.REALIDADE));
        novoMonteCompra.adicionarCarta(new Artefato("JOIA DO PODER", 2, TipoArtefato.PODER));

        Collections.shuffle(novoMonteCompra.getCartas());
        this.setMonteCompra(novoMonteCompra);
    }

    public void criarMonteVilao() {
        Monte novoMonteVilao = new Monte();
        
        novoMonteVilao.adicionarCarta(new Personagem("Batedor da Ordem Negra",5,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Batedor da Ordem Negra",5,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Batedor da Ordem Negra",5,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Batedor da Ordem Negra",5,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Batedor da Ordem Negra",5,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Abate Obsidiano",8,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Fauce de Ébano",8,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Corvus Glaive",10,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Próxima Meia-Noite",10,TipoPersonagem.VILAO));
        novoMonteVilao.adicionarCarta(new Personagem("Thanos",15,TipoPersonagem.VILAO));
        
        Collections.shuffle(novoMonteVilao.getCartas());
        this.setMonteVilao(novoMonteVilao);
    }
    
    public void addCartaAoMonteDescarte(Carta carta){
        this.monteDescarte.adicionarCarta(carta);
    }

    void criarMonteDescarte() {
        Monte monteDesc = new Monte();
        this.monteDescarte = monteDesc;
    }

    void criarMonteViloesAtivos() {
        Monte monteViloesAtivosAux = new Monte();
        this.setMonteVilaosAtivos(monteViloesAtivosAux);
    }

    void instanciaJogadores(String nomeJogador1, String nomeJogador2) {
        //Prepara o jogador1:
        Jogador jogador1 = new Jogador(nomeJogador1);
        Monte deckJogador1 = new Monte();
        jogador1.setJogadorDaVez(true);
        for (int cartasAdicionadas = 0; cartasAdicionadas < 5; cartasAdicionadas++) {
            deckJogador1.adicionarCarta(monteCompra.comprarCarta());
        }
        jogador1.setMaoJogador(deckJogador1);
        //Prepara o jogador2:
         Jogador jogador2 = new Jogador(nomeJogador2);
        Monte deckJogador2 = new Monte();
        for (int cartasAdicionadas = 0; cartasAdicionadas < 5; cartasAdicionadas++) {
            deckJogador2.adicionarCarta(monteCompra.comprarCarta());
        }
        jogador2.setMaoJogador(deckJogador2);
        //Adicionar viloes:
        this.monteVilaosAtivos.adicionarCarta(this.monteVilao.comprarCarta());
        this.monteVilaosAtivos.adicionarCarta(this.monteVilao.comprarCarta());
        
        //Coloca na Mesa
        ArrayList<Jogador> jogadoresInstanciados;
        jogadoresInstanciados = new ArrayList<>();
        jogadoresInstanciados.add(0, jogador1);  
        jogadoresInstanciados.add(1, jogador2);
        this.setJogadores(jogadoresInstanciados);
    }
}
