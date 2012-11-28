/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public enum OpdrachtSoort {
	MEERKEUZE("Meerkeuze","Meerkeuze"),
	OPSOMMING("Opsomming","Opsomming"),
	REPRODUCTIE("Reproductie","Reproductie"),
	EENVOUDIGE_VRAAG("Eenvoudige Vraag","EenvoudigeOpdracht.java");
	
	private String opdrachtSoort;
	private String klasse;
	
	private OpdrachtSoort(String opdrachtSoort,String klasse)
	{
		this.opdrachtSoort = opdrachtSoort;
		this.klasse = klasse;
	}
	public String getOpdrachtSoort()
	{
		return opdrachtSoort;
	}
	public String getKlasse()
	{
		return klasse;
	}

}
