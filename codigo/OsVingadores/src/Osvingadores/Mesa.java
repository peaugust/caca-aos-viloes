package Osvingadores;

import osvingadores.Monte;
import osvingadores.Monte;
import osvingadores.Personagem;
import osvingadores.Personagem;
import osvingadores.TipoArtefato;
import osvingadores.TipoArtefato;

import java.util.ArrayList;

public class Mesa implements Jogada {
	protected Monte _monteCompra;
	protected Monte _monteVilao;
	protected Monte _monteDescarte;
	protected Monte _monteVilaosAtivos;
	protected boolean _partidaEmAndamento;
	protected ArrayList<Jogador> _jogadores;
	protected boolean _comJogadorVencedor;
	public Jogador _unnamed_Jogador_;
	public ControladorJogo _unnamed_ControladorJogo_;
	public Monte _unnamed_Monte_;
        
        
        public Mesa(){
            _monteCompra = new Monte();
            _monteVilao = new Monte();
            _monteDescarte = new Monte();
            _monteVilaosAtivos = new Monte();
            _partidaEmAndamento = true;
            _jogadores = new ArrayList();
            _comJogadorVencedor = false;
                    
        }

	public boolean isPartidaEmAndamento() {
            return this._partidaEmAndamento;
	}

	public ArrayList<Jogador> getColecaoJogadores() {
            return this._jogadores;
            //throw new UnsupportedOperationException();
	}

	public void removerVilao(Personagem aVilao) {
            this._monteVilaosAtivos.removerCarta(aVilao);
            //throw new UnsupportedOperationException();
	}

	public boolean isJogadorVencedor() {
            return _comJogadorVencedor;
            //throw new UnsupportedOperationException();
	}

	public Jogador temJogadorVencedor() {
            int tamanho = this._monteVilaosAtivos.tamanhoMonte();
            if(tamanho == 0){
                this.setComJogadorVencedor(_comJogadorVencedor);
                _unnamed_Jogador_ = encontrarJogadorVencedor();
            }
		throw new UnsupportedOperationException();
	}

	public void setComJogadorVencedor(boolean aTemjogadorVencedor){
		this._comJogadorVencedor = aTemjogadorVencedor;
	}

	public Jogador encontrarJogadorVencedor() {
            Jogador jogadorRef = new Jogador();
            for(int i = 0; i < 2; i++){
                jogadorRef = _jogadores.get(i);
            }
            throw new UnsupportedOperationException();
	}

	public TipoArtefato verificarQualArtefato(Artefato aCartaArtefato) {
		throw new UnsupportedOperationException();
	}

	public Carta comprarCartaDoMonteCompra() {
            Carta novaCarta = this._monteCompra.comprarCarta();
            return novaCarta;
            //throw new UnsupportedOperationException();
	}

	public void trocarMaosDosJogadores() {
		throw new UnsupportedOperationException();
	}
}