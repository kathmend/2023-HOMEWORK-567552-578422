import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;



class BorsaTest {


private Borsa borsa;
private Attrezzo attrezzo;
private Attrezzo attrezzo2;



@BeforeEach
   public void setUp() {
	   this.borsa = new Borsa();
	   this.attrezzo = new Attrezzo("osso",1);
	   this.borsa.addAttrezzo(attrezzo);
	   this.attrezzo2 = new Attrezzo("casco",1);
	   this.borsa.addAttrezzo(attrezzo2);
	   this.borsa.removeAttrezzo("casco");
	   
	   
	   
   }
	
	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("osso"));
	}

	@Test
	void testGetAttrezzo() {
		assertEquals(attrezzo,this.borsa.getAttrezzo("osso"));
	}

	@Test
	void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo("osso"));
	}

	@Test
	void testRemoveAttrezzo() {
		assertFalse(this.borsa.hasAttrezzo("casco"));
	}

}
