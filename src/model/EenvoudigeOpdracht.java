package model;
/**
 * EenvoudigeOpdracht subclass van Opdracht voor het maken van eenvoudige opdracht
 * @author java
 *
 */
public class EenvoudigeOpdracht extends Opdracht{
/**
 * constructor set OpdrachtSoort.EENVOUDIGE_VRAAG
 */
	public EenvoudigeOpdracht() {
		super();
		this.setOpdrachtSoort(OpdrachtSoort.EENVOUDIGE_VRAAG);
		
	}
/**
 * Overloaded constructor_1
 * @param vraag
 * @param juisteAntwoord
 * @param auteur
 * @param categorie
 */
	public EenvoudigeOpdracht(String vraag, String juisteAntwoord,
			Leraar auteur, OpdrachtCategorie categorie) {
		super(vraag, juisteAntwoord, auteur, categorie);
		this.setOpdrachtSoort(OpdrachtSoort.EENVOUDIGE_VRAAG);
		
	}
/**
 * Overloaded constructor_2
 * @param vraag
 * @param juisteAntwoord
 */
	public EenvoudigeOpdracht(String vraag, String juisteAntwoord) {
		super(vraag, juisteAntwoord);
		this.setOpdrachtSoort(OpdrachtSoort.EENVOUDIGE_VRAAG);
		
	}
}
