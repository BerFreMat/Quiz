package model;

public class Opsomming  extends Opdracht implements Valideerbaar {

	private boolean inJuisteVolgorde;
	
	public Opsomming(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie, boolean inJuisteVolgorde)
	{
		super(vraag,juisteAntwoord,auteur,categorie);
		this.inJuisteVolgorde = inJuisteVolgorde;		
	}

	public boolean isInJuisteVolgorde() {
		return inJuisteVolgorde;
	}

	public void setInJuisteVolgorde(boolean inJuisteVolgorde) {
		this.inJuisteVolgorde = inJuisteVolgorde;
	}

	@Override
	public boolean isValideerbaar(String antwoord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValideerTekst() {
		// TODO Auto-generated method stub
		return null;
	}

}
