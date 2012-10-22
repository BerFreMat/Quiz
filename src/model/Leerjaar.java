package model;

public enum Leerjaar {
	LEERJAAR1("Eerste leerjaar"),
	LEERJAAR2("Tweede leerjaar"),
	LEERJAAR3("Derde leerjaar"),
	LEERJAAR4("Vierde leerjaar"),
	LEERJAAR5("Vijde leerjaar"),
	LEERJAAR6("Zesde leerjaar");
	
	private String leerjaren;
	
	private Leerjaar(String leerjaar)
	{
		leerjaren = leerjaar;
		
	}
	public String getLeerjaar()
	{
		return leerjaren;
	}
}
