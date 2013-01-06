package DatumGregorian;
import java.util.*;

import exceptions.DagException;
import exceptions.DagTeGrootDoorSchrikkeljaarException;
import exceptions.DagTeGrootException;
import exceptions.DagTeKleinException;
import exceptions.DatumException;
import exceptions.DatumStringException;
import exceptions.MaandException;
import exceptions.MaandTeGrootException;
import exceptions.MaandTeKleinException;

import utils.Maanden;

/**
 * Deze class representeert een datum object met behulp van de klasse GregorianCalendar
 * 
 * @author Matias
 */


public class Datum {
	private GregorianCalendar datum;
	
	
	public Datum(){
		datum = new GregorianCalendar();
	}
	
	public Datum(Datum datum){
		this.datum = new GregorianCalendar(datum.getJaar(),datum.getMaand()-1,datum.getDag());
	}
	
	public Datum (int dag,int maand,int jaar) throws DagException, MaandException{
		if(set(dag,maand,jaar))
		{
			datum = new GregorianCalendar(jaar,maand-1,dag);
		}
	}
	
	public Datum(String datum) throws DatumStringException, DagException, MaandException
	{ // Format: DD/MM/JJJJ
		if(datum == null)
		{
			throw new DatumStringException();
		}
		if(datum.length() == 9 || datum.length() == 10 ) 
		{
				
			if(datum.length() == 9) 
			{
				datum = "0" + datum;
			} 
			try
			{
				if(datum.substring(2,3).equals(datum.substring(5,6))) 
				{// Format check: (DD "*" MM "*" YYYY)
					int dag = Integer.valueOf(datum.substring(0, 2));
					int maand = Integer.valueOf(datum.substring(3, 5));
					int jaar = Integer.valueOf(datum.substring(6, 10));
					if(set(dag,maand,jaar))
					{
						this.datum = new GregorianCalendar(jaar,maand-1,dag);
					}
				} 
			}
			catch(NumberFormatException nfe)  
			{  
				throw new DatumStringException(); 
			}	
		}
		else {throw new DatumStringException();}
	}
	
	public int getDag(){
		return datum.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMaand(){
		return datum.get(Calendar.MONTH)+1;
	}
	
	public int getJaar(){
		return datum.get(Calendar.YEAR);
	}
	public String toString() {
		String output = "";
		output += this.getDag() + " " + this.getMonthName() + " " + this.getJaar();
		return output;
	}
	
	private String getMonthName() {
		Maanden[] maanden = Maanden.values();
		return maanden[this.getMaand()-1].getName();
	}
	public String toStringAmerikaans() {
		String output = "";
		output += this.getJaar() + "/" + this.getMaand() + "/" + this.getDag();
		return output;
	}
	
	public String toStringInEuropees() {
		String output = "";
		output += this.getDag() + "/" + this.getMaand() + "/" + this.getJaar();
		return output;
	}
	
	public boolean isKleiner (Datum d2){
		GregorianCalendar hulp = new GregorianCalendar(d2.getJaar(),d2.getMaand(),d2.getDag());
		
		return datum.compareTo(hulp) < 0;
	}
	
	public boolean equals(Datum d2){
		return this.getDag()==d2.getDag() && this.getMaand() == d2.getMaand() && this.getJaar() == d2.getJaar();				
	}
	
	public int compareTo(Datum datum) throws DatumException {
		if ((this == null) || (datum == null) || (!(datum instanceof Datum)))
			throw new DatumException();
		else {
			GregorianCalendar meegegevenDatum = datum.getGregorianCalendar();
			return this.datum.compareTo(meegegevenDatum);
		}
	}	
	
	public void verhoogDagen(int aantalDagen){
		datum.add(Calendar.DAY_OF_MONTH, aantalDagen);
	}
	public void verhoogMaanden(int aantalMaanden){
		datum.add(Calendar.MONTH, aantalMaanden);
	}
	public void verhoogJaren(int aantalJaren){
		datum.add(Calendar.YEAR,aantalJaren);
	}
	
	public int verschilInDagen(Datum d2){		
		Datum kleinste = this.isKleiner(d2)?this:d2;
		int aantalDagen = 0;
		while (!kleinste.equals(d2)){
			aantalDagen++;
			kleinste.verhoogDagen(1);			
		}		
		return aantalDagen;
	}
	public int verschilInMaanden(Datum d2){
		Datum kleinste = this.isKleiner(d2)?this:d2;
		int aantalMaanden =0;
		while (!kleinste.equals(d2)){
			aantalMaanden++;
			kleinste.verhoogMaanden(1);
		}
		return aantalMaanden;
	}
	public int verschilInJaren(Datum d2){
		Datum kleinste = this.isKleiner(d2)?this:d2;
		int aantalJaren =0;
		while (!kleinste.equals(d2)){
			aantalJaren++;
			kleinste.verhoogJaren(1);
		}
		return aantalJaren;
	}
	

	public static void main (String [] args) throws DagException, MaandException{
		Datum d1 = new Datum();
		System.out.println(d1);
		Datum d2 = new Datum(25,12,2012);
		
		System.out.println(d2);
		System.out.println(d1);
		System.out.println("Kleinste "+(d1.isKleiner(d2)?d1:d2));
		System.out.println("Verschil: "+d1.verschilInDagen(d2));		
	}
	public GregorianCalendar getGregorianCalendar()
	{
		return datum;
	}
	// boolean isKleinerDan (Datum datum) : bepaalt of een gegeven datum kleiner is dan huidig datumobject
	public boolean isKleinerDan(Datum datum) throws DatumException {
		if ((this == null) || (datum == null) || (!(datum instanceof Datum)))
			throw new DatumException();
		else {
			if(this.compareTo(datum) > 0)
				return true;
			else
				return false;
		}
	}
	private boolean set(int dag, int maand, int jaar) throws DagException, MaandException {
		boolean ok = false;
		int maxdagen = 0;
		if(maand > 12)
			{throw new MaandTeGrootException();}
		else 
			{
				if(maand < 1) {throw new MaandTeKleinException();}
			
				if(maand == 4 || maand == 6 || maand == 9 || maand == 11) 
					{maxdagen = 30;}
				else 
				{ 
					if (maand == 2) 
					{
						if(this.isSchrikkeljaar())
							{maxdagen = 29;}
						else
							{maxdagen = 28;}
					}
					else
					{
						if(maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12)	
							maxdagen = 31;
					}
				}
		
				if(dag > maxdagen)
				{
					if(dag == 29 && maand == 2 && !this.isSchrikkeljaar()) 
						throw new DagTeGrootDoorSchrikkeljaarException();
					else
						throw new DagTeGrootException();
				}
				else 
				{
					if(dag < 1)
					{
						throw new DagTeKleinException();
					}
					else 
					{
						ok = true;
					}
				}
			}
		return ok;
	}
	
	public boolean isSchrikkeljaar(){
	{
		int jaar = datum.get(Calendar.YEAR);
		return (jaar % 4 == 0) && ((jaar % 100 != 0) || (jaar % 400 == 0));}
	}

}
