package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
    private FabbricaDiComandi factory;
    private Comando comandoDiTest;
	@BeforeEach
	void setUp()  {
		factory = new FabbricaDiComandiFisarmonica();
	}
	@Test
	public void testCostruisciComandoAiuto() {
		comandoDiTest=factory.costruisciComando("aiuto");
		assertEquals( "aiuto", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoFine() {
		comandoDiTest=factory.costruisciComando("fine");
		assertEquals( "fine", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoGuarda() {
		comandoDiTest=factory.costruisciComando("guarda");
		assertEquals( "guarda", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoNonValido() {
		comandoDiTest=factory.costruisciComando("impiccati");
		assertEquals( "comando non valido", comandoDiTest.getNome());
	}
	@Test
	public void testCostruisciComandoVaiWithoutParametro() {
		comandoDiTest=factory.costruisciComando("vai");
		assertEquals( "vai", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoVaiWithParametro() {
		comandoDiTest=factory.costruisciComando("vai nord");
		assertEquals("vai", comandoDiTest.getNome());
		assertEquals("nord",comandoDiTest.getParametro() );
	}
	@Test
	public void testCostruisciComandoPrendiWithoutParametro() {
		comandoDiTest=factory.costruisciComando("prendi");
		assertEquals("prendi", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoPrendiWithParametro() {
		comandoDiTest=factory.costruisciComando("prendi bottino");
		assertEquals( "prendi", comandoDiTest.getNome());
		assertEquals("bottino",comandoDiTest.getParametro() );
	}
	@Test
	public void testCostruisciComandoPosaWithoutParametro() {
		comandoDiTest=factory.costruisciComando("posa");
		assertEquals( "posa", comandoDiTest.getNome());
		assertNull(comandoDiTest.getParametro());
	}
	@Test
	public void testCostruisciComandoPosaWithParametro() {
		comandoDiTest=factory.costruisciComando("posa malloppo");
		assertEquals( "posa", comandoDiTest.getNome());
		assertEquals("malloppo",comandoDiTest.getParametro() );
	}

	
}
