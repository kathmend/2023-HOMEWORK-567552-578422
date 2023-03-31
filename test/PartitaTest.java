import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.it.ambienti.Stanza;

class PartitaTest {
    

	

	
	private Partita partita;
	private Stanza biblioteca;
	private Stanza bagno;

	

	@BeforeEach
    public void setUp() {
       this.partita = new Partita();
       this.biblioteca = this.partita.getStanzaVincente();
       this.bagno = new Stanza("bagno");
       this.partita.setStanzaCorrente(bagno);
       
    	
    	
   
    }
	@Test
	void testGetStanzaVincente() {
	assertEquals(biblioteca,this.partita.getStanzaVincente());
	}

	@Test
	void testSetStanzaCorrente() {
		assertEquals(bagno,this.partita.getStanzaCorrente());
	}

	@Test
	void testGetStanzaCorrente() {
		assertEquals(bagno,this.partita.getStanzaCorrente());
	}

}
