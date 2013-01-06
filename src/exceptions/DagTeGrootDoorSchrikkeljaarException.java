package exceptions;


@SuppressWarnings("serial")
public class DagTeGrootDoorSchrikkeljaarException extends DagException {
	public DagTeGrootDoorSchrikkeljaarException() {
		
		super("Dit is geen schrikkeljaar, dus geen 29 dagen in februari");
	}
}