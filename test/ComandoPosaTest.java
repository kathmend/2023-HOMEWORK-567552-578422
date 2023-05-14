import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.LabirintoBuilder;

class ComandoPosaTest {
	private static final String ATTREZZO_DA_POSARE = "AttrezzoDaPosare";
	private ComandoPosa comandoPosa;
	private Partita session;
	@BeforeEach
	void setUp() {
		
			this.comandoPosa = new ComandoPosa();
			this.comandoPosa.setIo(new IOConsole());
			Labirinto labirinto = new LabirintoBuilder()
					.addStanzaIniziale("iniziale")
					.getLabirinto();
			this.session = new Partita(labirinto);
			Borsa borsa = session.getGiocatore().getBorsa();
			Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_DA_POSARE, 1);
			borsa.addAttrezzo(attrezzoNuovo);

	}
	@Test
	public void testEseguiComandoPrendiWithconAttrezzoPresente() {
		this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
		this.comandoPosa.esegui(session);
		assertTrue(session.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
		assertFalse(session.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));

	
	}
	@Test
	public void testEseguiComandoConAttrezzoNonPresente() {
		String nonPresente = "attrezzoNonPresente";
		this.comandoPosa.setParametro(nonPresente);
		this.comandoPosa.esegui(session);
		assertFalse(session.getStanzaCorrente().hasAttrezzo(nonPresente));
		assertFalse(session.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
		assertTrue(session.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
	
	}

	public void testEseguiComandoPosaConStanzaPiena() {
			String nonPresente = "attrezzoNonPresente";
			this.comandoPosa.setParametro(nonPresente);
			this.comandoPosa.esegui(session);
			assertFalse(session.getStanzaCorrente().hasAttrezzo(nonPresente));
			assertFalse(session.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
			assertTrue(session.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
		
		}
	
}
