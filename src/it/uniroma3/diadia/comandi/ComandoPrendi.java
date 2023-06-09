package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando  {
	private IO io;
	private String nomeAttrezzo;
	

	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		if(attrezzoDaPrendere!=null) {
		  if(partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere)) {
			 partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			 if(this.io!=null)
			   io.mostraMessaggio("Attrezzo:" +nomeAttrezzo+ " messo nella borsa!");
			 return;
		  }
		 
		}
		if(this.io!=null)
		  io.mostraMessaggio("Attrezzo inesistente");
	    
		
	}

	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

}
