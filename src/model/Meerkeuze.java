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
	
	@Override
	public String getVraag()
	{
		String opgave ="";
		opgave = super.getVraag() + "\n";
		int i = 1;
		for (String keuze:keuzen){
			opgave+=i + ". " + keuze + "\n";
			i++;			
		}
		return opgave;
	}
	
	public Meerkeuze(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie, int opdrachtId)
	{
		super(vraag,juisteAntwoord,auteur,categorie, opdrachtId);		
		keuzen = new ArrayList<String>();
		this.setOpdrachtSoort(OpdrachtSoort.MEERKEUZE);
	}

	@Override
	public boolean isValide(String antwoord) {
		// TODO Auto-generated method stub
		try
		{
			int keuze;
			keuze =	Integer.parseInt(antwoord);
			if(keuze > 0 && keuze <= keuzen.size())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception Ex)
		{
			return false;
		}
	}

	@Override
	public String getValideerTekst() {
		return String.format("Geef je keuze door een getal in te geven tussen 1 en %d", keuzen.size())  ;		
	}
	
	
	

}
