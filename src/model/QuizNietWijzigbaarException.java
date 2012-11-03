package model;

@SuppressWarnings("serial")
public class QuizNietWijzigbaarException extends QuizCatalogusException {
	public QuizNietWijzigbaarException(String msg) {
		super("De quiz staat niet in het correcte statuut om te worden gewijzigd: " + msg);
	}	
}
