import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.Stanza;


class LabirintoTest {

	private Labirinto labirinto;
	private Stanza biblioteca;
	private Stanza atrio;
	

	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
		this.biblioteca = this.labirinto.getStanzaVincente();
		this.atrio = this.labirinto.getStanzaIniziale();
	
				
		
		
		
	}
	@Test
	void testGetStanzaVincente() {
		assertEquals(biblioteca, this.labirinto.getStanzaVincente());
	}

	@Test
	void testGetStanzaIngresso() {
		assertEquals(atrio, this.labirinto.getStanzaIniziale());
	}

}
