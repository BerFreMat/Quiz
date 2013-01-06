package exceptions;
/**
 * Opdracht Niet Gevonden Exception
 * @author java
 *
 */
@SuppressWarnings("serial")
public class OpdrachtNietGevondenException  extends OpdrachtCatalogusException{
	public OpdrachtNietGevondenException() {
		super("De opdracht zit niet in de opdrachtencatalogus.");
	}
}
