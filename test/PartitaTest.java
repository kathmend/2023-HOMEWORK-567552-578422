
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.Stanza;
class PartitaTest {

    private Labirinto labirinto;
    Partita p;
	Stanza s;
	

	@Before
    public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
       
   
    }
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}



}
