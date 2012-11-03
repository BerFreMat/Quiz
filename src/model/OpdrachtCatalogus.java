/**
 * 
 */
package model;

import java.util.ArrayList;

import exceptions.OpdrachtNietGevondenException;
import exceptions.ReedsBestaandeOpdrachtException;

/**
 * @author java
 *
 */
public class OpdrachtCatalogus {
	private ArrayList<Opdracht> opdrachten;

	/**
	 * @return the opdrachten
	 */
	private ArrayList<Opdracht> getOpdrachten() {
		return opdrachten;
	}
	/**
	 * @param opdrachten the opdrachten to set
	 */
	private void setopdrachten(ArrayList<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}
	
	public void voegOpdrachtToe(Opdracht opdracht) throws ReedsBestaandeOpdrachtException 
	{
		int positieOpdracht = opdrachten.indexOf(opdracht);
		
		if(positieOpdracht >= 0){
			throw new ReedsBestaandeOpdrachtException();}
		else
		{
			opdrachten.add(opdracht);
		}
	}
	
	public void verwijderOpdracht(Opdracht opdracht) throws OpdrachtNietGevondenException
	{
		//contains(Object elem)  gebruiken om na te kijken of een opdracht een QuizOpdracht is.
		//Voorlopig zonder QuizCatalogus. ==> pas aangewezen als er persistentie is toegevoegd.
		int positieOpdracht = opdrachten.indexOf(opdracht);
		
		if(positieOpdracht < 0){
			throw new OpdrachtNietGevondenException();}
		else
		{
			opdrachten.remove(positieOpdracht);
		}
	}
	public void wijzigOpdracht(Opdracht opdracht)throws OpdrachtNietGevondenException
	{
		int positieOpdracht = opdrachten.indexOf(opdracht);
		
		if(positieOpdracht < 0){
			throw new OpdrachtNietGevondenException();}
		else
		{
			opdrachten.set(positieOpdracht, opdracht);
		}	
	}	  
}
