package model;

public interface PersisteerbaarAlsTekst {
	void maakObjectVanString(String lijn) throws Exception;

	/**
	 * Formatteert elk object naar een String die later opnieuw omgezet kan worden in een object.
	 * @param O = object dat moet omgezet worden in een string
	 * @return
	 */
	String formatteerObjectNaarString();
}

