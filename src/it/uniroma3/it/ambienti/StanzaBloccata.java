package it.uniroma3.it.ambienti;

import it.uniroma3.it.ambienti.Stanza;
import it.uniroma3.it.ambienti.Direzione;

public class StanzaBloccata extends Stanza{
	
	private Direzione nsePassa;
	private String passPartout;

	public StanzaBloccata(String nome, Direzione direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.nsePassa = direzioneBloccata;
		this.passPartout = attrezzoSbloccante;
	}

	

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(nsePassa.equals(direzione) && !super.hasAttrezzo(this.passPartout)) 
			return this;
		return super.getStanzaAdiacente(nsePassa);
		   
		
			
		
	    
	}
	
	
	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ nsePassa +"\nPrendi il " +passPartout + " e posalo nella stanza";

		if(!this.hasAttrezzo(passPartout))
			return bloccata;
		return super.getDescrizione();
	}
}
