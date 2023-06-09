package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.it.ambienti.StanzaBuia;

class StanzaBuiaTest {

	
	private StanzaBuia stanza;
	private Attrezzo candela;
	@Before
	public void setUp() throws Exception {
		this.candela = new Attrezzo("Candela", 1);
		this.stanza = new StanzaBuia("StanzaBuia", "Candela");
		
	}

	

	@Test
	public void testGetDescrizioneConAttrezzo() {
		this.stanza = new StanzaBuia("StanzaBuia", "Candela");
		this.candela = new Attrezzo("Candela", 1);
		stanza.addAttrezzo(candela);
		assertEquals(stanza.getDescrizione().toString(),stanza.getDescrizione());
		
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		this.stanza = new StanzaBuia("StanzaBuia", "lumino");
		String e = "qui c'è buio pesto";
		assertEquals(e, stanza.getDescrizione());
	}

}
