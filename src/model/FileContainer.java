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
			new File(getFile()).delete();
			schrijver = new Formatter(new File(getFile()));
			
			// records schrijven - zorgen dat laatste lijn geen extra lege lijn toevoegt
			int aantallijnen = teSchrijvenLijst().size();
			List teschrvenlijst = teSchrijvenLijst();
			for (int i=0; i< aantallijnen;i++)
			{
				String teSchrijvenLijn =  formatteerObject(teschrvenlijst.get(i));
				if (i<aantallijnen-1)
				{
					schrijver.format("%s%n", teSchrijvenLijn);
				}
				else
				{
					schrijver.format("%s", teSchrijvenLijn);
				}
			}
			
			/**
			for (Object obj : teSchrijvenLijst()) {
				String teSchrijvenLijn =  formatteerObject(obj);
				if(teSchrijvenLijn != null)
				{
					schrijver.format("%s%n", teSchrijvenLijn);
				}
			}
			*/
			
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
