package controller;
import model.*;
public class QuizController {
	
	public static void main(String[] args) {
		try
		{
			Opdracht opdracht1 = new EenvoudigeOpdracht("Wat is de hoofdstad van Franrijk?","Parijs");
			Opdracht opdracht2 = new EenvoudigeOpdracht("Wat is de hoodstad van Spanje?","Madrid");
			Quiz quiz = new Quiz("Hoofdsteden Europa");
			QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht1, 2);
			QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht2, 2);
			System.out.println(quiz.getOpdrachten());
			QuizOpdracht quizOpdracht = quiz.getOpdracht(1);
		//	quizOpdracht.ontKoppelOpdrachtVanQuiz();
			System.out.println(quiz.getOpdrachten());
			
			
			QuizCatalogus quizCatalogus = new QuizCatalogus();
			quizCatalogus.lezen();
			quizCatalogus.voegQuizToe(quiz);
			quizCatalogus.schrijfNaarBestand();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//System.out.println(getStackTrace(ex));
			System.out.println(String.format("Er is een fout opgetreden in de controller: %s ", ex.getMessage() ));
		}	
	}

}
