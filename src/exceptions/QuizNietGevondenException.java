package exceptions;
/**
 * Quiz Niet Gevonden Exception
 * @author java
 *
 */
@SuppressWarnings("serial")
public class QuizNietGevondenException  extends QuizCatalogusException{
	public QuizNietGevondenException() {
		super("De quiz zit niet in de quizcatalogus.");
	}
}