package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
    private IO io;
    static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa", "guarda"};
	

    @Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIo().mostraMessaggio(elencoComandi[i]+" ");
		this.getIo().mostraMessaggio("");
	}
	
	
	@Override
	public String getNome() {
		
		return "aiuto";
	}

}
