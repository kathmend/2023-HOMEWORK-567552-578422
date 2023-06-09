package it.uniroma3.diadia.comandi;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.it.ambienti.Labirinto;


class ComandoPosaTest {
	private static final String ATTREZZO_DA_POSARE = "AttrezzoDaPosare";
	private ComandoPosa comandoPosa;
	
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	
	Labirinto labirinto;
	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		labirinto = Labirinto.newBuilder("labirinto3.txt").getLabirinto();
        partita = new Partita(labirinto);
        attrezzo = new Attrezzo("martello", 2);
        comandoPosa = new ComandoPosa();
        io = new IOConsole(new Scanner(System.in));
        comandoPosa.setIo(io);
}


@Test
public void testAttrezzoPosato() {
partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
comandoPosa.setParametro("martello");
comandoPosa.esegui(partita);
assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
}

@Test
public void testAttrezzoPosatoNull() {
comandoPosa.setParametro("martello");
comandoPosa.esegui(partita);
assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
}

 
public void creatoreAttrezzi() {
for(int i= 0; i<10;i++) {
	partita.getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
}
}

@Test
public void testTroppiAttrezzi() {
this.creatoreAttrezzi();
partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
comandoPosa.setParametro("martello");
comandoPosa.esegui(partita);
assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
}
}

