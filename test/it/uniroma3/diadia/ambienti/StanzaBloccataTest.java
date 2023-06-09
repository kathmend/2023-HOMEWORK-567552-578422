package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.it.ambienti.Direzione;
import it.uniroma3.it.ambienti.Stanza;
import it.uniroma3.it.ambienti.StanzaBloccata;

class StanzaBloccataTest {

	private StanzaBloccata sb;
	private Stanza s;
	private Attrezzo a;
	
	
	@BeforeEach
	public void setUp() {
		sb= new StanzaBloccata("checkingStanza",Direzione.nord,"palla");
		sb.impostaStanzaAdiacente(Direzione.nord, s);
		s = new Stanza("Stanzetta");
		a = new Attrezzo("palla", 1);
		
		
		
		
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		
		assertEquals(sb, sb.getStanzaAdiacente(Direzione.nord));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		
		
		sb.impostaStanzaAdiacente(Direzione.nord, s);
		sb.addAttrezzo(a);
		assertEquals(s, sb.getStanzaAdiacente(Direzione.nord));
		
	}

	

}
