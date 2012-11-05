package model;

import java.util.ArrayList;
import java.util.List;

public class Meerkeuze  extends Opdracht implements Valideerbaar {

	private List<String> keuzen;
	
	public List<String> getKeuzen() {
		return keuzen;
	}

	public void setKeuzen(List<String> keuzen) {
		this.keuzen = keuzen;
	}
	
	public Meerkeuze(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie)
	{
		super(vraag,juisteAntwoord,auteur,categorie);		
		keuzen = new ArrayList<String>();
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
