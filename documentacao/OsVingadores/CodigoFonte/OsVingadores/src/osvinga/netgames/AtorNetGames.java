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
import javax.swing.JOptionPane;
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
            return false;
        } catch (NaoConectadoException ex) {
            ex.printStackTrace();
            this.receberMensagem(ex.getMessage());
            return true;
        }
    }
    
    public boolean desconectar() {
        try {
            proxy.desconectar();
            return true;
        } catch (NaoConectadoException ex) {
            this.receberMensagem(ex.getMessage());
            Logger.getLogger(AtorNetGames.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void enviaJogada(Mesa aMesa) {
        try {
            proxy.enviaJogada(aMesa);
        } catch (NaoJogandoException ex) {
            this.receberMensagem(ex.getMessage());
        }
    }
    
    @Override
    public void iniciarNovaPartida(Integer posicao) {
        String[] nomeJogadores = new String[2];
        nomeJogadores[0] = proxy.getNomeJogador();
        nomeJogadores[1] = proxy.obterNomeAdversarios().get(0);
        this.controlador.receberSolicitacaoDeInicio(posicao, nomeJogadores);
    }
    
    @Override
    public void finalizarPartidaComErro(String message) {
        this.receberMensagem(message);
    }
    
    @Override
    public void receberMensagem(String msg) {
        JOptionPane.showMessageDialog(this.controlador.getAtorJogador().getInterfaceMesa(), msg);
    }
    
    @Override
    public void receberJogada(Jogada jogada) {
        Mesa mesaRecebida = (Mesa) jogada;
        this.controlador.receberEstadoDaMesa(mesaRecebida);
    }
    
    @Override
    public void tratarConexaoPerdida() {
        this.receberMensagem("A conexão foi Perdida");
    }
    
    @Override
    public void tratarPartidaNaoIniciada(String message) {
        this.receberMensagem(message);
    }
}
