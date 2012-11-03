/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author java
 *
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
	
	
	
	/**
	 * @return the quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}
	/**
	 * @param quiz the quiz to set
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	/**
	 * @return the opdrachtAntwoorden
	 */
	public ArrayList<OpdrachtAntwoord> getOpdrachtAntwoorden() {
		return opdrachtAntwoorden;
	}
	/**
	 * @param opdrachtAntwoorden the opdrachtAntwoorden to set
	 */
	public void setOpdrachtAntwoorden(ArrayList<OpdrachtAntwoord> opdrachtAntwoorden) {
		this.opdrachtAntwoorden = opdrachtAntwoorden;
	}
	public QuizDeelname(Quiz quiz) {
		super();
		this.quiz = quiz;
		this.actieveVraag = -1;
	}
	/**
	 * @return the actieveVraag
	 */
	public int getActieveVraag() {
		return (actieveVraag + 1);
	}
	/**
	 * @param actieveVraag the actieveVraag to set
	 */
	public void setActieveVraag(int actieveVraag) {
		this.actieveVraag = actieveVraag -1;
	}
	
	public String 
	
	
	
	

}
