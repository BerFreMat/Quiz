/**
 * 
 */
package model;

/**
 * Class voor leerling naam, geeft naam en leerjaar
 * @author java
 *
 */
public class Leerling {
	private String leerlingNaam;
	private int leerJaar;
	/**
	 * @return
	 */
	public String getLeerlingNaam() {
		return leerlingNaam;
	}
	
	public void setLeerlingNaam(String leerlingNaam) {
		this.leerlingNaam = leerlingNaam;
	}
	
	public int  getLeerjaar() {
		
		return leerJaar;
	}
	
	public void setLeerjaar(int leerJaar) {
		this.leerJaar = leerJaar;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leerJaar;
		result = prime * result
				+ ((leerlingNaam == null) ? 0 : leerlingNaam.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leerling other = (Leerling) obj;
		if (leerJaar != other.leerJaar)
			return false;
		if (leerlingNaam == null) {
			if (other.leerlingNaam != null)
				return false;
		} else if (!leerlingNaam.equals(other.leerlingNaam))
			return false;
		return true;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	public String toString() {
		return "Leerling [leerlingNaam=" + leerlingNaam + ", leerjaar="
				+ leerJaar + "]";
	}
	
}
