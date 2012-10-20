package DatumGregorian;
import java.util.*;

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
	
	public Datum (int dag,int maand,int jaar){
		datum = new GregorianCalendar(jaar,maand-1,dag);
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
	
	
	public String toString(){
		int dag = datum.get(Calendar.DAY_OF_MONTH);
		int maand = datum.get(Calendar.MONTH)+1;
		int jaar = datum.get(Calendar.YEAR);
		
		return dag+"/"+maand+"/"+jaar;
	}
	
	public boolean isKleiner (Datum d2){
		GregorianCalendar hulp = new GregorianCalendar(d2.getJaar(),d2.getMaand(),d2.getDag());
		
		return datum.compareTo(hulp) < 0;
	}
	
	public boolean equals(Datum d2){
		return this.getDag()==d2.getDag() && this.getMaand() == d2.getMaand() && this.getJaar() == d2.getJaar();				
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
	

	public static void main (String [] args){
		Datum d1 = new Datum();
		System.out.println(d1);
		Datum d2 = new Datum(25,12,2012);
		
		System.out.println(d2);
		System.out.println(d1);
		System.out.println("Kleinste "+(d1.isKleiner(d2)?d1:d2));
		System.out.println("Verschil: "+d1.verschilInDagen(d2));		
	}
}
