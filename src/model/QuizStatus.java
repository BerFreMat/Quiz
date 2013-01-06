package model;

/**
 * Enums for quiz status
 * @author 
 */
public enum QuizStatus {
	IN_CONSTRUCTIE("Deze quiz in nog in constructie"),
	AFGEWERKT("De quiz is afgewerkt"),
	OPENGESTELD("De leerlingen mogen de quiz oplossen"),
	LAATSTE_KANS("De quiz is nog enkele dagen actief en zal dan afgesloten worden"),
	AFGESLOTEN("Quiz afgesloten");
	
	private String status;
	
	private QuizStatus(String quizStatus)
	{
		status = quizStatus;
	}
	public String getStatus()
	{
		return status;
	}

}
