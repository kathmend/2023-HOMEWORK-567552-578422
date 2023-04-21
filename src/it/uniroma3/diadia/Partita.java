package it.uniroma3.diadia;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.Stanza;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {


    private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Giocatore giocatore;
	
	public Partita(){
		
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.finita = false;
		this.stanzaCorrente = labirinto.getStanzaIngresso();
		this.stanzaVincente = labirinto.getStanzaVincente();
		
		
	}

   

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getGiocatore() {
		  return this.giocatore;
	}



	public boolean giocatoreIsVivo() {
		return (this.giocatore.getCfu()>0);
	}


	
}
