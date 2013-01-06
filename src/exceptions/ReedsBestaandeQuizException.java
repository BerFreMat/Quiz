package exceptions;
/**
 * Reeds Bestaande Opdracht Exception
 * @author java
 *
 */
@SuppressWarnings("serial")
public class ReedsBestaandeQuizException  extends QuizCatalogusException{
	public ReedsBestaandeQuizException() {
		super("Deze quiz bestaat reeds in de quizcatalogus.");
	}
}

