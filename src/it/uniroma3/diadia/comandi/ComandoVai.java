package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.it.ambienti.Direzione;
import it.uniroma3.it.ambienti.Stanza;

public class ComandoVai extends AbstractComando  {
	private Direzione direzione;
	private IO io;
	
	
	@Override
	public void esegui(Partita partita) {
		if(direzione==null) {
			if(io!=null) {
			  io.mostraMessaggio("Dove vuoi andare ?");
			  io.mostraMessaggio("Stanza Corrente: " + partita.getStanzaCorrente().getDescrizione());
			}
			return;
		}

		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			if(io!=null)
			  io.mostraMessaggio("Direzione inesistente");
		   return;
		}
		else {
			partita.setStanzaCorrente(prossimaStanza);
			if(partita.getGiocatore()!=null) {
				int cfu = partita.getGiocatore().getCfu();
				partita.getGiocatore().setCfu(cfu--);
			}
		}
		if(io!=null)
		  io.mostraMessaggio("Stanza Corrente: " + partita.getStanzaCorrente().getDescrizione());
	}

	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}
	

}
