package model;

	/**
	 * 
	 * @author Matias
	 * 
	 * enums for Leraar
	 *
	 */

public enum Leraar {
	LERAAR1("Bart"),
	LERAAR2("Kim"),
	LERAAR3("Stijn"),
	LERAAR4("Peter"),
	LERAAR5("Kristel");
	
	private String naamLr;
	
	private Leraar(String naamLeraar)
	{
		naamLr = naamLeraar;
	}
	public String getNaamLeraar()
	{
		return naamLr;
	}


}
