

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.it.ambienti.LabirintoBuilder;
import it.uniroma3.it.ambienti.Stanza;

class LabirintoBuilderTest {
	private LabirintoBuilder labirinto;
	@BeforeEach
	void setUp() {
		this.labirinto = new LabirintoBuilder();
	}

	@Test
	void testAddStanzaIniziale() {
		this.labirinto.addStanzaIniziale("StanzaUno");
		assertEquals("StanzaUno",this.labirinto.getStanzaIniziale().getNome());
	}

	@Test
	void testAddStanzaVincente() {
		this.labirinto.addStanzaVincente("StanzaVincente");
		assertEquals("StanzaVincente", this.labirinto.getStanzaVincente().getNome());
	}

	@Test
	void testAddAdiacenza() {
		Stanza StanzaIniziale = new Stanza("StanzaDiInizio");
		Stanza StanzaAdiacente = new Stanza("StanzaAdiacente");
		StanzaIniziale.impostaStanzaAdiacente("direzioneArrivo", StanzaAdiacente);
		assertEquals("StanzaAdiacente",StanzaIniziale.getStanzaAdiacente("direzioneArrivo").getNome());
		
	}

	@Test
	void testAddAttrezzo() {
		this.labirinto = new LabirintoBuilder();
		Stanza stanzaInizial = new Stanza("StanzaUno");
		this.labirinto.addStanzaIniziale(stanzaInizial.getNome());
		this.labirinto.addAttrezzo("casco",2);
		stanzaInizial.hasAttrezzo("casco");
	}

	@Test
	void testAddStanza() {
		this.labirinto.addStanza("StanzaAggiunta");
		assertNotNull(this.labirinto);
	
	}


}
