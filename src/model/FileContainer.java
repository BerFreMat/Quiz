package model;
import java.io.*;
import java.util.Formatter;
import java.util.List;


public abstract class FileContainer {
	
	/**
	 * filename opgeslagen catalogus
	 * @return String met bestandsnaam
	 */
	public abstract String getFile();
	
	/**
	 * Deformatteer lijn. .
	 * @param lijn
	 * @throws Exception
	 */
	public abstract void deformatteerLijn(String lijn) throws Exception;
	
	/**
	 * Geeft een List met de op te slagen objecten.
	 * @return
	 */
	public abstract List teSchrijvenLijst();
	
	/**
	 * Formatteert elk object naar een String die later opnieuw omgezet kan worden in een object.
	 * @param O = object dat moet omgezet worden in een string
	 * @return
	 */
	public abstract String formatteerObject(Object obj) ;
	
	public void lezen() throws Exception{
		try{
			File file = new File(getFile());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String lijn = null;
			while ((lijn = reader.readLine()) != null){
				System.out.println("voor deformatteerLijn");
				deformatteerLijn(lijn);
			}
			reader.close();
		}
		catch (Exception ex){
			throw(ex);
		}
	}
	
	public void schrijfNaarBestand() throws Exception {
		Formatter schrijver = null;

		try {
			// open file
			schrijver = new Formatter(new File(getFile()));
			
			// records schrijven
			for (Object obj : teSchrijvenLijst()) {
				System.out.println(obj);
				String teSchrijvenLijn =  formatteerObject(obj);
				System.out.println("te schrijven lijn " + teSchrijvenLijn);
				if(teSchrijvenLijn != null)
				{
					schrijver.format("%s%n", teSchrijvenLijn);
				}
			}
		} catch (SecurityException ex) {
			throw new Exception("Geen schrijftoegeang tot bestand");
		} catch (FileNotFoundException ex) {
			throw new Exception("Kan bestand niet openen");
		} finally {
			// sluit schrijver
			if (schrijver != null){
				schrijver.close();
			}
		}
	}
	

}
