package exceptions;
/**
 * Quiz Niet Verwijderbaar Exception
 * @author java
 *
 */
@SuppressWarnings("serial")
public class QuizNietVerwijderbaarException extends QuizCatalogusException {
	public QuizNietVerwijderbaarException(String msg) {
		super("De quiz staat niet in het correcte statuut om te worden verwijderd" + msg);
	}	
}
