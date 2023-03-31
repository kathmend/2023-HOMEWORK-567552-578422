import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
    private Giocatore giocatore;

	@BeforeEach
    public void setUp() {
    	this.giocatore = new Giocatore();
    	
    }
	 
	
	@Test
	void testGetCfu() {
		assertEquals(20,this.giocatore.getCfu());
	}

	@Test
	void testGetBorsa() {
		assertNotNull(this.giocatore.getBorsa());
	}

}
