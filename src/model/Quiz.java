/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.EnumSet;

/**
 * @author java
 *
 */
public class Quiz {

	public String  onderwerp;
	public String[]  leerjaren;
	public boolean isTest;
	public boolean isUniekeDeelname;
	public QuizStatus quizStatus;
	private ArrayList<QuizOpdracht> quizOpdrachten;
	/**
	 * @return the quizOpdrachten
	 */
	private ArrayList<QuizOpdracht> getQuizOpdrachten() {
		return quizOpdrachten;
	}
	/**
	 * @param quizOpdrachten the quizOpdrachten to set
	 */
	private void setQuizOpdrachten(ArrayList<QuizOpdracht> quizOpdrachten) {
		this.quizOpdrachten = quizOpdrachten;
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
	 * @return the leerjaren
	 */
	public String[] getLeerjaren() {
		return leerjaren;
	}
	/**
	 * @param leerjaren the leerjaren to set
	 */
	public void setLeerjaren(String[] leerjaren) {
		this.leerjaren = leerjaren;
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
	 * get all the enum values of quizSatus
	 * 
	 * @param args
	 */
	public static void main (String args[])
	{
		//print all the quizstatus
		for (QuizStatus quizStatus : QuizStatus.values())
			System.out.printf("%-5s%-45s%s\n", quizStatus, quizStatus.getStatus());
	}
	
}
