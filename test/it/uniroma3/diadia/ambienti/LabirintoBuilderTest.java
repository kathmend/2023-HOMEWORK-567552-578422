/*
package it.uniroma3.diadia.ambienti;


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


}*/

package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.it.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	Labirinto.LabirintoBuilder lb;

	@Before
	public void setUp() throws Exception {
		
		lb = new LabirintoBuilder("labirinto.txt");
	} 


	@Test
	public void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class, lb.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		lb.addStanza("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		assertEquals(expected, lb.getNome2stanza().get("stanzetta"));
	}
	

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta(){
	
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("cacciavite", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(expected, lb.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
        lb.addStanza("stanzetta");
        lb.addAttrezzo("cacciavite", 3);
        assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}


