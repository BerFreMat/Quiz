
package model;
import model.*;

import java.util.ArrayList;
import java.util.List;

import DatumGregorian.Datum;

import exceptions.OpdrachtNietGevondenException;
import exceptions.ReedsBestaandeOpdrachtException;

/**
 * Genereer opdrachten subclass van abstract class FileContainer
 * @author java
 *
 */
public class OpdrachtCatalogus extends FileContainer {
	private ArrayList<Opdracht> opdrachten;

	/**
	 * List van opdrachten in een array
	 * @return
	 */
	public ArrayList<Opdracht> getOpdrachten() {
		return opdrachten;
	}
	public OpdrachtCatalogus() {
		super();
		opdrachten = new ArrayList<Opdracht>();
	}
	
	private void setopdrachten(ArrayList<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}
	/**
	 * Voeg Opdrachten toe
	 * @param opdracht
	 * @throws ReedsBestaandeOpdrachtException
	 */
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
	/**
	 *contains(Object elem)  gebruiken om na te kijken of een opdracht een QuizOpdracht is.
	 *voorlopig zonder QuizCatalogus. ==> pas aangewezen als er persistentie is toegevoegd.
	 * @param opdracht
	 * @throws OpdrachtNietGevondenException
	 */
	public void verwijderOpdracht(Opdracht opdracht) throws OpdrachtNietGevondenException
	{
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
	/**
	 * Verwijderd opdracht
	 * @param quizOpdracht
	 */
	public void verwijderdQuizOpdracht(QuizOpdracht quizOpdracht) {
		for(Opdracht opdracht : opdrachten)
		{
			if(opdracht.getQuizOpdrachten().contains(quizOpdracht))
			{
				opdracht.verwijderdQuizOpdracht(quizOpdracht);
			}
		}
		
	}
	/**
	 * Haalt opdrachtId
	 * @param opdrachtId
	 * @return
	 */
	public Opdracht getOpdracht(int opdrachtId) {
		for(Opdracht opd : opdrachten)
		{
			if(opd.getOpdrachtId() == opdrachtId )
			return opd;
		}
		return null;
	}
	/**
	 * Haalt opdrachte op opdrachtId
	 * @param quizOpdracht
	 * @return
	 */
	public Opdracht getOpdracht(QuizOpdracht quizOpdracht) {
		for(Opdracht opd : opdrachten)
		{
			if(opd.getOpdrachtId() == quizOpdracht.getOpdrachtId() )
			return opd;
		}
		return null;
	}

	/**
	 * Haalt string van bestand "opdracht.txt"
	 */
	@Override
	public String getFile() {
		return "opdracht.txt";
	}
	/**
	 * Deformateer de string en sorteer opdracht volgens soort
	 */
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
	/**
	 * Zet de opdrachte in de List teSchrijvenLijst
	 */
	@Override
	public List teSchrijvenLijst() {
		List teSchrijvenLijst ;
		teSchrijvenLijst = opdrachten;
		return teSchrijvenLijst;
	}
	/**
	 * Formateer object opdracht als string met "#" als scheidingsteken
	 */
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
	
	/**
	 * Get opdrachten van een bepaalde soort
	 * @param opdrachtsoort
	 * @return
	 */
	
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
	
	/**
	 * Get opdracht van een bepaalde categorie
	 * @param opdrachtCategorie
	 * @return
	 */
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
	/**
	 * Voeg opdrachten van een quiz volgens Id
	 * @param quiz
	 */
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
		return "Opdracht Catalogus [opdrachten=" + opdrachten + "]";
	}
	
	/**
	 * Control opdracht Id
	 * @return
	 */
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
