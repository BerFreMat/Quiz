package model;

public class OpdrachtAntwoord {
	private String laatsteAntwoord;
	private int aantalPogingen;
	private int antwoordTijd;
	private QuizOpdracht quizOpdracht;
	
	/**
	 * @return the quizOpdracht
	 */
	public QuizOpdracht getQuizOpdracht() {
		return quizOpdracht;
	}
	/**
	 * @param quizOpdracht the quizOpdracht to set
	 */
	public void setQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdracht = quizOpdracht;
	}
	/**
	 * @return the laatsteAntwoord
	 */
	public String getLaatsteAntwoord() {
		return laatsteAntwoord;
	}
	/**
	 * @param laatsteAntwoord the laatsteAntwoord to set
	 */
	public void setLaatsteAntwoord(String laatsteAntwoord) {
		this.laatsteAntwoord = laatsteAntwoord;
	}
	/**
	 * @return the aantalPogingen
	 */
	public int getAantalPogingen() {
		return aantalPogingen;
	}
	/**
	 * @param aantalPogingen the aantalPogingen to set
	 */
	public void setAantalPogingen(int aantalPogingen) {
		this.aantalPogingen = aantalPogingen;
	}
	/**
	 * @return the antwoordTijd
	 */
	public int getAntwoordTijd() {
		return antwoordTijd;
	}
	/**
	 * @param antwoordTijd the antwoordTijd to set
	 */
	public void setAntwoordTijd(int antwoordTijd) {
		this.antwoordTijd = antwoordTijd;
	}
	public OpdrachtAntwoord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String feedback(){
		return quizOpdracht.getOpdracht().toonOplossing() + 
				"laatste Antwoord : " + laatsteAntwoord +
				"antwoordTijd : "+ antwoordTijd ;
	}
	
	
}
