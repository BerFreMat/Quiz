package model;

public class OpenVraag extends Opdracht implements Valideerbaar {

	public OpenVraag() {
		// TODO Auto-generated constructor stub
	}

	public OpenVraag(String vraag, String juisteAntwoord) {
		super(vraag, juisteAntwoord);
		// TODO Auto-generated constructor stub
	}

	public OpenVraag(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie) {
		super(vraag, juisteAntwoord, auteur, categorie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValide(String antwoord) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValideerTekst() {
		// TODO Auto-generated method stub
		return null;
	}

}
