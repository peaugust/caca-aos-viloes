package Osvingadores;

import Osvingadores.Artefato;
import Osvingadores.Carta;
import Osvingadores.Monte;
import osvingadores.Jogador;
import osvingadores.Mesa;

public class ControladorJogo {
	protected Mesa _mesa;
	protected String _nomeJogador;
	protected boolean _conectado;
	public AtorJogador _atorJogador_;
	public Mesa _mesa_;
	public AtorNetGames _atorNetGames_;

	public int conectar() {
		throw new UnsupportedOperationException();
	}

	public boolean isConectado() {
		return this._conectado;
	}

	public void setNomeJogador(String aNomeJogador) {
		this._nomeJogador = aNomeJogador;
	}

	public void iniciarPartida() {
		throw new UnsupportedOperationException();
	}

	public Mesa getMesa() {
		return this._mesa;
	}

	public boolean getPartidaEmAndamento() {
		throw new UnsupportedOperationException();
	}

	public boolean desconectar() {
		throw new UnsupportedOperationException();
	}

	public boolean passarTurno() {
		throw new UnsupportedOperationException();
	}

	public boolean verificarJogadorDoTurno() {
		throw new UnsupportedOperationException();
	}

	public boolean capturarVilao(Monte aCartasCapturar, Carta aVilao) {
		throw new UnsupportedOperationException();
	}

	public int calcularSomatorioDePoder(Monte aCartasCapturar) {
		throw new UnsupportedOperationException();
	}

	public Jogador recuperarInstanciaJogador() {
		throw new UnsupportedOperationException();
	}

	public void receberEstadoDaMesa(Mesa aMesa) {
		throw new UnsupportedOperationException();
	}

	public boolean verificarEstadoDoJogo() {
		throw new UnsupportedOperationException();
	}

	public void setMesa(Mesa aMesa) {
		this._mesa = aMesa;
	}

	public boolean verificarEstadoJogo() {
		throw new UnsupportedOperationException();
	}

	public boolean cartaLocalizadaEmMaos() {
		throw new UnsupportedOperationException();
	}

	public void usarJoia(Artefato aCartaJoia) {
		throw new UnsupportedOperationException();
	}

	public void verificarQualArtefato(Artefato aCarta) {
		throw new UnsupportedOperationException();
	}

	public void atualizarEstadoJogo() {
		throw new UnsupportedOperationException();
	}

	public void enviarJogada(Mesa aMesa) {
		throw new UnsupportedOperationException();
	}
}