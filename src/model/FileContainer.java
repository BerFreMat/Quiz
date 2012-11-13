package model;
import java.io.*;
import java.util.Formatter;


public abstract class FileContainer {

	public void lezen(){
		try{
			File file = new File(getFile());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String lijn = null;
			while ((lijn = reader.readLine()) != null){
				toevoegenLijn(lijn);
			}
			reader.close();
		}
		catch (Exception ex){
			
		}
	}
	
	public abstract String getFile();
	
	public abstract void toevoegenLijn(String lijn) throws Exception;	
	
	public void schrijfBestand() throws Exception {
		Formatter schrijver = null;

		try {
			// open file
			schrijver = new Formatter(new File(getFile()));
			
			// records schrijven
			String[] teSchrijvenLijnen = this.teSchrijvenLijnen();
			
			for (String s : teSchrijvenLijnen) {
				schrijver.format("%s %n", s);				
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
	
	public abstract String[] teSchrijvenLijnen() ;
	

}
