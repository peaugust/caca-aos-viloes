package osvinga;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

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
        partidaEmAndamento = true;
        jogadores = new ArrayList();
        comJogadorVencedor = false;

    }

    public boolean isPartidaEmAndamento() {
        return this.partidaEmAndamento;
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
        Jogador jogadorVencedor = new Jogador();
        int tamanho = this.monteVilaosAtivos.tamanhoMonte();
        if (tamanho == 0) {
            this.setComJogadorVencedor(comJogadorVencedor);
            jogadorVencedor = encontrarJogadorVencedor();
        }

        return jogadorVencedor;
    }

    public void setComJogadorVencedor(boolean aTemjogadorVencedor) {
        this.comJogadorVencedor = aTemjogadorVencedor;
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
    
    
}
