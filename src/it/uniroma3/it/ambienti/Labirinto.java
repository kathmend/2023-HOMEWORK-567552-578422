package it.uniroma3.it.ambienti;


public class Labirinto {
	private Stanza stanzaIngresso;
	private Stanza stanzaVincente;
	
	 

	public Stanza getStanzaIniziale() {
		return this.stanzaIngresso;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaIniziale(String stanzaIngresso) {
		this.stanzaIngresso = new Stanza(stanzaIngresso);
	}

	public void setStanzaVincente(String stanzaVincente) {
		this.stanzaVincente = new Stanza(stanzaVincente);
	}
}
