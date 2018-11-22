package OsVingadores;

public enum TipoArtefato {
    
    MENTE("Troca a mão de um jogador com a do outro."),
    TEMPO("Compre três cartas."),
    ESPACO("Pula a vez do adversário."),
    REALIDADE("Remove três cartas do jogador oponente."),
    PODER("Adiciona um vilão do inimigo aleatório ao seu monte de vilões");
    
    private String efeito;

    private TipoArtefato(String efeito) {
        this.efeito = efeito;
    }    
        
    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
	
        
}