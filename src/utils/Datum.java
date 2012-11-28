package utils;
import java.util.Date;

import exceptions.DagException;
import exceptions.DagTeGrootDoorSchrikkeljaarException;
import exceptions.DagTeGrootException;
import exceptions.DagTeKleinException;
import exceptions.DatumException;
import exceptions.DatumStringException;
import exceptions.MaandException;
import exceptions.MaandTeGrootException;
import exceptions.MaandTeKleinException;


	public class Datum {
			private int dag, maand, jaar;
		
		/**
		 * Deze class representeert een datum object
		 * 
		 * @author Matias
		 * 
		 * Een constructor zonder parameters (object datum gelijk aan de systeemdatum)
		 * @param /
		 * @throws DagException
		 * @throws MaandException
		 */
		
		public Datum() throws DagException, MaandException {
			Date d = new Date();
			
			int dag = d.getDate();
			int maand = d.getMonth()+1; 	// default = januari = 0 ...
			int jaar = d.getYear()+1900; // year since 1900
			this.set(dag, maand, jaar);
			
		}
		/**
		 * Een constructor met een datum object als parameter
		 * @param datum (Datum)
		 * @throws DatumException 
		 * @throws MaandException 
		 * @throws DagException 
		 */
		public Datum(Datum datum) throws DatumException, DagException, MaandException {
			if((datum == null) || !(datum instanceof Datum))
				throw new DatumException();
			else {
				int dag = datum.getDag();
				int maand = datum.getMaand();
				int jaar = datum.getJaar();
				this.set(dag, maand, jaar);
			}
		}
		/**
		 * Een constructor met parameters dag, maand en jaar (3 gehele getallen)
		 * @param dag (int)
		 * @param maand (int)
		 * @param jaar (int)
		 * @throws DagException
		 * @throws MaandException
		 */
		public Datum(int dag, int maand, int jaar) throws DagException, MaandException {
			this.set(dag, maand, jaar);
		}
		
		/**
		 * Een constructor met een String als parameter. 
		  	In deze String zit de datum in DDMMJJJJ formaat maar tussen de dag, maand en jaar staat een scheidingsteken (Vb 12/05/2009)
		  	Opmerking: maand moet ingegeven worden met 2 cijfers (Vb 05), jaartal met 4 cijfers (Vb 0567), dagnr met 1 of 2 cijfers
		 * @param datum (String)
		 * @throws DatumStringException 
		 * @throws MaandException 
		 * @throws DagException 
		 */
		
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
						this.set(dag, maand, jaar);
					} 
				}
				catch(NumberFormatException nfe)  
				{  
					throw new DatumStringException(); 
				}	
			}
			else {throw new DatumStringException();}
		}
		
		private boolean set(int dag, int maand, int jaar) throws DagException, MaandException {
			boolean ok = false;
			int maxdagen = 0;
			this.jaar = jaar;
			if(maand > 12)
				{throw new MaandTeGrootException();}
			else 
				{
				if(maand < 1) {throw new MaandTeKleinException();}
				else
				{this.maand = maand;}
				}
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
				
				maxdagen = 31;}
				}
		
			
			if(dag > maxdagen)
				if(dag == 29 && maand == 2 && !this.isSchrikkeljaar()) 
					throw new DagTeGrootDoorSchrikkeljaarException();
				else
					throw new DagTeGrootException();
			else if(dag < 1)
				throw new DagTeKleinException();
			else {
				this.dag = dag;
				ok = true;
			}
			return ok;
		}
		
		public int getDag() 
			{return this.dag;}
		public int getMaand() 
			{return this.maand;}
		public int getJaar() 
			{return this.jaar;}
		public boolean isSchrikkeljaar() 
			{return (jaar % 4 == 0) && ((jaar % 100 != 0) || (jaar % 400 == 0));}
			
		
		/**
		 * toString methodes
			toString: geeft datum object terug als volgt: 4 februari 2009
			toStringAmerikaans: geeft een datum in Amerikaans formaat terug (vb 2009/2/4)
			toStringInEuropeesÊ: geeft een datum in Europees formaat terug (vb 4/2/2009)
		 */
		
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
		
		/**
		 * Is deze datum gelijk aan een ander datum object
		 * 
		 * @param datum
		 * @return
		 */
		public boolean equals(Datum datum) throws DatumException {
			if ((this == null) || (datum == null) || (!(datum instanceof Datum)))
			{	
				throw new DatumException();
			}
			
			if (this.getDag() != datum.getDag()) {
				return false;
			} else if (this.getMaand() != datum.getMaand()) {
				return false;
			} else if (this.getJaar() != datum.getJaar()) {
				return false;
			}
			return true;
		}

		
		public int compareTo(Datum datum) throws DatumException {
			if ((this == null) || (datum == null) || (!(datum instanceof Datum)))
				throw new DatumException();
			else {
				// Als datum 1 (this) NA datum 2 (datum) komt ==> 1
				// Als datum 1 (this) VOOR datum 2 (datum) komt ==> -1
				// Indien gelijk ==> 0
				
				if(this.equals(datum)) 
					return 0;
				else if (this.getJaar() > datum.getJaar())
					return 1;
				else if(this.getJaar() < datum.getJaar())
					return -1;
				else {
					if(this.getMaand() > datum.getMaand())
						return 1;
					else if(this.getMaand() < datum.getMaand())
						return -1;
					else {
						if(this.getDag() > datum.getDag())
							return 1;
						else
							return -1;
					}
				}
			}
		}
		
		// boolean isKleinerDan (Datum datum) : bepaalt of een gegeven datum kleiner is dan huidig datumobject
		public boolean isKleinerDan(Datum datum) throws DatumException {
			if ((this == null) || (datum == null) || (!(datum instanceof Datum)))
				throw new DatumException();
			else {
				if(this.compareTo(datum) == 1) 
					return true;
				else
					return false;
			}
		}
	}
	