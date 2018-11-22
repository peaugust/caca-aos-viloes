package osvinga.rede;

import osvinga.ControladorJogo;
import javax.swing.JOptionPane;

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

public class NetGames implements OuvidorProxy {

    protected Proxy proxy;
    protected ControladorJogo controlador;

    public NetGames(Controlador controlador) {
        super();
        this.controlador = controlador;
        this.proxy = Proxy.getInstance();
        proxy.addOuvinte(this);
    }

    public boolean conectar(String servidor, String nome) {
        try {
            proxy.conectar(servidor, nome);
            return true;
        } catch (JahConectadoException | NaoPossivelConectarException | ArquivoMultiplayerException e) {
            JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void desconectar() {
        try {
            proxy.desconectar();
        } catch (NaoConectadoException ex) {
            Logger.getLogger(NetGames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean iniciarPartida() {
        try {
            proxy.iniciarPartida(4);
            return true;
        } catch (NaoConectadoException ex) {
            JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), ex.getMessage());
            return false;
        }
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
        String[] jogadores = new String[]{
            this.proxy.obterNomeAdversario(1),
            this.proxy.obterNomeAdversario(2),
            this.proxy.obterNomeAdversario(3),
            this.proxy.obterNomeAdversario(4)
        };

        this.controlador.iniciarNovaPartida(posicao, jogadores);
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        this.controlador.finalizarPartidaComErro(message);
    }

    @Override
    public void receberMensagem(String msg) {
        JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), msg);
    }

    @Override
    public void receberJogada(Jogada jogada) {
        Demanda demanda = (Demanda) jogada;
        this.controlador.receberDemanda(demanda);
    }

    @Override
    public void tratarConexaoPerdida() {
        JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), "A conexão com o servidor foi perdida.");
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), message);
    }

    public void enviarJogada(Demanda jogada) {
        try {
            this.proxy.enviaJogada(jogada);
        } catch (NaoJogandoException ex) {
            JOptionPane.showMessageDialog(controlador.getJanelaAtiva(), ex.getMessage());
        }
    }
}
