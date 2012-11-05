package model ;

import java.util.ArrayList;
import java.util.List;

public class Reproductie  extends Opdracht 
{
	private List<String> trefwoorden;
	private int minAantalJuisteTrefwoorden;
	
	public Reproductie() {
		super();

	}

	public Reproductie(List<String> trefwoorden, int minAantalJuisteTrefwoorden) {
		super();
		this.trefwoorden = trefwoorden;
		this.minAantalJuisteTrefwoorden = minAantalJuisteTrefwoorden;
	}
	
	public Reproductie(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie)
	{
		super(vraag,juisteAntwoord,auteur,categorie);		
		trefwoorden = new ArrayList<String>();
		minAantalJuisteTrefwoorden = 0;
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
}
