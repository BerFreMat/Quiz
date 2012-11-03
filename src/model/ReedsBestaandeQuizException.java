package model;

@SuppressWarnings("serial")
public class ReedsBestaandeQuizException  extends QuizCatalogusException{
	public ReedsBestaandeQuizException() {
		super("Deze opdracht bestaat reeds in de quizcatalogus.");
	}
}

