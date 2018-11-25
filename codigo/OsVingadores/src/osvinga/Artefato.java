package osvinga;

public class Artefato extends Carta {

    //Atributos:
    protected TipoArtefato tipo;

    //Construtor:
    public Artefato(String nome, int poder, TipoArtefato tipo) {
        super(nome, poder);
        this.tipo = tipo;
    }

    //Metodos:
    public TipoArtefato getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoArtefato tipo) {
        this.tipo = tipo;
    }

}
