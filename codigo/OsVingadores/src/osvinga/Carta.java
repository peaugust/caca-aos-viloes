package osvinga;

public class Carta {
	protected String nome;
	protected int poder;

    public Carta(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }
        
        

	public int getPoder() {
		return this.poder;
	}

	public String getNome() {
		return this.nome;
	}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
        
        
}