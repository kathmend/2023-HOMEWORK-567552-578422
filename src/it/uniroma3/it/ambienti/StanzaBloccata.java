package it.uniroma3.it.ambienti;

public class StanzaBloccata extends Stanza{
	private String nsePassa;
	private String passPartout;
	
	public StanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		super(nome);
		this.nsePassa= direzioneBloccata;
		this.passPartout= attrezzoSbloccante;
	}
	
	

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.nsePassa) && !super.hasAttrezzo(this.passPartout))
			return this;
	    return super.getStanzaAdiacente(nsePassa);
	}
	@Override
	public String getDescrizione() {
		if(!super.hasAttrezzo(this.passPartout))
			return ("Stanza Bloccata");
		return this.getStanzaAdiacente(nsePassa).toString();
	}
}
