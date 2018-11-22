package osvinga;

import java.util.ArrayList;
import java.util.Random;

public class Monte {

    protected ArrayList<Carta> cartas;

    public Monte() {
        this.cartas = new ArrayList();
    }

    public ArrayList<Carta> getCartas() {
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
    
    public Carta removerCartaAleatoriamente() {
        Random random = new Random();
        int indexAleatorio = random.nextInt();
        
        return this.cartas.remove(indexAleatorio);
    }
}
