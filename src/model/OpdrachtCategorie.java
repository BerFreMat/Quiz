/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public enum OpdrachtCategorie {
	REKENEN("Rekenen"),
	NEDERLANDS("Nederlandse taal"),
	FRANS("Franse taal"),
	ALGEMEEN("Algemene kennis");
	
	private String opdrachtCategorie;
	
	private OpdrachtCategorie(String opdrachtCategorie)
	{
		this.opdrachtCategorie = opdrachtCategorie;
	}
	public String getOpdrachtCategorie()
	{
		return opdrachtCategorie;
	}

}
