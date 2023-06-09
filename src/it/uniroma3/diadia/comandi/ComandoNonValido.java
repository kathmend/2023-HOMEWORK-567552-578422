package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	private IO io;

	@Override
	public void esegui(Partita partita) {
		if(io!=null)
		  io.mostraMessaggio("Comando non valido");

	}

	
	@Override
	public String getNome() {
		return "comando non valido";
		
	}
	

	@Override
	public void setIo(IO io) {
		this.io = io;
		
	}

}
