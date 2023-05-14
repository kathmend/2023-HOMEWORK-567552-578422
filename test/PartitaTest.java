import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.LabirintoBuilder;

class PartitaTest {
    

	

	
	private Partita session;
    private Labirinto labirinto;

	

	@BeforeEach
    public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
		this.session = new Partita(this.labirinto);
       
   
    }
	@Test
    void testVintaSeStanzaCorrenteEVincente() {
		this.session.setStanzaCorrente(this.session.getStanzaVincente());
		assertTrue(this.session.vinta());
	}
	@Test
	public void testFinitaSeCFUFiniti() {
		this.session.setCfu(0);
		assertTrue(this.session.isFinita());
	}

	@Test
    void testNonFinitaInizioPartita() {
		assertFalse(this.session.isFinita());
	}

}
