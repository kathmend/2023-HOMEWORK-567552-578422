package it.uniroma3.it.ambienti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.it.ambienti.Direzione;
import it.uniroma3.it.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	private Map<String,Attrezzo> attrezzi;
	
	private Map<Direzione, Stanza> direzionistanze;
	private AbstractPersonaggio personaggio;
	private int numeroAttrezzi;
  
    
    private int numeroStanzeAdiacenti;
	private String[] direzioni;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
    	this.nome = nome;

		this.direzionistanze = new HashMap<Direzione,Stanza>();
		this.attrezzi = new HashMap<String,Attrezzo>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    /**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean aggiornato = false;
	   if(this.direzionistanze!=null) {
		if (direzionistanze.containsKey(direzione)) {
			this.direzionistanze.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzionistanze.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	   }
	}
    

    
    
  
    
    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione*/
     
    public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
	  if(this.direzionistanze!=null) {
		if (this.direzionistanze.containsKey(direzione))
			stanza = this.direzionistanze.get(direzione);
	  }
		return stanza;
	}
	
	
	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : direzionistanze.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
	public Map<String,Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if(attrezzo!=null && this.attrezzi.size()<NUMERO_MASSIMO_ATTREZZI)
			this.attrezzi.put(attrezzo.getNome(),attrezzo);
		if(attrezzo!=null && attrezzi.get(attrezzo.getNome()) != null)
			return true;
		else
			return false;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.direzionistanze.keySet());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(attrezzi.values().toString()+" ");
	
		return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		
		Attrezzo attrezzoRimosso=this.attrezzi.remove(attrezzo.getNome());
		if(attrezzoRimosso!=null)
			return true;
		else
			return false;
		
	}

	public Stanza getAdiacenze(String direzione) {
		return this.direzionistanze.get(direzione);
	}
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}
	public void setPersonaggio(AbstractPersonaggio ap) {
		this.personaggio = ap;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
		
	}

}