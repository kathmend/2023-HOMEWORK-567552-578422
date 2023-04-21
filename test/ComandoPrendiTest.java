import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.it.ambienti.Stanza;

class ComandoPrendiTest {
	private Partita session;
	private Stanza stanzaCorrente;
	private Attrezzo chiave;
	private Comando prendi;
	private FabbricaDiComandi factory;
	@BeforeEach
	void setUp() {
		this.session = new Partita();
		this.chiave = new Attrezzo("chiave",1);
		this.stanzaCorrente = session.getStanzaCorrente();
		this.stanzaCorrente.addAttrezzo(chiave);
		this.prendi = new ComandoPrendi();
		this.factory = new FabbricaDiComandiFisarmonica();
		
	}
	
	@Test
	public void testEseguiComandoPrendiWithParametro() {
		assertNull(session.getGiocatore().getBorsa().getAttrezzo("chiave"));
		prendi= factory.costruisciComando("prendi chiave");
		prendi.esegui(this.session);
		assertEquals(chiave, session.getGiocatore().getBorsa().getAttrezzo("chiave"));

	
	}
	@Test
	public void testEseguiComandoWithoutParametro() {
		
		prendi= factory.costruisciComando("prendi");
		prendi.esegui(this.session);
		assertEquals(0,this.session.getGiocatore().getBorsa().getPeso());

	
	}


}
