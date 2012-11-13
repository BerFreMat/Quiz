/**
 * 
 */
package model;

import java.util.ArrayList;

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
	
	private ArrayList<Quiz> quizen;

	/**
	 * @return the quizen
	 */
	public ArrayList<Quiz> getQuizen() {
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
		if(positieQuiz >= 0)
		{
			throw new ReedsBestaandeQuizException();
		}
		else
		{
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
	public void maakObjectVanLijn(String[] velden) throws ReedsBestaandeQuizException  {
		String onderwerp = velden[0];
		Quiz quiz = new Quiz(onderwerp);
		this.voegQuizToe(quiz);
	}
	
	@Override
	public String getFile() {
		// TODO Auto-generated method stub
		return "bestanden\\quiz.txt";
	}

	@Override
	public void toevoegenLijn(String lijn) throws ReedsBestaandeQuizException {
		String [] velden = lijn.split(",");
		maakObjectVanLijn(velden);
	}

	@Override
	public String[] teSchrijvenLijnen() {
		String[] teSchrijvenLijnen = new String[quizen.size()];
		int i = 0;
		for(Quiz quiz: quizen)
		{
			teSchrijvenLijnen[i] = String.format("%s$%s$%s", quiz.getAuteur(),
					quiz.getDatumRegistratie(),
					quiz.isTest(),
					quiz.getOnderwerp());
			i++;
		}
		return teSchrijvenLijnen;
	}
	
}
