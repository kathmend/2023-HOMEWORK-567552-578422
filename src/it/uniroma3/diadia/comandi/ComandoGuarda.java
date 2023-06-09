package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando  {

	private IO io;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

	}

	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "guarda";
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		this.io = io;
	}

}
