package exceptions;


public class DatumStringException extends Exception {
	public DatumStringException() {
		super("Datum string heeft verkeerd formaat D/MM/JJJJ");
	}
}
