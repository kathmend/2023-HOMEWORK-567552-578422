package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
    private IO io;
    static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa", "guarda"};
	
	
	
	@Override
	public void esegui(Partita partita) {
		
		for(int i=0; i< elencoComandi.length; i++) {
			
			io.mostraMessaggio(elencoComandi[i]+" ");
		}
		
		io.mostraMessaggio(" ");
		
	}
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub		
	}
	@Override
	public String getNome() {
		
		return "aiuto";
	}
	@Override
	public String getParametro() {
		
		return null;
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
