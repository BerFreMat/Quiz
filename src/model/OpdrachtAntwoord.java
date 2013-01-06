package model;
/**
 * Geeft feedback over: quizOpdracht, toonOplossing, laatste antwoord 
 * en antwoord tijd
 * @author java
 *
 */

public class OpdrachtAntwoord {
	private String laatsteAntwoord;
	private int aantalPogingen;
	private int antwoordTijd;
	private QuizOpdracht quizOpdracht;
	
	/**
	 * quiz opdracht
	 * @return 
	 */
	public QuizOpdracht getQuizOpdracht() {
		return quizOpdracht;
	}
	/**
	 * quiz opdracht set
	 * @param 
	 */
	public void setQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdracht = quizOpdracht;
	}
	/**
	 * laatste antwoord
	 * @return 
	 */
	public String getLaatsteAntwoord() {
		return laatsteAntwoord;
	}
	/**
	 * laatste antwoord van een opdracht
	 * @param 
	 */
	public void setLaatsteAntwoord(String laatsteAntwoord) {
		this.laatsteAntwoord = laatsteAntwoord;
	}
	/**
	 * aantal pogingen voor een antwoord
	 * @return 
	 */
	public int getAantalPogingen() {
		return aantalPogingen;
	}
	/**
	 * aantal pogingen voor antwoord
	 * @param 
	 */
	public void setAantalPogingen(int aantalPogingen) {
		this.aantalPogingen = aantalPogingen;
	}
	
	public int getAntwoordTijd() {
		return antwoordTijd;
	}
	/**
	 * Tijd voor antwoord
	 * @param
	 */
	public void setAntwoordTijd(int antwoordTijd) {
		this.antwoordTijd = antwoordTijd;
	}
	
	public OpdrachtAntwoord() {
		super();
		
	}
	
	public String feedback(OpdrachtCatalogus opdrachtCatalogus){
		return opdrachtCatalogus.getOpdracht(quizOpdracht).toonOplossing() + 
				"Laatste Antwoord : " + laatsteAntwoord +
				"Antwoord Tijd : "+ antwoordTijd ;
	}	
}
