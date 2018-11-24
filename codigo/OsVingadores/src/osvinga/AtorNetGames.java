package osvinga;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;

public class AtorNetGames implements OuvidorProxy {

    protected Proxy _proxy;
    protected ControladorJogo _controlador;
    public ControladorJogo _unnamed_ControladorJogo_;
    public Proxy _unnamed_Proxy_;

    public int conectar(String aNomeJogador, String aNomeServidor) {
        throw new UnsupportedOperationException();
    }

    public boolean iniciarPartida() {
        throw new UnsupportedOperationException();
    }

    public boolean desconectar() {
        throw new UnsupportedOperationException();
    }

    public void enviaJogada(Mesa aMesa) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void receberMensagem(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void receberJogada(Jogada jogada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tratarConexaoPerdida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
