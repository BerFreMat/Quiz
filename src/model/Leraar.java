package model;
/**
 * Class enum voor leraar
 * @author java
 *
 */

public enum Leraar {
	Bart(1),Kim(2),Stijn(3),Peter(4),Kristel(5);
	
	private final int id;
	Leraar(int id) {
		this.id = id;
	}
	
	public int getNaamLeraar()
	{
		return id;
	}

}
