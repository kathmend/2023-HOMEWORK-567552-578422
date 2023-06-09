package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
    private IO io;
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";
	}


	


	

	

	
}
