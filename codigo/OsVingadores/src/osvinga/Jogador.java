package osvinga;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada {

    //Atributos:
    protected String nome;
    protected int pontuacao;
    protected Monte mao;
    protected Monte viloesCapturados;
    protected boolean jogadorDaVez;

    //Construtor:
    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.mao = new Monte();
        this.viloesCapturados = new Monte();
        this.jogadorDaVez = false;
    }

    //Metodos:
    public boolean ehSeuNome(String nome) {
        return this.nome.equals(nome);
    }

    public boolean isJogadorDaVez() {
        return this.jogadorDaVez;
    }

    public void adicionarVilao(Carta vilao) {
        this.viloesCapturados.adicionarCarta(vilao);
    }

    public void retirarConjuntoDaMao(Monte conjuntoDeHerois) {
        for (Carta carta : conjuntoDeHerois.getCartas()) {
            this.mao.removerCarta(carta);
        }
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public boolean temPontuacaoMaior(int pontuacao) {
        if (this.pontuacao > pontuacao) {
            return true;
        } else {
            return false;
        }
    }

    public void adicionarCartaAMaoDoJogador(Carta carta) {
        this.mao.adicionarCarta(carta);
    }

    public Monte getMao() {
        return this.mao;
    }

    public void setMaoJogador(Monte deck) {
        this.mao = deck;
    }

    public String getNomeJogador() {
        return this.nome;
    }

    public void setJogadorDaVez(boolean aEhJogadorDaVez) {
        this.jogadorDaVez = aEhJogadorDaVez;
    }

    public Carta removerCartaAleatoriamente() {
        Carta carta = this.mao.removerCartaAleatoriamente();
        return carta;
    }

    public Carta removerVilaoAleatoriamente() {
        return this.viloesCapturados.removerCartaAleatoriamente();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Monte getViloesCapturados() {
        return viloesCapturados;
    }

    public void setViloesCapturados(Monte viloesCapturados) {
        this.viloesCapturados = viloesCapturados;
    }

}
