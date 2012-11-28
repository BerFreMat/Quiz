/**
 * 
 */
package model;

import exceptions.OpdrachtNietGevondenException;
import exceptions.QuizNietGevondenException;
import exceptions.QuizNietWijzigbaarException;

/**
 * @author java
 *
 */
public class QuizOpdracht implements PersisteerbaarAlsTekst {

	private int quizId;
	private int opdrachtId;
	private int maxScore;

	private QuizOpdracht (Quiz quiz, Opdracht opdracht, int maxScore){
		this.quizId = quiz.getQuizId();
		this.opdrachtId = opdracht.getOpdrachtId();
		this.maxScore = maxScore;
	}
		
	public QuizOpdracht(int quizId, int opdrachtId, int maxScore) {
		super();
		this.quizId = quizId;
		this.opdrachtId = opdrachtId;
		this.maxScore = maxScore;
	}

	public QuizOpdracht() {
		super();
	}

	/*	public static void koppelOpdrachtAanQuiz(
			Quiz quiz, Opdracht opdracht, int maxScore){
		QuizOpdracht quizOpdracht = 
                            new QuizOpdracht(quiz,opdracht,maxScore);
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		opdracht.voegQuizOpdrachtToe(quizOpdracht);
	}
*/	
	public static void koppelOpdrachtAanQuiz(QuizCatalogus quizCatalogus,
			OpdrachtCatalogus opdrachtCatalogus, Quiz quiz, Opdracht opdracht,
			int maxScore) throws QuizNietWijzigbaarException, QuizNietGevondenException, OpdrachtNietGevondenException {
		QuizOpdracht quizOpdracht = 
                new QuizOpdracht(quiz,opdracht,maxScore);
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		opdracht.voegQuizOpdrachtToe(quizOpdracht);
		quizCatalogus.wijzigQuiz(quiz);
		opdrachtCatalogus.wijzigOpdracht(opdracht);		
	}

	public void ontKoppelOpdrachtVanQuiz(QuizCatalogus quizCatalogus, OpdrachtCatalogus opdrachtCatalogus,  Quiz quiz, Opdracht opdracht) throws QuizNietWijzigbaarException, QuizNietGevondenException, OpdrachtNietGevondenException{
//		quizcatalogus.verwijderQuizOpdracht(this);
//		opdrachtCatalogus.verwijderQuizOpdracht(this);
		if(quizId == quiz.getQuizId() && opdrachtId == opdracht.getOpdrachtId())
		{
			quiz.verwijderdQuizOpdracht(this);
			opdracht.verwijderdQuizOpdracht(this);
			quizCatalogus.wijzigQuiz(quiz);
			opdrachtCatalogus.wijzigOpdracht(opdracht);
		}
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getOpdrachtId() {
		return opdrachtId;
	}

	public void setOpdrachtId(int opdrachtId) {
		this.opdrachtId = opdrachtId;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + opdrachtId;
		result = prime * result + quizId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizOpdracht other = (QuizOpdracht) obj;
		if (opdrachtId != other.opdrachtId)
			return false;
		if (quizId != other.quizId)
			return false;
		return true;
	}

	public Opdracht getOpdracht(OpdrachtCatalogus opdrachtCatalogus) {
		opdrachtCatalogus.getOpdracht(opdrachtId);
		return null;
	}

	@Override
	public String toString() {
		return "QuizOpdracht [quizId=" + quizId + ", opdrachtId=" + opdrachtId
				+ ", maxScore=" + maxScore + "]";
	}

	@Override
	public void maakObjectVanString(String lijn) throws Exception {
		String[] velden = lijn.split(" ");
		this.setQuizId(Integer.parseInt(velden[0]));
		this.setOpdrachtId((Integer.parseInt(velden[1])));
		this.setMaxScore((Integer.parseInt(velden[2])));
	}

	@Override
	public String formatteerObjectNaarString() {
		return  String.format("%s %s %s", 
				this.getQuizId(),
				this.getOpdrachtId(),
				this.getMaxScore());
	}

		
}
