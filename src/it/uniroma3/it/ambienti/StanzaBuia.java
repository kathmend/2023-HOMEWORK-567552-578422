package it.uniroma3.it.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzo;
    public StanzaBuia(String nome, String attrezzoMust) {
		super(nome);
		this.attrezzo = attrezzoMust;
	}

	@Override
	public String getDescrizione() {
        if(this.hasAttrezzo(attrezzo))   
            return this.toString();
        
	    return ("qui c'è buio pesto");
    }
	
}
