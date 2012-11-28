/**
 * 
 */
package model;
import model.*;
import model.EenvoudigeOpdracht;

import java.util.ArrayList;
import java.util.List;

import DatumGregorian.Datum;

import exceptions.OpdrachtNietGevondenException;
import exceptions.ReedsBestaandeOpdrachtException;

/**
 * @author java
 *
 */
public class OpdrachtCatalogus extends FileContainer {
	private ArrayList<Opdracht> opdrachten;

	/**
	 * @return the opdrachten
	 */
	private ArrayList<Opdracht> getOpdrachten() {
		return opdrachten;
	}
	public OpdrachtCatalogus() {
		super();
		opdrachten = new ArrayList<Opdracht>();
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
			opdracht.setOpdrachtId(opdrachten.size());
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
	
	public void verwijderdQuizOpdracht(QuizOpdracht quizOpdracht) {
		for(Opdracht opdracht : opdrachten)
		{
			if(opdracht.getQuizOpdrachten().contains(quizOpdracht))
			{
				opdracht.verwijderdQuizOpdracht(quizOpdracht);
			}
		}
		
	}
	public Opdracht getOpdracht(int opdrachtId) {
		for(Opdracht opd : opdrachten)
		{
			if(opd.getOpdrachtId() == opdrachtId )
			return opd;
		}
		return null;
	}
	
	public Opdracht getOpdracht(QuizOpdracht quizOpdracht) {
		for(Opdracht opd : opdrachten)
		{
			if(opd.getOpdrachtId() == quizOpdracht.getOpdrachtId() )
			return opd;
		}
		return null;
	}

	
	@Override
	public String getFile() {
		return "opdracht.txt";
	}
	
	@Override
	public void deformatteerLijn(String lijn) throws Exception {
		String[] gesplit = lijn.split("#");
		Opdracht opdracht;
	//	opdracht = (Opdracht)Class.forName(OpdrachtSoort.valueOf(gesplit[0]).getKlasse()).newInstance();
		switch (OpdrachtSoort.valueOf(gesplit[0])) {
		case  EENVOUDIGE_VRAAG :
			opdracht = new EenvoudigeOpdracht();
			break;
		default:
			opdracht = null;
		}
		
		
		opdracht.maakObjectVanString(gesplit[1]);
		this.voegOpdrachtToe(opdracht);
	}
	@Override
	public List teSchrijvenLijst() {
		List teSchrijvenLijst ;
		teSchrijvenLijst = opdrachten;
		return teSchrijvenLijst;
	}
	@Override
	public String formatteerObject(Object obj) 
		{
			Opdracht opdracht = null;
			try
			{
				opdracht = (Opdracht)obj;
			}
			catch (Exception ex)
			{
				System.out.println("obj geen quiz");
			}
			
			if (opdracht != null)
			{
				return String.format("%s#%s",opdracht.getOpdrachtSoort(),opdracht.formatteerObjectNaarString());
			}
			else
			{
				return null;
			}
		}
	
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}
}
