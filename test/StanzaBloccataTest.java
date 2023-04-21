import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.it.ambienti.Stanza;
import it.uniroma3.it.ambienti.StanzaBloccata;

class StanzaBloccataTest {

	private StanzaBloccata stanza;
	private Attrezzo passPartout;
	private Stanza nord;
	private Stanza sud;
	private Stanza est;
	private Stanza ovest;
	
	@BeforeEach
	public void setUp() {
		stanza= new StanzaBloccata("checkingStanza","idrante","ovest");
		passPartout= new Attrezzo("idrante", 5);
		nord = new Stanza("nord");
		sud = new Stanza("sud");
		est= new Stanza("est");
		ovest=new Stanza("ovest");
		stanza.impostaStanzaAdiacente("nord", nord);
		stanza.impostaStanzaAdiacente("est", est);
		stanza.impostaStanzaAdiacente("sud", sud);
		stanza.impostaStanzaAdiacente("ovest", ovest);
		
	}
	
	@Test
	public void testGetDescrizionWithPassPartout() {
		stanza.addAttrezzo(passPartout);
		assertEquals(ovest.getDescrizione(),stanza.getDescrizione());
	}		

	@Test
	public void testGetDescrizioneWithoutPassPartout() {
		assertEquals("Stanza Bloccata", stanza.getDescrizione());
	}

	@Test
	public void testGetStanzaAdiacenteWithPassPartout() {
		stanza.addAttrezzo(passPartout);
		assertEquals(ovest ,stanza.getStanzaAdiacente("ovest"));
		
	}
	@Test
	public void testGetStanzaAdiacenteWithoutPassPartout() {
		
		assertEquals( stanza,stanza.getStanzaAdiacente("ovest"));
		
	}

}
