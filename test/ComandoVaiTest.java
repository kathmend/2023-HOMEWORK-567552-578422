import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.it.ambienti.Stanza;

class ComandoVaiTest {
     
	private Partita session;
	private Stanza stanzaCorrente;
	private Stanza stanzaProssima;
	private Comando vai;
	private FabbricaDiComandi factory;


	
	@BeforeEach
	public void setUp() {
		session= new Partita();

		stanzaCorrente = new Stanza("biblio");
		stanzaProssima = new Stanza("bagno");
		stanzaCorrente.impostaStanzaAdiacente("nord", stanzaProssima);
		session.setStanzaCorrente(stanzaCorrente);
		vai= new ComandoVai();
		factory= new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testEseguiComandoWithParametro() {
		vai= factory.costruisciComando("vai nord");

		vai.esegui(this.session);
		assertEquals(stanzaProssima, session.getStanzaCorrente());

	
	}
	@Test
	public void testEseguiComandoWithoutParametro() {
		vai= factory.costruisciComando("vai");

		vai.esegui(this.session);
		assertEquals(stanzaCorrente, session.getStanzaCorrente());

	
	}
	
	
}
