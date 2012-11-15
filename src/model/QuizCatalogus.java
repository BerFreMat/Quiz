/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.DagException;
import exceptions.DatumStringException;
import exceptions.MaandException;
import exceptions.QuizNietGevondenException;
import exceptions.QuizNietVerwijderbaarException;
import exceptions.QuizNietWijzigbaarException;
import exceptions.ReedsBestaandeQuizException;

import DatumGregorian.Datum;

/**
 * @author java
 *
 */
public class QuizCatalogus extends FileContainer implements PersisteerbaarAlsTekst {
	
	private List<Quiz> quizen;

	public QuizCatalogus() {
		super();
		this.quizen = new ArrayList<Quiz>();
	}

	/**
	 * @return the quizen
	 */
	public List<Quiz> getQuizen() {
		return quizen;
	}

	/**
	 * @param quizen the quizen to set
	 */
	public void setQuizen(ArrayList<Quiz> quizen) {
		this.quizen = quizen;
	}
	
	public void voegQuizToe(Quiz quiz) throws ReedsBestaandeQuizException
	{
		quiz.setDatumRegistratie(new Datum());
		int positieQuiz = quizen.indexOf(quiz);

		System.out.println("positieQuiz: "+positieQuiz);
		if(positieQuiz >= 0)
		{
			throw new ReedsBestaandeQuizException();
		}
		else
		{
			quiz.setQuizId(quizen.size()+1);
			quizen.add(quiz);
		}
	}
	public void verwijderQuiz(Quiz quiz) throws QuizNietVerwijderbaarException, QuizNietGevondenException
	{
		int positieQuiz = quizen.indexOf(quiz);
		
		if(positieQuiz < 0){
			throw new QuizNietGevondenException();}
		else
		{
			if(quizen.get(positieQuiz).isVerwijderbaar())
			{
				quizen.remove(positieQuiz);
			}
			else
			{
				throw new QuizNietVerwijderbaarException(quizen.get(positieQuiz).getQuizStatus().toString());
			}
		}
	}
	
	public void wijzigQuiz(Quiz quiz) throws QuizNietWijzigbaarException, QuizNietGevondenException
	{
	//	System.out.println(quizen);
	//	System.out.println(quiz);
		int positieQuiz = quizen.indexOf(quiz);
		
		if(positieQuiz < 0){
			throw new QuizNietGevondenException();}
		else
		{
			if(quizen.get(positieQuiz).isWijzigbaar())
			{
				quizen.set(positieQuiz, quiz);
			}
			else
			{
				throw new QuizNietWijzigbaarException(quizen.get(positieQuiz).getQuizStatus().toString());
			}
		}
	}	
	
	@Override
	public String toString() {
		return "QuizCatalogus [quizen=" + quizen + "]";
	}

	public ArrayList<Quiz> opengesteldeQuizen()
	{
		ArrayList<Quiz> opengesteldeQuizen = new ArrayList<Quiz>();
		
		for(int i = 0; i < quizen.size();i++ )
		{
			if(quizen.get(i).isOpengesteld() )
			{
				opengesteldeQuizen.add(quizen.get(i));
			}
		}		
		return opengesteldeQuizen;
	}


	
	@Override
	public String getFile() {
		// TODO Auto-generated method stub
		return "quiz.txt";
	}

	@Override
	public void deformatteerLijn(String lijn) throws ReedsBestaandeQuizException, DatumStringException, DagException, MaandException {
		String[] velden = lijn.split(":");
		System.out.println("voor maak object van lijn" + velden[0]);
		maakObjectVanLijn(velden);
	}


	@Override
	public List teSchrijvenLijst() {
		// TODO Auto-generated method stub
		List teSchrijvenLijst ;
		teSchrijvenLijst = quizen;
		return quizen;
	}

	/**
	 * Maakt van het Quiz object een string die kan worden opgeslagen in een textbestand.
	 * auteur$datumRegistratie$isTest$isUniekeDeelname$leerjaren$onderwerp$quizOpdrachte$quizStatus
	 */
	@Override
	public String formatteerObject(Object obj) 
	{
		Quiz quiz = null;
		try
		{
			quiz = (Quiz)obj;
		}
		catch (Exception ex)
		{
			System.out.println("obj geen quiz");
		}
		
		if (quiz != null)
		{
			String teSchrijvenLijn = 
				String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s", 
				quiz.getQuizId(),
				quiz.getOnderwerp(),
				formatteerLeerjaren(quiz.getLeerjaren()),
				quiz.isTest(),
				quiz.isUniekeDeelname(),
				quiz.getQuizStatus(),
				quiz.getAuteur(),
				formatteerQuizOpdrachten(quiz.getQuizOpdrachten()),
				quiz.getDatumRegistratie().toStringInEuropees());
			
			return teSchrijvenLijn;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void maakObjectVanLijn(String[] velden) throws ReedsBestaandeQuizException, DatumStringException, DagException, MaandException  {

		System.out.println("a " + velden[0]);
		int quizId = Integer.parseInt(velden[0]);
		System.out.println("b");
		String onderwerp = velden[1];
		System.out.println("c");
		ArrayList<Leerjaar> leerjaren = deformatteerLeerjaren(velden[2]);
		System.out.println("d");
		Boolean isTest = Boolean.valueOf(velden[3]);
		System.out.println("e");
		Boolean isUniekeDeelname = Boolean.valueOf(velden[4]);
		System.out.println("f");
		QuizStatus quizStatus = QuizStatus.valueOf(velden[5]);
		System.out.println("g");
		Leraar auteur = deformatteerAuteur(velden[6]);
		System.out.println("h" + velden[7]);
		ArrayList<QuizOpdracht> quizOpdrachten = deformatteerQuizOpdrachten(velden[7]);
		System.out.println("i"+ velden[8]+"e");
		Datum datumRegistratie = new Datum(velden[8]);
		System.out.println("j");

		System.out.println("voor aanmaak nieuwe quiz");
		Quiz quiz = new Quiz(quizId,onderwerp,leerjaren,isTest,isUniekeDeelname,quizStatus,auteur,quizOpdrachten,datumRegistratie);
		this.voegQuizToe(quiz);
	}
	
	private Leraar deformatteerAuteur(String auteur) {
		// TODO Auto-generated method stub
		if(!auteur.equals("null"))
		{
			return Leraar.valueOf(auteur);
		}
		else
		{
			return null;
		}
	}

	private ArrayList<QuizOpdracht> deformatteerQuizOpdrachten(String quizOpdrachten) {
		if (!quizOpdrachten.equals("null"))
		{
			String[] quizOpdrachtenGesplit = quizOpdrachten.split(";");
			ArrayList<QuizOpdracht> quizOpdrachtenLijst = new ArrayList<QuizOpdracht>();
			
			for(int i = 0 ; i < quizOpdrachtenGesplit.length - 1 ; i ++)
			{
				String[] qOVeldenGesplit= quizOpdrachtenGesplit[i].split(" ");
				quizOpdrachtenLijst.add
					(new QuizOpdracht
							(Integer.parseInt(qOVeldenGesplit[0]),
							Integer.parseInt(qOVeldenGesplit[1]),
							Integer.parseInt(qOVeldenGesplit[2])));
			}
			return quizOpdrachtenLijst;
		}
		else
			return null;
	}
	
	private Object formatteerQuizOpdrachten(
			List<QuizOpdracht> quizOpdrachten) {
		
		String geformatteerdeQuizOprdrachten = new String();
		for (QuizOpdracht quizOpdracht : quizOpdrachten) {
			
			geformatteerdeQuizOprdrachten +=  String.format("%s %s %s;", 
					quizOpdracht.getQuizId(),quizOpdracht.getOpdrachtId(),quizOpdracht.getMaxScore());
		}
		System.out.println("geformatteerdeQuizOprdrachten" + geformatteerdeQuizOprdrachten);
		return geformatteerdeQuizOprdrachten;
	}

	public ArrayList<Leerjaar> deformatteerLeerjaren(String leerjaren)
	{
		String[] leerjarenGesplit = leerjaren.split(";");
		ArrayList<Leerjaar> leerjarenLijst = new ArrayList<Leerjaar>();
		
		for(int i = 0 ; i < leerjarenGesplit.length - 1 ; i ++)
		{
			leerjarenLijst.add(Leerjaar.valueOf(leerjarenGesplit[i]));
		}
		return leerjarenLijst;
	}
		
	public String formatteerLeerjaren(ArrayList<Leerjaar> leerjaren)
	{	
		String geformatteerdeLeerjaren = null;
		if(leerjaren!= null)
		{
			for(Leerjaar leerjaar : leerjaren )
			{
				geformatteerdeLeerjaren += leerjaar.toString() + ";";
			}
		}
		return geformatteerdeLeerjaren;
	}

	public void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		for(Quiz quiz : quizen)
		{
			if(quiz.getQuizOpdrachten().contains(quizOpdracht))
			{
				quiz.verwijderdQuizOpdracht(quizOpdracht);
			}
		}
		
	}
	

}
