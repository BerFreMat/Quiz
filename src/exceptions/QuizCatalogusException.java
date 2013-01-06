package exceptions;
/**
 * Opdracht Niet Toegevoegd Exception
 * @author java
 *
 */
@SuppressWarnings("serial")
public class QuizCatalogusException extends Exception{
	public QuizCatalogusException(String msg) {
		super(msg);
	}
}