package exceptions;

@SuppressWarnings("serial")
public class QuizNietVerwijderbaarException extends QuizCatalogusException {
	public QuizNietVerwijderbaarException(String msg) {
		super("De quiz staat niet in het correcte statuut om te worden verwijderd" + msg);
	}	
}
