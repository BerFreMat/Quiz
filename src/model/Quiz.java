
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.Serializable;

import exceptions.DagException;
import exceptions.MaandException;

import utils.Datum;

/**
 *  Class voor het aanmaken van een Quiz
 @author
 *
 */
public class Quiz implements Serializable, PersisteerbaarAlsTekst {
	public class QuizComparator {

	}
	
	/**
	 * Attributen
	 */
	private int quizId;
	private String  onderwerp;
	private boolean isTest;
	private boolean isUniekeDeelname;
	private QuizStatus quizStatus;
	private Leraar auteur;
	private List <QuizOpdracht> quizOpdrachten;
	private DatumGregorian.Datum datumRegistratie;
	public List<Leerjaar> leerjaren;
	
	/**
	 * Constructor
	 * @param onderwerp van de quiz          
	 */
	public Quiz (String onderwerp){
		this.onderwerp = onderwerp;
		quizOpdrachten = new ArrayList <QuizOpdracht>();
		quizStatus = QuizStatus.IN_CONSTRUCTIE;
	}

	
	/**
	 * *default constructor for Quiz
	 * QuizStatus = IN_CONSTRUCTIE
	 * datumRegistratie = new Datum
	 * @throws MaandException 
	 * @throws DagException 
	 */
	
	public Quiz() throws DagException, MaandException
	{
		onderwerp = null;
		isTest = false;
		isUniekeDeelname = false;
		quizStatus = QuizStatus.IN_CONSTRUCTIE;
		auteur = null;
		new Datum();
		quizOpdrachten = new ArrayList <QuizOpdracht>();
	}
	
	/**Constructor met imput parameters 
	 * @throws MaandException 
	 * @throws DagException 
	 *@params onderwerp, isTest, isUniekeDeelname, auteur
	 */
	
	public Quiz(String onderwerp, boolean isTest, boolean isUniekeDeelname,
			Leraar auteur) throws DagException, MaandException {
		super();
		quizStatus = QuizStatus.IN_CONSTRUCTIE;
		new Datum();
		this.onderwerp = onderwerp;
		this.isTest = isTest;
		this.isUniekeDeelname = isUniekeDeelname;
		this.auteur = auteur;
		quizOpdrachten = new ArrayList <QuizOpdracht>();
	}
	public Quiz(int quizId, String onderwerp, List<Leerjaar> leerjaren,
			boolean isTest, boolean isUniekeDeelname, QuizStatus quizStatus,
			Leraar auteur, List<QuizOpdracht> quizOpdrachten,
			DatumGregorian.Datum datumRegistratie) {
		super();
		
		controlLeerjaar(leerjaren);
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
	
	
	/**
	 * Get opdrachten uit lijst QuizOpdracht
	 * @return
	 */
	public int[] getOpdrachten(){
		int[] opdrachten = new int[quizOpdrachten.size()];
		for (int i= 0; i< quizOpdrachten.size(); i++)
		{
			opdrachten[i] = quizOpdrachten.get(i).getOpdrachtId();
		}
		return opdrachten;
	}
	
	public String getOnderwerp() {
		return onderwerp;
	}
	
	
	public List<Leerjaar> getLeerjaren() {
		return leerjaren;
	}

	public QuizOpdracht getOpdracht(int volgnr){
		return quizOpdrachten.get(volgnr-1);
	}
	
	public int getQuizId() {
		return quizId;
	}
	
	public QuizStatus getQuizStatus() {
		return quizStatus;
	}
	
	public Leraar getAuteur() {
		return auteur;
	}
	
	public DatumGregorian.Datum getDatumRegistratie() {
		return datumRegistratie;
	}
	
	
	/**
	 * Set lijst QuizOpdrachten
	 * @param quizOpdrachten
	 */
	public void setQuizOpdrachten(List<QuizOpdracht> quizOpdrachten) {
		this.quizOpdrachten = quizOpdrachten;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	
	public void setQuizStatus(QuizStatus quizStatus) {
		this.quizStatus = quizStatus;
	}
	
	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}
	/**
	 * Set opdracht als test
	 * @return
	 */
	public boolean isTest() {
		return isTest;
	}
	
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}
	/**
	 * Set opdracht als unieke deelname
	 * @return
	 */
	public boolean isUniekeDeelname() {
		return isUniekeDeelname;
	}
	
	public void setUniekeDeelname(boolean isUniekeDeelname) {
		this.isUniekeDeelname = isUniekeDeelname;
	}

	public void setAuteur(Leraar auteur) {
		this.auteur = auteur;
	}

	public void setDatumRegistratie(DatumGregorian.Datum datum) {
		this.datumRegistratie = datum;
	}

	public void setLeerjaren(ArrayList<Leerjaar> leerjaren) {
		controlLeerjaar(leerjaren);
		this.leerjaren = leerjaren;
	}
	
	/**
	 * Control leerjaar geldige waarde min 1 en max 6
	 * 
	 * @param 
	 * @return 
	 * @author 
	 */
	
	public void controlLeerjaar(List<Leerjaar> leerjaren2)
	{
		for (Leerjaar leerjaar :leerjaren2){
			if (leerjaar.getLeerjaarInt() < 1 || leerjaar.getLeerjaarInt() > 6)
			{
				throw new IllegalArgumentException("Leerjaar moet tussen 1 en 6 zijn");
			}
		}
	}
/**
 * Check status quiz
 * @return
 */
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
	
	/**
	 * Override String-methode
	 * Comparator Class is innerclass 't wordt gebruikt door Quiz class
	 * quizen gerangschikt op aantal opdrachten en opdrachten alfabetisch
	 * @return
	 */
	
	public static Comparator<Quiz> QuizComparator() {
		return new Comparator<Quiz>() {
			@Override
			public int compare(Quiz quiz1, Quiz quiz2) {
				if (quiz1.compareTo(quiz2) == 0) {
					return 0;
				} else if (quiz1.getOpdrachten().length == quiz2
						.getOpdrachten().length) {
					return (quiz1.getOnderwerp()
							.compareTo(quiz2.getOnderwerp()));
				} else if (quiz1.getOpdrachten().length < quiz2.getOpdrachten()
						.length) {
					return -1;
				} else {
					return 1;
				}
			}
		};
	}
	
	public String toTreeMap(){
		return ("Aantal opdrachten: " + getOpdrachten().length + "\n\t " + getOnderwerp());
	}

	protected int compareTo(Quiz quiz) {
		if (this.equals(quiz)) {
			return 0;
		} else if (this.hashCode() < quiz.hashCode()) {
			return -1;
		} else
			return 1;
	}

	@Override
	public String toString() {
		String tekst = "";
		if (isTest) {
			tekst = ", Deze quiz is een test";
		} else {
			
			tekst = ", Deze quiz is geen test";
		}
		if (isUniekeDeelname) {
			tekst += "en uniek deelname,";
			
		} else {
			tekst += "en het is geen unieke deelname,";
		}
		tekst += " status van de quiz is ";
		
		String aangemaakteQuiz = "";
		
		aangemaakteQuiz += "Quiz : " + onderwerp + "\n" + " voor de leerjaren "
				+ leerjaren +" , aangemaakt op "+ datumRegistratie
				+ " door " + auteur + tekst + quizStatus;
		return aangemaakteQuiz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((onderwerp == null) ? 0 : onderwerp.hashCode());
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
		Quiz other = (Quiz) obj;
		if (onderwerp == null) {
			if (other.onderwerp != null)
				return false;
		} else if (!onderwerp.equals(other.onderwerp))
			return false;
		return true;
	}


	public List<QuizOpdracht> getQuizOpdrachten(){		
		return  quizOpdrachten;
	}

	@Override
	public void maakObjectVanString(String lijn) throws Exception {
		String[] velden = lijn.split(":");
		this.setQuizId(Integer.parseInt(velden[0]));
		this.setOnderwerp(velden[1]);
		this.setLeerjaren(deformatteerLeerjaren(velden[2]));
		this.setTest(Boolean.valueOf(velden[3]));
		this.setUniekeDeelname(Boolean.valueOf(velden[4]));
		this.setQuizStatus(QuizStatus.valueOf(velden[5]));
		this.setAuteur(deformatteerAuteur(velden[6]));
		this.setQuizOpdrachten(deformatteerQuizOpdrachten(velden[7]));
		this.setDatumRegistratie(new DatumGregorian.Datum(velden[8]));
	}

	@Override
	public String formatteerObjectNaarString() {
		return String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s", 
		this.getQuizId(),
		this.getOnderwerp(),
		formatteerLeerjaren(this.getLeerjaren()),
		this.isTest(),
		this.isUniekeDeelname(),
		this.getQuizStatus(),
		this.getAuteur(),
		formatteerQuizOpdrachten(this.getQuizOpdrachten()),
		this.getDatumRegistratie().toStringInEuropees());
	}
	
	private String formatteerQuizOpdrachten(
			List<QuizOpdracht> quizOpdrachten) {
		
		String geformatteerdeQuizOprdrachten = new String();
		for (QuizOpdracht quizOpdracht : quizOpdrachten) {
			geformatteerdeQuizOprdrachten +=  quizOpdracht.formatteerObjectNaarString() + ";";
		}
		return geformatteerdeQuizOprdrachten;
	}
	
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

	public String formatteerLeerjaren(List<Leerjaar> leerjaren)
	{	
		String geformatteerdeLeerjaren ="";
		if(leerjaren!= null)
		{
			for(Leerjaar leerjaar : leerjaren )
			{
				geformatteerdeLeerjaren += leerjaar.toString() + ";";
			}
		}
		else{
			geformatteerdeLeerjaren = null;
		}
		return geformatteerdeLeerjaren;
	}
	
	public ArrayList<Leerjaar> deformatteerLeerjaren(String leerjaren)
	{
		String[] leerjarenGesplit = leerjaren.split(";");
		ArrayList<Leerjaar> leerjarenLijst = new ArrayList<Leerjaar>();
		
		for(int i = 0 ; i < leerjarenGesplit.length - 1 ; i ++)
		{
			leerjarenLijst.add(Leerjaar.valueOf(leerjarenGesplit[i]));
		}
		return leerjarenLijst;
	}	
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
}
