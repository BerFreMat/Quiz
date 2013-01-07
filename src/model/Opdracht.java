
package model;

import java.util.ArrayList;
import java.util.List;

import DatumGregorian.Datum;

/**
 * Maakt opdracht inmplementeer PersisteerbaarAlsTekst 
 * dat Formatteert elk object naar een String die later opnieuw omgezet kan worden in een object.
 * @author java
 *
 */
public abstract class Opdracht implements PersisteerbaarAlsTekst {

	private String vraag;
	private String juisteAntwoord;	
	private int maxAantalPogingen;
	private ArrayList<String> antwoordHints;
	private int maxAntwoordTijd;  //Tijd in seconden. 0 = oneindig
	private Datum datumRegistratie;
	private Leraar auteur;
	private OpdrachtCategorie categorie;
	private OpdrachtSoort opdrachtSoort; 
	private int opdrachtId;
	private List <QuizOpdracht> quizOpdrachten;
	
	/**
	 * constructor met aantal pogingen, datum en maximum antwoord tijd
	 */
	public Opdracht() {
		super();
		maxAantalPogingen = 1;
		datumRegistratie = new Datum();
		maxAntwoordTijd = 0;
		
	}	
	/**
	 * Overloaded constructor1 met vraag en juiste antwoord als String
	 * @param vraag
	 * @param juisteAntwoord
	 */
	
	public Opdracht(String vraag, String juisteAntwoord) {
		super();
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		maxAantalPogingen = 1;
		datumRegistratie = new Datum();
		maxAntwoordTijd = 0;
		quizOpdrachten = new ArrayList<QuizOpdracht>();
		
	}
	/**
	 * Overloaded constructor2 met vraag en juiste antoord als String, naam leraar en categorie
	 * @param vraag
	 * @param juisteAntwoord
	 * @param auteur
	 * @param categorie
	 */
	public Opdracht(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie) {
		super();
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		this.auteur = auteur;
		this.categorie = categorie;
		maxAantalPogingen = 1;
		datumRegistratie = new Datum();
		maxAntwoordTijd = 0;
		this.opdrachtId = -1;
		quizOpdrachten = new ArrayList <QuizOpdracht>();
	}
	
	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht){
		quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht){
		quizOpdrachten.remove(quizOpdracht);
	}
	
	public String getOpgave() {
		return vraag;
	}
	public void setOpgave(String vraag) {
		this.vraag = vraag;
	}
	public String getjuisteAntwoord() {
		return juisteAntwoord;
	}
	public void setjuisteAntwoord(String juisteAntwoord) {
		this.juisteAntwoord = juisteAntwoord;
	}
	public String getVraag() {
		return vraag;
	}
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	public int getMaxAantalPogingen() {
		return maxAantalPogingen;
	}
	public void setMaxAantalPogingen(int maxAantalPogingen) {
		this.maxAantalPogingen = maxAantalPogingen;
	}
	public int getMaxAntwoordTijd() {
		return maxAntwoordTijd;
	}
	public void setMaxAntwoordTijd(int maxAntwoordTijd) {
		this.maxAntwoordTijd = maxAntwoordTijd;
	}
	public Datum getDatumRegistratie() {
		return datumRegistratie;
	}
	public void setDatumRegistratie(Datum datumRegistratie) {
		this.datumRegistratie = datumRegistratie;
	}
	public Leraar getAuteur() {
		return auteur;
	}
	public void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}
	public OpdrachtCategorie getCategorie() {
		return(categorie==null)? OpdrachtCategorie.ALGEMEEN : categorie;
		
	}
	public void setCategorie(OpdrachtCategorie categorie) {
		this.categorie = categorie;
	}
	public ArrayList<String> getAntwoordHints() {
		return antwoordHints;
	}
	public void setAntwoordHints(ArrayList<String> antwoordHints) {
		this.antwoordHints = antwoordHints;
	}
	public boolean isJuisteAntwoord(String antwoord) throws Exception{
		if( antwoord.equalsIgnoreCase(this.juisteAntwoord))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void toevoegenAntwoordHint(String antwoordHint)	{
		antwoordHints.add(antwoordHint);		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vraag == null) ? 0 : vraag.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 */
	/**
	 * Equals methode is volledig gebaseerd op de vraag
	 * Als de vraag gelijk is worden twee opdrachten als gelijk beschouwd.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opdracht other = (Opdracht) obj;
		if (vraag == null) {
			if (other.vraag != null)
				return false;
		} else if (!vraag.equals(other.vraag))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Opdracht [vraag=" + vraag + ", juisteAntwoord="
				+ juisteAntwoord + ", maxAantalPogingen=" + maxAantalPogingen
				+ ", antwoordHints=" + antwoordHints + ", maxAntwoordTijd="
				+ maxAntwoordTijd + ", datumRegistratie=" + datumRegistratie
				+ ", auteur=" + auteur + ", categorie=" + categorie + "]";
	}
	
	public String toonOplossing(){
		return "vraag: " + vraag + ", juisteAntwoord="
				+ juisteAntwoord + ", antwoordhints" + antwoordHints.toString();
	}
	public OpdrachtSoort getOpdrachtSoort() {
		return(opdrachtSoort==null)? OpdrachtSoort.EENVOUDIGE_VRAAG : opdrachtSoort;
	}
	public void setOpdrachtSoort(OpdrachtSoort opdrachtSoort) {
		this.opdrachtSoort = opdrachtSoort;
	}
	public int getOpdrachtId() {
		return opdrachtId;
	}
	public void setOpdrachtId(int opdrachtId) {
		this.opdrachtId = opdrachtId;
	}

	public String getJuisteAntwoord() {
		return juisteAntwoord;
	}

	public void setJuisteAntwoord(String juisteAntwoord) {
		this.juisteAntwoord = juisteAntwoord;
	}

	public List<QuizOpdracht> getQuizOpdrachten() {
		return quizOpdrachten;
	}

	public void setQuizOpdrachten(List<QuizOpdracht> quizOpdrachten) {
		this.quizOpdrachten = quizOpdrachten;
	}

	public void verwijderdQuizOpdracht(QuizOpdracht quizOpdracht) {
		quizOpdrachten.remove(quizOpdracht);
	}
	/**
	 * Maak string object met ":" als scheidingsteken
	 * Vraag : JuisteAntwoord : MaxAantalPogingen : AntwoordHints : MaxAntwoordTijd
	 * : Auteur : Categorie : OpdrachtSoort : OpdrachtId : QuizOpdrachten : DatumRegistratie
	 */
	@Override
	public void maakObjectVanString(String lijn) throws Exception {
		String[] velden = lijn.split(":");
		this.setVraag(velden[0]);
		this.setJuisteAntwoord(velden[1]);
		this.setMaxAantalPogingen(Integer.parseInt(velden[2]));
		this.setAntwoordHints(this.deformatteerAntwoordHints(velden[3]));
		this.setMaxAntwoordTijd(Integer.parseInt(velden[4]));
		this.setAuteur(deformatteerAuteur(velden[5]));
		this.setCategorie(deformatteerOpdrachtCategorie(velden[6]));
		this.setOpdrachtSoort(OpdrachtSoort.valueOf(velden[7]));
		this.setOpdrachtId(Integer.parseInt(velden[8]));
		this.setQuizOpdrachten(deformatteerQuizOpdrachten(velden[9]));
		this.setDatumRegistratie(new DatumGregorian.Datum(velden[10]));
	}
/**
 * Formateer string 
 */
	@Override
	public String formatteerObjectNaarString() {
		System.out.println(String.format("%s:%s", 
				this.getVraag(),
				this.getJuisteAntwoord()));
		
		
		return String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s:%s:%s", 
		this.getVraag(),
		this.getJuisteAntwoord(),
		this.getMaxAantalPogingen(),
		this.formatteerAntwoordHints(antwoordHints),
		this.getMaxAntwoordTijd(),
		this.getAuteur(),
		this.getCategorie(),
		this.getOpdrachtSoort(),
		this.getOpdrachtId(),
		formatteerQuizOpdrachten(this.getQuizOpdrachten()),
		this.getDatumRegistratie().toStringInEuropees());
	}
	/**
	 * Geef quiz opdrachten uit de lijst en formateer naar string met ";" als scheidingsteken
	 * @param quizOpdrachten
	 * @return
	 */
	private String formatteerQuizOpdrachten(
			List<QuizOpdracht> quizOpdrachten) {
		
		String geformatteerdeQuizOprdrachten = new String();
		for (QuizOpdracht quizOpdracht : quizOpdrachten) {
			geformatteerdeQuizOprdrachten +=  quizOpdracht.formatteerObjectNaarString() + ";";
		}
		return geformatteerdeQuizOprdrachten;
	}
	/**
	 * Deformateer quiz opdrachten van ArrayList met ";" als scheidingsteken
	 * @param quizOpdrachten
	 * @return
	 * @throws Exception
	 */
	private ArrayList<QuizOpdracht> deformatteerQuizOpdrachten(String quizOpdrachten) throws Exception {
		if (!quizOpdrachten.equals("null"))
		{
			String[] quizOpdrachtenGesplit = quizOpdrachten.split(";");
			ArrayList<QuizOpdracht> quizOpdrachtenLijst = new ArrayList<QuizOpdracht>();
			for(int i = 0 ; i < quizOpdrachtenGesplit.length - 1 ; i ++)
			{
				QuizOpdracht quizOprdracht =  new QuizOpdracht();
				quizOprdracht.maakObjectVanString(quizOpdrachtenGesplit[i]);
				quizOpdrachtenLijst.add(quizOprdracht);
			}
			return quizOpdrachtenLijst;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Maakt string van antwoord hints in ArrayList met ";" als scheidingsteken
	 * @param antwoordHints
	 * @return
	 */
	
	private String formatteerAntwoordHints(
			ArrayList<String> antwoordHints) {
		
		if(antwoordHints != null)
		{
			String geformatteerdeAntwoordHints = new String();
			for (String antwoordHint : antwoordHints) {
				geformatteerdeAntwoordHints +=  antwoordHint + ";";
			}
			return geformatteerdeAntwoordHints;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Deformateer antwoord hints van ArrayList met ";" als scheidingsteken
	 * @param antwoordHints
	 * @return
	 */
	private ArrayList<String> deformatteerAntwoordHints(String antwoordHints)  {
		if (!antwoordHints.equals("null"))
		{
			String[] antwoordHintsGesplit = antwoordHints.split(";");
			ArrayList<String> antwoordHintsLijst = new ArrayList<String>();
			for(int i = 0 ; i < antwoordHintsGesplit.length - 1 ; i ++)
			{
				antwoordHintsLijst.add(antwoordHintsGesplit[i]);
			}
			return antwoordHintsLijst;
		}
		else
		{
			return null;
		}
	}
	/**
	 * Deformateer leraar als String auteur
	 * @param auteur
	 * @return
	 */
	private Leraar deformatteerAuteur(String auteur) {
		if(!auteur.equals("null"))
		{
			return Leraar.valueOf(auteur);
		}
		else
		{
			return null;
		}
	}
	/**
	 * Defotmateer opdracht categorie ans String
	 * @param opdrachtCategorie
	 * @return
	 */
	private OpdrachtCategorie deformatteerOpdrachtCategorie(String opdrachtCategorie) {
		if(!opdrachtCategorie.equals("null"))
		{
			return OpdrachtCategorie.valueOf(opdrachtCategorie);
		}
		else
		{
			return null;
		}
	}
	
}