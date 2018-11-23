package osvinga;

import java.util.ArrayList;

public class Mesa implements Jogada {
	protected Monte monteCompra;
	protected Monte monteVilao;
	protected Monte monteDescarte;
	protected Monte monteVilaosAtivos;
	protected boolean partidaEmAndamento;
	protected ArrayList<Jogador> jogadores;
	protected boolean comJogadorVencedor;        
        
        public Mesa(){
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
            //throw new UnsupportedOperationException();
	}

	public void removerVilao(Carta vilao) {
            this.monteVilaosAtivos.removerCarta(vilao);
            //throw new UnsupportedOperationException();
	}

	public boolean isJogadorVencedor() {
            return comJogadorVencedor;
            //throw new UnsupportedOperationException();
	}

	public Jogador temJogadorVencedor() {
            Jogador jogadorVencedor = new Jogador();
            int tamanho = this.monteVilaosAtivos.tamanhoMonte();
            if(tamanho == 0){
                this.setComJogadorVencedor(comJogadorVencedor);
                jogadorVencedor = encontrarJogadorVencedor();
            }

            return jogadorVencedor;
	}

	public void setComJogadorVencedor(boolean aTemjogadorVencedor){
		this.comJogadorVencedor = aTemjogadorVencedor;
	}

	public Jogador encontrarJogadorVencedor() {
            Jogador jogadorRef = new Jogador();
            for(int i = 0; i < 2; i++){
                jogadorRef = jogadores.get(i);
            }
            throw new UnsupportedOperationException();
	}

	public TipoArtefato verificarQualArtefato(Artefato aCartaArtefato) {
		throw new UnsupportedOperationException();
	}

	public Carta comprarCartaDoMonteCompra() {
            Carta novaCarta = this.monteCompra.comprarCarta();
            return novaCarta;
            //throw new UnsupportedOperationException();
	}

	public void trocarMaosDosJogadores() {
		throw new UnsupportedOperationException();
	}
}