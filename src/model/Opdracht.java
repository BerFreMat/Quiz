/**
 * 
 */
package model;

/**
 * @author java
 *
 */


public abstract class Opdracht {

	private String opgave;
	private String antwoord;	
	
	public String getOpgave() {
		return opgave;
	}
	public void setOpgave(String opgave) {
		this.opgave = opgave;
	}
	public String getAntwoord() {
		return antwoord;
	}
	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}
	public boolean antwoordControle(String antwoord){
		if( antwoord.equalsIgnoreCase(this.antwoord))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
