import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class ComandoPosaTest {
	private Partita session;
	private Attrezzo chiave;
	private Comando posa;
	private FabbricaDiComandi factory;
	@BeforeEach
	void setUp() {
		session= new Partita();

		chiave= new Attrezzo("chiave",1);
		session.getStanzaCorrente();
		this.session.getGiocatore().getBorsa().addAttrezzo(chiave);
		posa= new ComandoPosa();
		factory= new FabbricaDiComandiFisarmonica();


	}
	@Test
	public void testEseguiComandoPrendiWithParametro() {
		assertNull(session.getStanzaCorrente().getAttrezzo("chiave"));
		posa= factory.costruisciComando("posa chiave");

		posa.esegui(this.session);
		assertEquals(chiave, session.getStanzaCorrente().getAttrezzo("chiave"));

	
	}
	@Test
	public void testEseguiComandoWithoutParametro() {
		assertEquals(false ,session.getStanzaCorrente().hasAttrezzo("chiave"));
		posa= factory.costruisciComando("posa");

		posa.esegui(this.session);
		assertEquals(false ,session.getStanzaCorrente().hasAttrezzo("chiave"));

	
	}

}
