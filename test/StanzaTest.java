import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.it.ambienti.Stanza;

class StanzaTest {

	private Stanza stanza;
	private Attrezzo attrezzo;
	private Stanza stanzaDue;
	private Attrezzo attrezzo2;

	@BeforeEach
	public void setUp() {
		this.stanza = new Stanza("Atrio");
		this.attrezzo = new Attrezzo("spada",2);
		this.stanza.addAttrezzo(attrezzo);
		this.attrezzo2 = new Attrezzo("casco",1);
		this.stanzaDue = new Stanza("Bagno");
		this.stanzaDue.addAttrezzo(attrezzo2);
		this.stanzaDue.removeAttrezzo(attrezzo2);
		
	}
	@Test
	void testAddAttrezzo() {
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}

	@Test
	void testHasAttrezzo() {
		assertFalse(this.stanzaDue.hasAttrezzo("spada"));
	}

	@Test
	void testGetAttrezzo() {
		assertEquals(attrezzo, this.stanza.getAttrezzo("spada"));
	}

	@Test
	void testRemoveAttrezzo() {
		assertFalse(this.stanzaDue.hasAttrezzo("casco"));
	}

}
