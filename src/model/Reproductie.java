package model ;

import java.util.ArrayList;
import java.util.List;
/**
 * Maakt reproductie opdrachten met trefwoorden
 * @author java
 *
 */
public class Reproductie  extends Opdracht 
{
	private List<String> trefwoorden;
	private int minAantalJuisteTrefwoorden;
	
	/**
	 * Default constructor
	 */
	public Reproductie() {
		super();

	}
	
	/**
	 * Constructor met extra parameters
	 * @param vraag
	 * @param juisteAntwoord
	 * @param auteur
	 * @param categorie
	 * @param trefwoorden
	 * @param minAantalJuisteTrefwoorden
	 */
	public Reproductie(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie,List<String> trefwoorden, int minAantalJuisteTrefwoorden )
	{
		super(vraag,"",auteur,categorie);		
		trefwoorden = new ArrayList<String>();
		this.minAantalJuisteTrefwoorden = minAantalJuisteTrefwoorden;
		this.setOpdrachtSoort(OpdrachtSoort.REPRODUCTIE);
	}

	public List<String> getTrefwoorden() {
		return trefwoorden;
	}

	public void setTrefwoorden(List<String> trefwoorden) {
		this.trefwoorden = trefwoorden;
	}

	public int getMinAantalJuisteTrefwoorden() {
		return minAantalJuisteTrefwoorden;
	}

	public void setMinAantalJuisteTrefwoorden(int minAantalJuisteTrefwoorden) {
		this.minAantalJuisteTrefwoorden = minAantalJuisteTrefwoorden;
	} 
	
	/**
	 * Check of antwoord is juist
	 */
	@Override
	public boolean isJuisteAntwoord(String antwoord){
		int aantalGegevenTrefwoorden =0;
		for (int i = 0;i < this.getTrefwoorden().size();i++ )
		{
			if(antwoord.toLowerCase().contains(this.getTrefwoorden().get(i).toLowerCase()))
			{
				aantalGegevenTrefwoorden++;
			}
		}
		
		if( aantalGegevenTrefwoorden >= this.getMinAantalJuisteTrefwoorden())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
