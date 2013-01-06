package exceptions;

@SuppressWarnings("serial")
public class QuizNietGevondenException  extends QuizCatalogusException{
	public QuizNietGevondenException() {
		super("De quiz zit niet in de quizcatalogus.");
	}
}