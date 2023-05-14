package it.uniroma3.diadia.giocatore;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private int pesoMax;
	private Map<String, Attrezzo> attrezzi;
	private int pesoAttuale;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
		this.pesoAttuale = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
			
	}
	public int getPeso() {
		return this.pesoAttuale;
	}
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo))
			this.pesoAttuale = this.pesoAttuale - this.attrezzi.get(nomeAttrezzo).getPeso();
		return this.attrezzi.remove(nomeAttrezzo);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.attrezzi.values().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> listaOrdinataPerPeso = new LinkedList<Attrezzo>();
		listaOrdinataPerPeso.addAll(this.attrezzi.values());
		Collections.sort(listaOrdinataPerPeso,new ComparatoreAttrezziPerPeso());
		return listaOrdinataPerPeso;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<>(this.attrezzi.values());
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> attrezzi = new HashMap<>();
		for(Attrezzo attrezzo : this.attrezzi.values()) {
			Set<Attrezzo> attrezziPeso = attrezzi.get(attrezzo.getPeso());
			if(attrezziPeso == null) {
				attrezziPeso = new HashSet<>();
				attrezzi.put(attrezzo.getPeso(), attrezziPeso);
			}
			attrezziPeso.add(attrezzo);
		}
		return attrezzi;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> attrezziPerPeso = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		attrezziPerPeso.addAll(this.attrezzi.values());
		return attrezziPerPeso;
	}
	
}
