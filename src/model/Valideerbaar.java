/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public interface Valideerbaar {
	public boolean isValide(String antwoord) throws Exception;
	public String getValideerTekst();
}
