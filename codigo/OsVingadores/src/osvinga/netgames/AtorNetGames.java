package osvinga.netgames;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import java.util.logging.Level;
import java.util.logging.Logger;
import osvinga.ControladorJogo;
import osvinga.Mesa;

public class AtorNetGames implements OuvidorProxy {

    protected Proxy proxy;
    protected ControladorJogo controlador;

    public AtorNetGames(ControladorJogo controlador) {
        super();
        this.controlador = controlador;
        this.proxy = Proxy.getInstance();
    }

    public int conectar(String aNomeJogador, String aNomeServidor) {
        proxy.addOuvinte(this);
        try {
            proxy.conectar(aNomeServidor, aNomeJogador);
        } catch (JahConectadoException e) {
            return 2;
        } catch (NaoPossivelConectarException e) {
            return 0;
        } catch (ArquivoMultiplayerException e) {
            return 3;
        }
        return 1;
    }

    public boolean iniciarPartida() {
        try {
            proxy.iniciarPartida(2);
            return true;
        } catch (NaoConectadoException ex) {
            // JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean desconectar() {
        try {
            proxy.desconectar();
            return true;
        } catch (NaoConectadoException ex) {
            Logger.getLogger(AtorNetGames.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
        Mesa mesaRecebida = (Mesa) jogada;
        this.controlador.receberEstadoDaMesa(mesaRecebida);
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
