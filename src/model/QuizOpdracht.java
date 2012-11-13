/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public class QuizOpdracht {

	public Quiz quiz;
	public Opdracht opdracht;
	private int maxScore;

	private QuizOpdracht (Quiz quiz, Opdracht opdracht, int maxScore){
		this.quiz = quiz;
		this.opdracht = opdracht;
		this.maxScore = maxScore;		
	}
	
	public static void koppelOpdrachtAanQuiz(
			Quiz quiz, Opdracht opdracht, int maxScore){
		QuizOpdracht quizOpdracht = 
                            new QuizOpdracht(quiz,opdracht,maxScore);
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		opdracht.voegQuizOpdrachtToe(quizOpdracht);
	}
	
	public void ontKoppelOpdrachtVanQuiz(){
		quiz.verwijderdQuizOpdracht(this);
		opdracht.verwijderQuizOpdracht(this);
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
	 * @return the opdracht
	 */
	public Opdracht getOpdracht() {
		return opdracht;
	}
	/**
	 * @param opdracht the opdracht to set
	 */
	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}
	
	
}
