/**
 * 
 */
package model;

/**
 * @author java
 *
 */
public class Leerling {
	private String leerlingNaam;
	private int leerJaar;
	/**
	 * @return the leerlingNaam
	 */
	public String getLeerlingNaam() {
		return leerlingNaam;
	}
	/**
	 * @param leerlingNaam the leerlingNaam to set
	 */
	public void setLeerlingNaam(String leerlingNaam) {
		this.leerlingNaam = leerlingNaam;
	}
	/**
	 * @return 
	 * @return the leerjaar
	 */
	public int  getLeerjaar() {
		
		return leerJaar;
	}
	/**
	 * @param leerjaar the leerjaar to set
	 */
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
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Leerling [leerlingNaam=" + leerlingNaam + ", leerjaar="
				+ leerJaar + "]";
	}
	
}
