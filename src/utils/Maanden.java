package utils;

public enum Maanden {
	JANUARI,
	FEBRUARI,
	MAART,
	APRIL,
	MEI,
	JUNI,
	JULI,
	AUGUSTUS,
	SEPTEMBER,
	OKTOBER,
	NOVEMBER,
	DECEMBER;
	/**
	 * @author Matias
	 * @return this.getname geeft naam van de maand terug
	 */
	public String toString() {
		return this.getName();
	}
	/**
	 * @author Matias
	 * @return geeft this.name terug in lowercase
	 */
	public String getName() {
		return this.name().toLowerCase();
	}
}
