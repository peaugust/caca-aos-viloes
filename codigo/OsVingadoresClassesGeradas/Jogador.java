package OsVingadores;

public class Jogador {
	protected String _nome;
	protected int _pontuacao;
	protected Monte _mao;
	protected Monte _viloesCapturados;
	protected boolean _jogadorDaVez;
	public Mesa _unnamed_Mesa_;
	public Monte _unnamed_Monte_;

	public boolean ehSeuNome(String aNome) {
		throw new UnsupportedOperationException();
	}

	public boolean isJogadorDaVez() {
		return this._jogadorDaVez;
	}

	public void adicionarVilao(Carta aVilao) {
		throw new UnsupportedOperationException();
	}

	public void retirarConjuntoDaMao(Personagem aConjuntoDeHerois) {
		throw new UnsupportedOperationException();
	}

	public int getPontuacao() {
		return this._pontuacao;
	}

	public boolean temPontuacaoMaior(int aPontuacao) {
		throw new UnsupportedOperationException();
	}

	public void adicionarCartaAMaoDoJogador(Carta aCarta) {
		throw new UnsupportedOperationException();
	}

	public Monte getMao() {
		return this._mao;
	}

	public void setMaoJogador(Monte aDeck) {
		throw new UnsupportedOperationException();
	}

	public String getNomeJogador() {
		throw new UnsupportedOperationException();
	}

	public void setJogadorDaVez(boolean aEhJogadorDaVez) {
		this._jogadorDaVez = aEhJogadorDaVez;
	}

	public boolean removerCartaAleatoriamente() {
		throw new UnsupportedOperationException();
	}

	public Carta removerVilaoAleatoriamente() {
		throw new UnsupportedOperationException();
	}
}