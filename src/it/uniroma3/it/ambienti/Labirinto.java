package it.uniroma3.it.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.it.ambienti.Direzione;
import it.uniroma3.it.ambienti.Labirinto;
import it.uniroma3.it.ambienti.Stanza;
import it.uniroma3.it.ambienti.StanzaBloccata;
import it.uniroma3.it.ambienti.StanzaBuia;
import it.uniroma3.it.ambienti.StanzaMagica;
import it.uniroma3.it.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	private Labirinto(String nomeFile){
		try {
			CaricatoreLabirinto caricatoreLabirinto = new CaricatoreLabirinto(nomeFile);
			caricatoreLabirinto.carica();
			this.stanzaIniziale = caricatoreLabirinto.getStanzaIniziale();
			this.stanzaVincente = caricatoreLabirinto.getStanzaVincente();
		} catch (FileNotFoundException | FormatoFileNonValidoException e) {
			e.printStackTrace();
		}
		
	}
	public Labirinto() {
		
	}
	public static LabirintoBuilder newBuilder(String nomeFile) {
		return new LabirintoBuilder(nomeFile);
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}

	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> nome2stanza;

		public LabirintoBuilder(String labirinto) {
			this.labirinto = new Labirinto(labirinto);
			this.nome2stanza = new HashMap<>();
		}
		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.nome2stanza = new HashMap<String, Stanza>();
		}
		
		public void setNome2stanza(Map<String, Stanza> nome2stanza) {
			this.nome2stanza = nome2stanza;
		}
		public Map<String, Stanza> getNome2stanza() {
			return nome2stanza;
		}
		public void setLabirinto(Labirinto labirinto) {
			this.labirinto = labirinto;
		}
		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		
		public Stanza getUltimaStanzaAggiunta() {
			return this.ultimaStanzaAggiunta;
		}
		public List<Stanza> getListaStanze() {
			return (List<Stanza>) (this.nome2stanza.values());
		}

		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza i = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(i);
			this.UltimaStanzaAggiuntaEAggiorna(i);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}
		

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}	

		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
			Attrezzo a = new Attrezzo(attrezzo, peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzione direzione) {
			Stanza c = this.nome2stanza.get(stanzaCorrente);
			Stanza a = this.nome2stanza.get(stanzaAdiecente);
			c.impostaStanzaAdiacente(direzione, a);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, Direzione.valueOf(direzioneBloccata), attrezzoSbloccante);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
			this.ultimaStanzaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}
		
	}

}
