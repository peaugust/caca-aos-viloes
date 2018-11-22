package OsVingadores;

import java.util.ArrayList;

public class Monte {

    protected ArrayList<Carta> cartas;

    public Monte() {
        this.cartas = new ArrayList();
    }

    public ArrayList getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList cartas) {
        this.cartas = cartas;
    }

    public int calcularSomatorioDePoder() {
        int somatorio = 0;
        for (Carta carta : cartas) {
            somatorio = somatorio + carta.getPoder();
        }

        return somatorio;
    }

    public void removerCarta(Carta carta) {
        this.cartas.remove(carta);
    }

    public int tamanhoMonte() {
        return this.cartas.size();
    }

    public Carta comprarCarta() {
        return this.cartas.remove(this.cartas.size() - 1);
    }

    public void adicionarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    public Carta removerCarta(int index) {
        return this.cartas.remove(index);
    }
}
