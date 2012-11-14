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
public class Quiz {


	private int quizId;
	private String  onderwerp;
	private ArrayList<Leerjaar> leerjaren;
	private boolean isTest;
	private boolean isUniekeDeelname;
	private QuizStatus quizStatus;
	private Leraar auteur;
	private List <QuizOpdracht> quizOpdrachten;
	
	public Quiz (String onderwerp){
		this.onderwerp = onderwerp;
		quizOpdrachten = new ArrayList <QuizOpdracht>();
	}
	/**
	 * @return the quizDeelnamen
	 */

	private Datum datumRegistratie;
	
	/**
	 * *default constructor for Quiz
	 * QuizStatus = IN_CONSTRUCTIE
	 * datumRegistratie = new Datum
	 */
	
	public Quiz()
	{
		onderwerp = null;
		leerjaren = null;
		isTest = false;
		isUniekeDeelname = false;
		quizStatus = QuizStatus.IN_CONSTRUCTIE;
		auteur = null;
		datumRegistratie = new Datum();
		quizOpdrachten = new ArrayList <QuizOpdracht>();
	}
	
	/**Constructor with imput parameters 
	 *@params onderwerp, isTest, isUniekeDeelname, auteur
	 */
	
	public Quiz(String onderwerp, boolean isTest, boolean isUniekeDeelname,
			Leraar auteur) {
		super();
		quizStatus = QuizStatus.IN_CONSTRUCTIE;
		datumRegistratie = new Datum();
		this.onderwerp = onderwerp;
		this.isTest = isTest;
		this.isUniekeDeelname = isUniekeDeelname;
		this.auteur = auteur;
		quizOpdrachten = new ArrayList <QuizOpdracht>();
	}
	public Quiz(int quizId, String onderwerp, ArrayList<Leerjaar> leerjaren,
			boolean isTest, boolean isUniekeDeelname, QuizStatus quizStatus,
			Leraar auteur, List<QuizOpdracht> quizOpdrachten,
			Datum datumRegistratie) {
		super();
		this.quizId = quizId;
		this.onderwerp = onderwerp;
		this.leerjaren = leerjaren;
		this.isTest = isTest;
		this.isUniekeDeelname = isUniekeDeelname;
		this.quizStatus = quizStatus;
		this.auteur = auteur;
		this.quizOpdrachten = quizOpdrachten;
		this.datumRegistratie = datumRegistratie;
	}
	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht){
		quizOpdrachten.add(quizOpdracht);
	}
	protected void verwijderdQuizOpdracht(QuizOpdracht quizOpdracht){
		quizOpdrachten.remove(quizOpdracht);
		
	}
	public ArrayList <Opdracht> getOpdrachten(OpdrachtCatalogus opdrachtCatalogus){
		ArrayList <Opdracht> opdrachten = new ArrayList <Opdracht>();
		for (QuizOpdracht quizOpdracht :quizOpdrachten){
			opdrachten.add(quizOpdracht.getOpdracht(opdrachtCatalogus));
		}
		return opdrachten;
	}
	
	public int[] getOpdrachten(){
		int[] opdrachten = new int[quizOpdrachten.size()];
		for (int i= 0; i< quizOpdrachten.size(); i++)
		{
			opdrachten[i] = quizOpdrachten.get(i).getOpdrachtId();
		}
		return opdrachten;
	}
	
	public ArrayList<Leerjaar> getLeerjaren() {
		return leerjaren;
	}

	public void setQuizOpdrachten(List<QuizOpdracht> quizOpdrachten) {
		this.quizOpdrachten = quizOpdrachten;
	}	
	public QuizOpdracht getOpdracht(int volgnr){
		return quizOpdrachten.get(volgnr-1);
	}
	
	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	/**
	 * @param quizStatus the quizStatus to set
	 */
	public void setQuizStatus(QuizStatus quizStatus) {
		this.quizStatus = quizStatus;
	}
	/**
	 * @return the onderwerp
	 */
	public String getOnderwerp() {
		return onderwerp;
	}
	/**
	 * @param onderwerp the onderwerp to set
	 */
	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}
	/**
	 * @return the isTest
	 */
	public boolean isTest() {
		return isTest;
	}
	/**
	 * @param isTest the isTest to set
	 */
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}
	/**
	 * @return the isUniekeDeelname
	 */
	public boolean isUniekeDeelname() {
		return isUniekeDeelname;
	}
	/**
	 * @param isUniekeDeelname the isUniekeDeelname to set
	 */
	public void setUniekeDeelname(boolean isUniekeDeelname) {
		this.isUniekeDeelname = isUniekeDeelname;
	}
	/**
	 * @return the quizStatus
	 */
	public QuizStatus getQuizStatus() {
		return quizStatus;
	}
	/**
	 * @return the auteur
	 */
	public Leraar getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the datumRegistratie
	 */
	public Datum getDatumRegistratie() {
		return datumRegistratie;
	}

	/**
	 * @param datumRegistratie the datumRegistratie to set
	 */
	public void setDatumRegistratie(Datum datumRegistratie) {
		this.datumRegistratie = datumRegistratie;
	}

	/**
	 * @param leerjaren the leerjaren to set
	 */
	public void setLeerjaren(ArrayList<Leerjaar> leerjaren) {
		this.leerjaren = leerjaren;
	}
	public boolean isWijzigbaar()
	{
		if (this.quizStatus == QuizStatus.IN_CONSTRUCTIE)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public boolean isVerwijderbaar()
	{
		if (this.quizStatus == QuizStatus.IN_CONSTRUCTIE || this.quizStatus == QuizStatus.AFGEWERKT)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean isOpengesteld()
	{
		if (this.quizStatus == QuizStatus.OPENGESTELD)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((onderwerp == null) ? 0 : onderwerp.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (onderwerp == null) {
			if (other.onderwerp != null)
				return false;
		} else if (!onderwerp.equals(other.onderwerp))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Quiz [onderwerp=" + onderwerp + ", leerjaren=" + leerjaren
				+ ", isTest=" + isTest + ", isUniekeDeelname="
				+ isUniekeDeelname + ", quizStatus=" + quizStatus + ", auteur="
				+ auteur + ", datumRegistratie=" + datumRegistratie + "]";
	}
	
	public ArrayList<QuizOpdracht> getQuizOpdrachten(){
		ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
		
		//op basis van opgeslagen quizOpdrachten een lijst opmaken.
		
		return quizOpdrachten;
	}
}
