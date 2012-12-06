package controller;
import persistency.DAOFacade;
import persistency.TextDAOFacade;
import model.*;
public class QuizController {
	
	public static void main(String[] args) {
		try
		{
/*			Opdracht opdracht1 = new EenvoudigeOpdracht("Wat is de hoofdstad van Franrijk?","Parijs");
			Opdracht opdracht2 = new EenvoudigeOpdracht("Wat is de hoodstad van Spanje?","Madrid");
		//	Quiz quiz = new Quiz("Test of TextDaoFacade quiz toevoegd aan QuizCatalogus");
		//	QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht1, 2);
		//	QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht2, 2);
		//	System.out.println(quiz.getOpdrachten());
		//	QuizOpdracht quizOpdracht = quiz.getOpdracht(1);
		//	quizOpdracht.ontKoppelOpdrachtVanQuiz();
		//	System.out.println(quiz.getOpdrachten());
			
/*		OpdrachtCatalogus opdrachtCatalogus = new OpdrachtCatalogus();
			opdrachtCatalogus.voegOpdrachtToe(opdracht1);
			opdrachtCatalogus.voegOpdrachtToe(opdracht2);
			QuizCatalogus quizCatalogus = new QuizCatalogus();
/*QuizCatalogus inlezen*/
/*			quizCatalogus.lezen();			
			System.out.println(quizCatalogus);
			System.out.println(quiz);			
			quizCatalogus.voegQuizToe(quiz);
			
/*Om consistentie tussen opdrachten en quizen te bewaren moet als de koppeling tussen een quiz en
 * een opdracht wordt gewijzigd steed quizCatalogus,opdrachtCatalogus,quiz en opdracht*/
/*			System.out.println(quizCatalogus);
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
			opdrachtCatalogus.schrijfNaarBestand();
			
			OpdrachtCatalogus opdrachtCatalogusTestLees = new OpdrachtCatalogus();
			opdrachtCatalogusTestLees.lezen();
			System.out.println(opdrachtCatalogusTestLees.toString());
*/			
			/*Opdracht meerkeuzeOpdracht = new Meerkeuze("test toevoegen meerkeuzevraag","enkel een correcte toevoeging volstaat",
					Leraar.Kim,
					OpdrachtCategorie.FRANS); */
			Opdracht opdracht2 = new EenvoudigeOpdracht("Wat is de hoodstad van België?","Brussel");
			DAOFacade daofacade = new TextDAOFacade();
			daofacade.getOpdrachten().toString();
			//daofacade.voegOpdrachtToe(meerkeuzeOpdracht);
			//daofacade.voegOpdrachtToe(opdracht2);
			System.out.println(daofacade.getOpdrVanCategorie(OpdrachtCategorie.FRANS).toString());
			System.out.println(daofacade.getOpdrVanType(OpdrachtSoort.EENVOUDIGE_VRAAG).toString());
	//		daofacade.voegQuizToe(quiz);
			daofacade.schrijfWeg();
			System.out.println(daofacade.getOpdrVanCategorie(OpdrachtCategorie.FRANS).toString());
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace();
			//System.out.println(getStackTrace(ex));
			System.out.println(String.format("Er is een fout opgetreden in de controller: %s ", ex.getMessage() ));
		}	
	}
}
