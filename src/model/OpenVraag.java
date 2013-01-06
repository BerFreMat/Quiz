package model;
/**
 * Class open vraag, subclass van opdracht en implementeer interface valideerbaar
 * @author java
 *
 */
public class OpenVraag extends Opdracht implements Valideerbaar {
/**
 * generiek constructor
 */
	public OpenVraag() {}
/**
 * Overloaded constructor1 met vraag en juiste antwoord
 * @param vraag
 * @param juisteAntwoord
 */
	public OpenVraag(String vraag, String juisteAntwoord) {
		super(vraag, juisteAntwoord);
		
	}
/**
 * Overloaded constructor2 met vraag, juiste antwoord, auteur en categorie
 * @param vraag
 * @param juisteAntwoord
 * @param auteur
 * @param categorie
 */
	public OpenVraag(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie) {
		super(vraag, juisteAntwoord, auteur, categorie);
		
	}

	@Override
	public boolean isValide(String antwoord) throws Exception {
		
		return false;
	}

	@Override
	public String getValideerTekst() {
		
		return null;
	}

}
