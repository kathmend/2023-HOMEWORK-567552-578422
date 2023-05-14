import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.it.ambienti.StanzaBuia;

class StanzaBuiaTest {

	
	private StanzaBuia stanza;
	private Attrezzo lanterna;
	
	@BeforeEach
	public void setUp() {
		stanza= new StanzaBuia("stanza","lanterna");
		lanterna= new Attrezzo("lanterna", 2);
		stanza.impostaStanzaAdiacente("nord", null);
		stanza.impostaStanzaAdiacente("est", null);
		stanza.impostaStanzaAdiacente("sud", null);
		stanza.impostaStanzaAdiacente("ovest", null);
		
	}
	
	@Test
	public void testGetDescrizioneWithLanterna() {
		stanza.addAttrezzo(lanterna);
		assertEquals( "stanza\nUscite: [nord, sud, est, ovest]\nAttrezzi nella stanza: [lanterna (2kg)] ", stanza.getDescrizione());
	}
	@Test
	public void testGetDescrizioneWithoutLanterna() {
		assertEquals( "qui c'è buio pesto", stanza.getDescrizione());
	}

}
