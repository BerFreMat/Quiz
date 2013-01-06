package model;
/**
 * Sorteer opdracht in juiste volgorde, subclass van Opdracht en implementeer interface Valideerbaar
 * @author java
 *
 */
public class Opsomming  extends Opdracht implements Valideerbaar {

	private boolean inJuisteVolgorde;
	/**
	 * generieke constructor
	 */
	public Opsomming(){
		
	}
	/**
	 * overloaded constructor1 met vraag, juiste antwoord, auteur en categorie
	 * @param vraag
	 * @param juisteAntwoord
	 * @param auteur
	 * @param categorie
	 * @param inJuisteVolgorde
	 */
	public Opsomming(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie, boolean inJuisteVolgorde)
	{
		super(vraag,juisteAntwoord,auteur,categorie);
		this.inJuisteVolgorde = inJuisteVolgorde;
		this.setOpdrachtSoort(OpdrachtSoort.OPSOMMING);
	}

	public boolean isInJuisteVolgorde() {
		return inJuisteVolgorde;
	}

	public void setInJuisteVolgorde(boolean inJuisteVolgorde) {
		this.inJuisteVolgorde = inJuisteVolgorde;
	}

	/**
	 * Gaat na of een String een gescheiden door ";" het juiste aantal antwoorden bevat. 
	 */
	@Override
	public boolean isValide(String antwoord) {
		String[] gesplitteAntwoorden;
		gesplitteAntwoorden =  antwoord.split(";");
		if(gesplitteAntwoorden.length != this.getjuisteAntwoord().split(";").length )
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public String getValideerTekst() {
		return "Typ je antwoorden achter elkaar gescheiden door ;";
	}
}