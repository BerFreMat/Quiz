package exceptions;

@SuppressWarnings("serial")
public class ReedsBestaandeOpdrachtException  extends OpdrachtCatalogusException{
	public ReedsBestaandeOpdrachtException() {
		super("Deze opdracht bestaat reeds in de opdrachtencatalogus.");
	}
}

