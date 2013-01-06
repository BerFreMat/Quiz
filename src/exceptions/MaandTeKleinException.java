package exceptions;

/**
 * MaandTeKleinException, minimum = 1
 * @author java
 *
 */
public class MaandTeKleinException extends MaandException{
	public MaandTeKleinException() {
		super(" Maand is te klein, het minimum is = 1");
	}
}
