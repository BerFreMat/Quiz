package model;

public class EenvoudigeOpdracht extends Opdracht{

	public EenvoudigeOpdracht() {
		super();
		this.setOpdrachtSoort(OpdrachtSoort.EENVOUDIGE_VRAAG);
		// TODO Auto-generated constructor stub
	}

	public EenvoudigeOpdracht(String vraag, String juisteAntwoord,
			Leraar auteur, OpdrachtCategorie categorie) {
		super(vraag, juisteAntwoord, auteur, categorie);
		this.setOpdrachtSoort(OpdrachtSoort.EENVOUDIGE_VRAAG);
		// TODO Auto-generated constructor stub
	}

	public EenvoudigeOpdracht(String vraag, String juisteAntwoord) {
		super(vraag, juisteAntwoord);
		this.setOpdrachtSoort(OpdrachtSoort.EENVOUDIGE_VRAAG);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	

}
