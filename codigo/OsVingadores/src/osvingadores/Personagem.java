package OsVingadores;

public class Personagem extends Carta {
    
    protected TipoPersonagem tipo;

    public Personagem(String nome, int poder, TipoPersonagem tipo) {
        super(nome,poder);
        this.tipo = tipo;
    }
    
    public TipoPersonagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersonagem tipo) {
        this.tipo = tipo;
    }
}