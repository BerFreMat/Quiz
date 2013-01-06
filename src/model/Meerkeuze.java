package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Maakt meerkeuzevragen Subclass van Opdracht 
 * en implementeer de interface Valideerbaar
 * @author java
 *
 */
public class Meerkeuze  extends Opdracht implements Valideerbaar {

	private List<String> keuzen;
	
	public Meerkeuze(){
		
	}
	
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
		opgave = super.getVraag();
		int i = 1;
		for (String keuze:keuzen){
			opgave+=i + ". " + keuze + "\n";
			i++;			
		}
		return opgave;
	}
	
	public Meerkeuze(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie)
	{
		super(vraag,juisteAntwoord, auteur,categorie);		
		keuzen = new ArrayList<String>();
		this.setOpdrachtSoort(OpdrachtSoort.MEERKEUZE);
	}

	@Override
	public boolean isValide(String antwoord) {
		
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
	public String formatteerObjectNaarString() {
		return String.format("%s§%s",
				super.formatteerObjectNaarString(),
				this.formatteerKeuzen());
	}

	@Override
	public void maakObjectVanString(String lijn) throws Exception {
		String[] velden = lijn.split("§");
		super.maakObjectVanString(velden[0]);
		this.keuzen = this.deformatteerKeuzen(velden[1]);
	}
	
	
	
	@Override
	public String getValideerTekst() {
		return String.format("Geef je keuze door een getal in te geven tussen 1 en %d", keuzen.size())  ;		
	}
	/**
	 * Format keuzen met ";" als split teken
	 * @return
	 */
	
	private String formatteerKeuzen() {
		
		if(this.getKeuzen() != null)
		{
		  	String geformatteerdeKeuzen = new String();
			for (String keuze : this.getKeuzen()) {
				geformatteerdeKeuzen +=  keuze + ";";
			}
			return geformatteerdeKeuzen; 
		}
		else
		{
			return "null";
		}
	}
	/**
	 * Deformateer keuzen in arraylist
	 * @param keuzen
	 * @return
	 */
	private ArrayList<String> deformatteerKeuzen(String keuzen)  {
		if (!keuzen.equals("null"))
		{
			String[] keuzenGesplit = keuzen.split(";");
			ArrayList<String> keuzenLijst = new ArrayList<String>();
			for(int i = 0 ; i < keuzenGesplit.length - 1 ; i ++)
			{
				keuzenLijst.add(keuzenGesplit[i]);
			}
			return keuzenLijst;
		}
		else
		{
			return null;
		}
	}

}