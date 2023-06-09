package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.LabirintoBuilder;

class ComandoPrendiTest {
	
	private static final String ATTREZZO_INIZIALMENTE_NELLA_STANZA = "AttrezzoDaPrendere";
	private ComandoPrendi comandoPrendi;
	private Partita session;
	@BeforeEach
	void setUp() {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setIo(new IOConsole());
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.getLabirinto();
		this.session = new Partita(labirinto);
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA, 1);
		this.session.getStanzaCorrente().addAttrezzo(attrezzoNuovo);
		
	}
	
	@Test
	public void testEseguiComandoPrendiWithAttrezzooPresente() {
		this.comandoPrendi.setParametro(ATTREZZO_INIZIALMENTE_NELLA_STANZA);
		this.comandoPrendi.esegui(session);
		assertTrue(session.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
		assertFalse(session.getStanzaCorrente().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));

	
	}
	@Test
	public void testEseguiComandoWithoutAttrezzoPresente() {
		
		String nonPresente = "attrezzoNonPresente";
		this.comandoPrendi.setParametro(nonPresente);
		this.comandoPrendi.esegui(session);
		assertFalse(session.getGiocatore().getBorsa().hasAttrezzo(nonPresente));
		assertFalse(session.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
		assertTrue(session.getStanzaCorrente().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));

	
	}

	@Test
	public void testEseguiComandoPrendiWithBorsaPiena() {
		Borsa borsa = session.getGiocatore().getBorsa();
		borsa.addAttrezzo(new Attrezzo("attrezzoPesante", borsa.getPesoMax()));
		this.comandoPrendi.setParametro(ATTREZZO_INIZIALMENTE_NELLA_STANZA);
		this.comandoPrendi.esegui(session);
		assertFalse(session.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_INIZIALMENTE_NELLA_STANZA));
		
	}


}
