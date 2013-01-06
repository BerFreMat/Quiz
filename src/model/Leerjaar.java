package model;

public enum Leerjaar {
	LEERJAAR1("Eerste leerjaar",1),
	LEERJAAR2("Tweede leerjaar",2),
	LEERJAAR3("Derde leerjaar",3),
	LEERJAAR4("Vierde leerjaar",4),
	LEERJAAR5("Vijde leerjaar",5),
	LEERJAAR6("Zesde leerjaar",6);
	
	private String leerjaren;
	private int leerjaarInt;
	
	private Leerjaar(String leerjaar,int leerjaarInt)
	{
		this.leerjaren = leerjaar;
		this.leerjaarInt = leerjaarInt;
		
	}
	public String getLeerjaar()
	{
		return leerjaren;
	}
	public int getLeerjaarInt()
	{
		return leerjaarInt;
	}
}
