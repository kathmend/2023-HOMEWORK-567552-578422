package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.it.ambienti.StanzaMagica;

class StanzaMagicaTest {
	private StanzaMagica magicRoom;
	private Attrezzo martello;

	private Attrezzo forbici;
	
	@BeforeEach
	public void setUp() {
		magicRoom= new StanzaMagica("magic", 1);
		martello= new Attrezzo("martello",3);

		forbici= new Attrezzo("forbici",1);
	}
	@Test
	public void testAddAttrezzoUnAttrezzoNoReaction() {
		assertNull( magicRoom.getAttrezzo("forbici"));
		magicRoom.addAttrezzo(forbici);
		assertEquals(forbici, magicRoom.getAttrezzo("forbici"));
	}
	@Test
	public void testAddAttrezzoDueAttrezziWithReaction() {
		magicRoom.addAttrezzo(forbici);
		magicRoom.addAttrezzo(martello);
		assertEquals("forbici (1kg)", magicRoom.getAttrezzo("forbici").toString());
		assertEquals(forbici, magicRoom.getAttrezzo("forbici"));
		assertTrue(magicRoom.hasAttrezzo("olletram"));
		assertEquals("olletram (6kg)", magicRoom.getAttrezzo("olletram").toString());
	}

	

}
