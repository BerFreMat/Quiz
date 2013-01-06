
package model;

import java.util.ArrayList;

/**
 * Registreer deelname, actieve vragen, antwoorden, feedback en maakt rapport
 * @author java
 */
public class QuizDeelname {
	private Quiz quiz;
	private ArrayList<OpdrachtAntwoord> opdrachtAntwoorden;
	private int actieveVraag;
	
	public QuizOpdracht volgendeOpdracht(){
		return quiz.getQuizOpdrachten().get(actieveVraag + 1);
	}
	
	public QuizOpdracht vorigeOpdracht(){
		return quiz.getQuizOpdrachten().get(actieveVraag - 1);
	}	

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public ArrayList<OpdrachtAntwoord> getOpdrachtAntwoorden() {
		return opdrachtAntwoorden;
	}
	
	public void setOpdrachtAntwoorden(ArrayList<OpdrachtAntwoord> opdrachtAntwoorden) {
		this.opdrachtAntwoorden = opdrachtAntwoorden;
	}
	public QuizDeelname(Quiz quiz) {
		super();
		this.quiz = quiz;
		this.actieveVraag = -1;
	}
	
	public int getActieveVraag() {
		return (actieveVraag + 1);
	}
	
	public void setActieveVraag(int actieveVraag) {
		this.actieveVraag = actieveVraag -1;
	}
	
	public String feedback(OpdrachtCatalogus opdrachtCatalogus)
	{
		String feedback = new String();
		for (int i = 0;i< opdrachtAntwoorden.size();i++)
		{
			feedback += opdrachtAntwoorden.get(i).feedback(opdrachtCatalogus) + " ";
		}
		return feedback;
	}
	

	public String getQuizRapport() {
	
		return null;
	}
}