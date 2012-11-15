package controller;
import model.*;
public class QuizController {
	
	public static void main(String[] args) {
		try
		{
			Opdracht opdracht1 = new EenvoudigeOpdracht("Wat is de hoofdstad van Franrijk?","Parijs");
			Opdracht opdracht2 = new EenvoudigeOpdracht("Wat is de hoodstad van Spanje?","Madrid");
			Quiz quiz = new Quiz("Hoofdsteden Europa quiz 1");
		//	QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht1, 2);
		//	QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht2, 2);
		//	System.out.println(quiz.getOpdrachten());
		//	QuizOpdracht quizOpdracht = quiz.getOpdracht(1);
		//	quizOpdracht.ontKoppelOpdrachtVanQuiz();
		//	System.out.println(quiz.getOpdrachten());
			
			OpdrachtCatalogus opdrachtCatalogus = new OpdrachtCatalogus();
			opdrachtCatalogus.voegOpdrachtToe(opdracht1);
			opdrachtCatalogus.voegOpdrachtToe(opdracht2);
			QuizCatalogus quizCatalogus = new QuizCatalogus();
/*QuizCatalogus inlezen*/
			quizCatalogus.lezen();			
			System.out.println(quizCatalogus);
			System.out.println(quiz);			
			quizCatalogus.voegQuizToe(quiz);
			
/*Om consistentie tussen opdrachten en quizen te bewaren moet als de koppeling tussen een quiz en
 * een opdracht wordt gewijzigd steed quizCatalogus,opdrachtCatalogus,quiz en opdracht*/
			System.out.println(quizCatalogus);
			System.out.println(quiz);
			QuizOpdracht.koppelOpdrachtAanQuiz(quizCatalogus,opdrachtCatalogus,quiz, opdracht1, 2);
			QuizOpdracht.koppelOpdrachtAanQuiz(quizCatalogus,opdrachtCatalogus,quiz, opdracht2, 2);	

			System.out.println(quiz);
			System.out.println(opdracht1);
			System.out.println(opdracht2);
			QuizOpdracht quizOpdracht = quiz.getOpdracht(2);
			System.out.println(quiz.getOpdracht(2));
			quizOpdracht.ontKoppelOpdrachtVanQuiz(quizCatalogus,opdrachtCatalogus,quiz, opdracht2);
			System.out.println(quiz.getQuizOpdrachten());
			

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
