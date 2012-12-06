/**
 * 
 */
package model;
import model.*;

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
	public ArrayList<Opdracht> getOpdrachten() {
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
			opdracht.setOpdrachtId(this.getMaxOpdrachtId()+1);
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
		case  MEERKEUZE :
			opdracht = new Meerkeuze();
			break;
		case  OPSOMMING :
			opdracht = new Opsomming();
			break;
		case  REPRODUCTIE :
			opdracht = new Reproductie();
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
	
	
	public List<Opdracht> getOpdrVanType(OpdrachtSoort opdrachtsoort)
	{
		List<Opdracht> opdrachtenVanType = new ArrayList<Opdracht>();
		if (opdrachtsoort != null 
				&&	this.getOpdrachten() != null 
				&&	this.getOpdrachten().size() > 0)
		{
			for(Opdracht opdracht : this.getOpdrachten())
			{
				if (opdracht.getOpdrachtSoort().equals(opdrachtsoort))
				{
					opdrachtenVanType.add(opdracht);
				}
			}
		}
		return opdrachtenVanType;
	}	
	
	public List<Opdracht> getOpdrVanCategorie(OpdrachtCategorie opdrachtCategorie)
	{
		List<Opdracht> opdrachtenVanCategorie = new ArrayList<Opdracht>();
		if (opdrachtCategorie != null 
				&&	this.getOpdrachten() != null 
				&&	this.getOpdrachten().size() > 0)
		{
			for(Opdracht opdracht : this.getOpdrachten())
			{
				if (opdracht.getCategorie() != null &&
						opdracht.getCategorie().equals(opdrachtCategorie))
				{
					opdrachtenVanCategorie.add(opdracht);
				}
			}
		}
		return opdrachtenVanCategorie;
	}
	
	public void voegQuizToe(Quiz quiz) {
		if (quiz != null)
		{
			if(quiz.getQuizOpdrachten() != null && quiz.getQuizOpdrachten().size() > 0)
			{
				for(QuizOpdracht quizOpdracht : quiz.getQuizOpdrachten())
				{
					getOpdracht(quizOpdracht.getOpdrachtId()).voegQuizOpdrachtToe(quizOpdracht);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}
	
	public int getMaxOpdrachtId()
	{
		int i = 0;
		for (Opdracht opdracht : this.opdrachten)
		{
			if(opdracht.getOpdrachtId() > i)
				i = opdracht.getOpdrachtId();
		}
		return i;
	}
}
