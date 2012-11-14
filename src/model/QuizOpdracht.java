/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public class QuizOpdracht {

	private int quizId;
	private int opdrachtId;
	private int maxScore;

/*	private QuizOpdracht (Quiz quiz, Opdracht opdracht, int maxScore){
		this.quiz = quiz;
		this.opdracht = opdracht;
		this.setMaxScore(maxScore);		
	}
*/	
	public QuizOpdracht(int quizId, int opdrachtId, int maxScore) {
		super();
		this.quizId = quizId;
		this.opdrachtId = opdrachtId;
		this.maxScore = maxScore;
	}

/*	public static void koppelOpdrachtAanQuiz(
			Quiz quiz, Opdracht opdracht, int maxScore){
		QuizOpdracht quizOpdracht = 
                            new QuizOpdracht(quiz,opdracht,maxScore);
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		opdracht.voegQuizOpdrachtToe(quizOpdracht);
	}
*/	
	
	public static void koppelOpdrachtAanQuiz(
			Quiz quiz, Opdracht opdracht, int maxScore){
		QuizOpdracht quizOpdracht = 
                            new QuizOpdracht(quiz.getQuizId(),opdracht.getOpdrachtId(),maxScore);
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		opdracht.voegQuizOpdrachtToe(quizOpdracht);
	}
	


	public void ontKoppelOpdrachtVanQuiz(QuizCatalogus quizcatalogus, OpdrachtCatalogus opdrachtCatalogus){
		quizcatalogus.verwijderQuizOpdracht(this);
		opdrachtCatalogus.verwijderQuizOpdracht(this);
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
}
