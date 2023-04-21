package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
    private IO io;
    private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			if(this.io!=null) 
			  io.mostraMessaggio("cosa vuoi posare?");
			  io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			

		}
		else {
			Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaPosare.getNome())) {
				partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
				if(this.io!=null)
				io.mostraMessaggio("Attrezzo:" +nomeAttrezzo+ " messo nella stanza!");
			}

		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

	@Override
	public IO getIO() {
		return this.io;
	}

	@Override
	public void setIo(IO io) {
	  this.io = io;
	}
}
