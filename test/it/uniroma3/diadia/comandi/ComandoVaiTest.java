package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.LabirintoBuilder;
import it.uniroma3.it.ambienti.Stanza;

class ComandoVaiTest {
     
	private static final String NOME_STANZA_PARTENZA = "Partenza";
	private static final String NORD = "nord";
	private Partita session;
	private Comando comandoVai;
	private Stanza partenza;


	
	@BeforeEach
	public void setUp() {
	
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIo(new IOConsole());
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale(NOME_STANZA_PARTENZA)
				.getLabirinto();
		this.session= new Partita(labirinto);
		this.partenza = this.session.getStanzaCorrente();

	}

	@Test
	public void testEseguiComandoWithParametro() {
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.session);
		assertEquals(NOME_STANZA_PARTENZA, this.session.getStanzaCorrente().getNome());

	
	}
	@Test
	public void testVaiWithParametroEstanzaPresente() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(session);
		assertEquals("Destinazione", this.session.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente("sud", destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(session);
		assertEquals(NOME_STANZA_PARTENZA, this.session.getStanzaCorrente().getNome());
	}
	
	
	
	
}
