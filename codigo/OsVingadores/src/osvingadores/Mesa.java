package OsVingadores;

public class Mesa implements Jogada {
	protected Monte _monteCompra;
	protected Monte _monteVilao;
	protected Monte _monteDescarte;
	protected Monte _monteVilaosAtivos;
	protected boolean _partidaEmAndamento;
	protected Jogador _jogadores;
	protected boolean _comJogadorVencedor;
	public Jogador _unnamed_Jogador_;
	public ControladorJogo _unnamed_ControladorJogo_;
	public Monte _unnamed_Monte_;

	public boolean isPartidaEmAndamento() {
		return this._partidaEmAndamento;
	}

	public Jogador getColecaoJogadores() {
		throw new UnsupportedOperationException();
	}

	public void removerVilao(Personagem aVilao) {
		throw new UnsupportedOperationException();
	}

	public boolean isJogadorVencedor() {
		throw new UnsupportedOperationException();
	}

	public Jogador temJogadorVencedor() {
		throw new UnsupportedOperationException();
	}

	public void setComJogadorVencedor(boolean aTemjogadorVencedor) {
		this._comJogadorVencedor = aTemjogadorVencedor;
	}

	public Jogador encontrarJogadorVencedor() {
		throw new UnsupportedOperationException();
	}

	public TipoArtefato verificarQualArtefato(Artefato aCartaArtefato) {
		throw new UnsupportedOperationException();
	}

	public Carta comprarCartaDoMonteCompra() {
		throw new UnsupportedOperationException();
	}

	public void trocarMaosDosJogadores() {
		throw new UnsupportedOperationException();
	}
}