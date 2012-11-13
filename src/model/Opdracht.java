/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import DatumGregorian.Datum;

/**
 * @author java
 *
 */
public abstract class Opdracht {

	private String vraag;
	private String juisteAntwoord;	
	private int maxAantalPogingen;
	private ArrayList<String> antwoordHints;
	private int maxAntwoordTijd;  //Tijd in seconden. 0 = oneindig veel tijd.
	private Datum datumRegistratie;
	private Leraar auteur;
	private OpdrachtCategorie categorie;
	private OpdrachtSoort opdrachtSoort; 
	private int opdrachtId;
	private List <QuizOpdracht> quizOpdrachten;
	
	public Opdracht() {
		super();
		maxAantalPogingen = 1;
		datumRegistratie = new Datum();
		maxAntwoordTijd = 0;
		
		// TODO Auto-generated constructor stub
	}	
	
	public Opdracht(String vraag, String juisteAntwoord) {
		super();
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		maxAantalPogingen = 1;
		datumRegistratie = new Datum();
		maxAntwoordTijd = 0;
		quizOpdrachten = new ArrayList<QuizOpdracht>();
		
		// TODO Auto-generated constructor stub
	}
	
	public Opdracht(String vraag, String juisteAntwoord, Leraar auteur,
			OpdrachtCategorie categorie, int opdrachtId) {
		super();
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		this.auteur = auteur;
		this.categorie = categorie;
		maxAantalPogingen = 1;
		datumRegistratie = new Datum();
		maxAntwoordTijd = 0;
		this.opdrachtId = opdrachtId;
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
		return categorie;
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
	public boolean isJuisteAntwoord(String antwoord){
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
	 * equals methode is volledig gebaseerd op de vraag en opdrachtId.
	 * Als de vraag gelijk is worden twee opdrachten als gelijk beschouwd.
	 * Als de opdrachtId gelijk is worden twee opdrachten als gelijk beschouwd.
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
		return opdrachtSoort;
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
}
