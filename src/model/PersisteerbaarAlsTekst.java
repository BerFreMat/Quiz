package model;
/**
 * Formatteert elk object naar een String die later opnieuw omgezet kan worden in een object.
 * @param O = object dat moet omgezet worden in een string
 * @return
 */
public interface PersisteerbaarAlsTekst {
	void maakObjectVanString(String lijn) throws Exception;

	
	String formatteerObjectNaarString();
}

