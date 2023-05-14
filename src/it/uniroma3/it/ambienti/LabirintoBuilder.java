package it.uniroma3.it.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	private Map<String,Stanza> nome2stanza;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome2stanza = new HashMap<String, Stanza>();
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
		this.stanzaIniziale = new Stanza(nomeStanzaIniziale);
		this.labirinto.setStanzaIniziale(this.stanzaIniziale.getNome());
		this.aggiungiAMappaEAggiornaUltima(this.stanzaIniziale);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
		this.stanzaVincente= new Stanza(nomeStanzaVincente);
		this.labirinto.setStanzaVincente(this.stanzaVincente.getNome());
		this.aggiungiAMappaEAggiornaUltima(this.stanzaVincente);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
		Stanza stanzaPartenza = this.nome2stanza.get(partenza);
		Stanza stanzaAdiacente = this.nome2stanza.get(adiacente);
		stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Attrezzo a= new Attrezzo(nome, peso);
		this.ultimaAggiunta.addAttrezzo(a);
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		Stanza stanza = new Stanza(nome);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanza = new StanzaMagica(nome);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.aggiungiAMappaEAggiornaUltima(stanza);
		return this;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
		this.ultimaAggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}
	
	@Override
	public Stanza getStanzaIniziale() {
		return this.nome2stanza.get(this.stanzaIniziale.getNome());
	}

	@Override
	public Stanza getStanzaVincente() {
		return this.nome2stanza.get(this.stanzaVincente.getNome());
	}
	
	@Override
	public void setStanzaIniziale(String nome) {
		this.stanzaIniziale = new Stanza(nome);
	}
	
	@Override
	public void setStanzaVincente(String nome) {
		this.stanzaVincente = new Stanza(nome);
	}
	
	
	
}
