package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;


import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.Stanza;


class LabirintoTest {

	Labirinto l;
	Stanza Aula11;
	Stanza Biblioteca;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		Aula11 = new Stanza("Aula 11");
		Biblioteca = new Stanza("Biblioteca");
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Aula 11", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(Biblioteca);
		assertEquals(Biblioteca, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}


}
