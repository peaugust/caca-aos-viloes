package osvinga;

public class AtorJogador {

    //Atributos:
    public InterfaceMesa interfaceMesa;
    public ControladorJogo controladorJogo;

    //Construtor:
    public AtorJogador(ControladorJogo controladorJogo) {
        this.interfaceMesa = new InterfaceMesa();
        this.controladorJogo = controladorJogo;
    }

    //Metodos:
    public InterfaceMesa getInterfaceMesa() {
        return interfaceMesa;
    }

    public void setInterfaceMesa(InterfaceMesa interfaceMesa) {
        this.interfaceMesa = interfaceMesa;
    }

    public ControladorJogo getControladorJogo() {
        return controladorJogo;
    }

    public void setControladorJogo(ControladorJogo controladorJogo) {
        this.controladorJogo = controladorJogo;
    }

    public void conectar() {
        this.controladorJogo.conectar();
    }

    public String solictarEnderecoServidor() {
        return this.interfaceMesa.solictarEnderecoServidor();
    }

    public String solicitarNomeJogador() {
        return this.interfaceMesa.solicitarNomeJogador();
    }

    public void mostrarResultadoConectar(int resultado) {
        this.interfaceMesa.mostrarResultadoConectar(resultado);
    }

    public void iniciarPartida() {
        this.controladorJogo.iniciarPartida();
    }

    public void notificarPartidaEmAndamento() {
        this.interfaceMesa.notificarPartidaEmAndamento();
    }

    public void notificarSucessoIniciarPartida() {
        this.interfaceMesa.notificarSucessoIniciarPartida();
    }

    public void notificarNaoConectado() {
        this.interfaceMesa.notificarNaoConectado();
    }

    public void desconectar() {
        this.controladorJogo.desconectar();
    }

    public void notificarDesconexao(boolean desconectou) {
        this.interfaceMesa.notificarDesconexao(desconectou);
    }

    public void passarTurno() {
        this.controladorJogo.passarTurno();
    }

    public boolean solicitarConfirmacaoPassarTurno() {
        return this.interfaceMesa.solicitarConfirmacaoPassarTurno();
    }

    public void notificarPassarTurno(boolean resultado) {
        this.interfaceMesa.notificarPassarTurno(resultado);
    }

    public void capturarVilao() {
        throw new UnsupportedOperationException();
    }

    public boolean solicitarConfirmacaoCapturarVilao() {
        throw new UnsupportedOperationException();
    }

    public Monte solicitarSelecionarHeroisCapturar() {
        throw new UnsupportedOperationException();
    }

    public void informarCaputrarVilao(boolean aMensagem) {
        throw new UnsupportedOperationException();
    }

    public void atualizarInterface(Mesa aMesa) {
        throw new UnsupportedOperationException();
    }

    public void notificarJogadorVencedor(Jogador aJogadorVencedor) {
        throw new UnsupportedOperationException();
    }

    public void usarJoia(Artefato aCartaJoia) {
        throw new UnsupportedOperationException();
    }

    public boolean confirmarUtilizacaoJoia() {
        throw new UnsupportedOperationException();
    }
}
