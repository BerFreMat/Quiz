/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public enum OpdrachtSoort {
	MEERKEUZE("Meerkeuze"),
	OPSOMMING("Opsomming"),
	REPRODUCTIE("Reproductie"),
	EENVOUDIGE_VRAAG("Eenvoudige Vraag");
	
	private String opdrachtSoort;
	
	private OpdrachtSoort(String opdrachtSoort)
	{
		this.opdrachtSoort = opdrachtSoort;
	}
	public String getOpdrachtSoort()
	{
		return opdrachtSoort;
	}

}
