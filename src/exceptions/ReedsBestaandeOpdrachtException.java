package exceptions;
/**
 * Reeds Bestaande Opdracht Exception
 * @author java
 *
 */
@SuppressWarnings("serial")
public class ReedsBestaandeOpdrachtException  extends OpdrachtCatalogusException{
	public ReedsBestaandeOpdrachtException() {
		super("Deze opdracht bestaat reeds in de opdrachtencatalogus.");
	}
}

