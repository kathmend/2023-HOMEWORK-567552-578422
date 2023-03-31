package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.it.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi", "posa"};

	private Partita partita;
	private Giocatore giocatore;
	private IOConsole io;

	public DiaDia(IOConsole console) {
		this.io = console;
		this.partita = new Partita();
	}
	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do	{	
			istruzione = io.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando daEseguire = new Comando(istruzione);
       if(daEseguire.getNome()!= null) {
		if (daEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (daEseguire.getNome().equals("vai"))
			this.vai(daEseguire.getParametro());
		else if (daEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (daEseguire.getNome().equals("prendi"))
			this.prendi(daEseguire.getParametro());
		else if (daEseguire.getNome().equals("posa"))
			this.posa(daEseguire.getParametro());
       }
		else
			io.mostraMessaggio("Comando sconosciuto");
       
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
       
      
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		
		io.mostraMessaggio("");
	}
	
	private void prendi(String nomeAttrezzo) {
		Attrezzo attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(attrezzoDaPrendere!=null) {
		  if(this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere)) {
			 this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			 io.mostraMessaggio("Attrezzo:" +nomeAttrezzo+ " messo nella borsa!");
			 return;
		  }
		 
		}
		io.mostraMessaggio("Attrezzo inesistente");
	    
	}
	
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			io.mostraMessaggio("cosa vuoi posare?");
			io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		  
		}
		else {
			Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaPosare.getNome())) {
			  this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			  io.mostraMessaggio("Attrezzo:" +nomeAttrezzo+ " messo nella stanza!");
			}
			
	   }
    }

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			io.mostraMessaggio("Stanza Corrente: " + partita.getStanzaCorrente().getDescrizione());
		    return;
		}
		    
		    Stanza prossimaStanza = null;
	         prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		    if (prossimaStanza == null)
		    	io.mostraMessaggio("Direzione inesistente");
		    else {
			    this.partita.setStanzaCorrente(prossimaStanza);
			    if(this.giocatore!=null) {
			      int cfu = this.giocatore.getCfu();
			      this.giocatore.setCfu(cfu--);
			    }
		    }
		    io.mostraMessaggio("Stanza Corrente: " + partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	  
		
		
		
	}
}