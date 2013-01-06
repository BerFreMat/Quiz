
package model;

/**
 * Interface voor verschillende soorten van vragen
 * @author java
 *
 */
public interface Valideerbaar {
	public boolean isValide(String antwoord) throws Exception;
	public String getValideerTekst();
}
