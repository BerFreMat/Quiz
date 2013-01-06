
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
 * Beheer van quizzen subclass van abstact FileContainer
 * @author java
 *
 */
public class QuizCatalogus extends FileContainer {
	
	private List<Quiz> quizen;
/**
 * default constructor en maakt arraylist Quiz
 */
	public QuizCatalogus() {
		super();
		this.quizen = new ArrayList<Quiz>();
	}

	public List<Quiz> getQuizen() {
		return quizen;
	}

	public void setQuizen(ArrayList<Quiz> quizen) {
		this.quizen = quizen;
	}
/**
 * 	Voeg Quiz Toe set datum registratie en quizId
 * @param quiz
 * @throws ReedsBestaandeQuizException
 */
	public void voegQuizToe(Quiz quiz) throws ReedsBestaandeQuizException
	{
		quiz.setDatumRegistratie(new Datum());
		int positieQuiz = quizen.indexOf(quiz);

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
	/**
	 * Verwijderd quiz, check als quiz is in status (IN_CONSTRUCTIE of AFGEWERKT)
	 * @param quiz
	 * @throws QuizNietVerwijderbaarException
	 * @throws QuizNietGevondenException
	 */
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
	/**
	 * Wijzig Quiz, check als Quiz status IN_CONSTRUCTIE is
	 * @param quiz
	 * @throws QuizNietWijzigbaarException
	 * @throws QuizNietGevondenException
	 */
	
	public void wijzigQuiz(Quiz quiz) throws QuizNietWijzigbaarException, QuizNietGevondenException
	{
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
/**
 * Zoek in lijst de OPENGESTELD quizzen
 * @return
 */
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
/**
 * Haalt string uit bestand met naam: "quiz.txt"
 */
	@Override
	public String getFile() {
		
		return "quiz.txt";
	}
	@Override
	public void deformatteerLijn(String lijn) throws Exception {
		Quiz quiz = new Quiz();
		quiz.maakObjectVanString(lijn);
		this.voegQuizToe(quiz);
	}


	@Override
	public List teSchrijvenLijst() {
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
			String teSchrijvenLijn = quiz.formatteerObjectNaarString();
			return teSchrijvenLijn;
		}
		else
		{
			return null;
		}
	}
		/**
		 * Verwijderd opdracht uit quiz
		 * @param quizOpdracht
		 */
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
