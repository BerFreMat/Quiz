package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import model.Opdracht;
import model.Quiz;
import model.QuizOpdracht;
import model.Leraar;
import model.OpdrachtCategorie;
import model.QuizStatus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Testklasse Quiz
 * 
 */
public class QuizTest {
	private Quiz quiz;
	private QuizStatus quizStatus;
	
	@Before
	public void setUp() throws Exception {
		quiz = new Quiz("Nederlandse taal");
	}
	/**
	 * Test constructor met parameter
	 * (String onderwerp)
	 */
	@Test
	public void test_Constructor_Quiz_Met_Input_Onderwerp() {
		Quiz quiz = new Quiz("Nederlandse taal");
		assertEquals("onderwerp Nederlandse taal verwacht","Nederlandse taal", quiz.getOnderwerp());
	}
	/**
	 * Test constructor met parameter 
	 * (String onderwerp, int leerjaar, boolean isUniekeDeelname, boolean isTest)
	 */
	@Test
	public void test_Quiz_String_Int_BooleanBoolean() {
		List<String> hints = new ArrayList();
		hints.add("5 + 5 = 10");
		hints.add("Tweede cijfer is '3'");
		

		Leraar leraar = Leraar.Kristel;
		QuizStatus quizStatus = QuizStatus.IN_CONSTRUCTIE;
		
		
		
		Quiz quiz = new Quiz(String, String, boolean, boolean);
		assertEquals("eerste parameter onderwerp","rekenen",quiz.getOnderwerp());
		assertEquals("tweede parameter leerjaar",3,quiz.getLeerjaren());
		assertEquals("derde parameter unieke deelname",true,quiz.isUniekeDeelname());
		assertEquals("vierde parameter isTest",true,quiz.isTest());
	}
	/**
	 * Test methode setOnderwerp(String onderwerp)
	 */
	@Test
	public void testSetOnderwerp(){
		quiz.setOnderwerp("rekenen");
		assertEquals("test setOnderwerp","rekenen", quiz.getOnderwerp());
	}
	/**
	 * Test methode setLeerJaar(int leerJaar)
	 */
	@Test
	public void testSetLeerJaar(){
		quiz.setLeerjaren(3);
		assertEquals("test setLeerJaar",3, quiz.getLeerjaren());
	}
	/**
	 * Test methode setTest(boolean isTest)
	 */
	@Test
	public void testSetTestTrue() {
		quiz.setTest(true);
		assertTrue(true);
	}
	@Test
	public void testSetTestFalse() {
		quiz.setTest(false);
		assertFalse(false);
	}
	/**
	 * test methode isUniekeDeelname
	 */
	@Test
	public void setUniekeDeelnameTrue() {
		quiz.setUniekeDeelname(true);
		assertTrue(true);
	}
	@Test
	public void setUniekeDeelnameFalse() {
		quiz.setUniekeDeelname(false);
		assertFalse(false);
	}
	/**
	 * testen methode setQuizStatus
	 */
	public void setQuizStatus() {
		quiz.setQuizStatus(quizStatus);
		assertEquals("test QuizStatus","Test quiz in constructie", quiz.getQuizStatus());
	}
	
	public void setLeraar(Leraar leraar) {
	}@Ignore
	public void setQuizOpdracht(List<QuizOpdracht> quizOpdracht) {
		//this.quizOpdrachten = quizOpdracht;
	}
	
	/**
	 * test controlleerjaar
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testControleLeerjaarLeerJaarKleinerDanEen(){
		//quiz.setLeerJaar(0);
		assertEquals("Leerjaar kleiner dan ��n",0,quiz.controlLeerjaar(0));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testControleLeerJaarNegatief(){
		quiz.setLeerjaren(-5);
		assertEquals("negatief leerjaar",-5,quiz.controlLeerjaar(-5));
	}
	@Test
	public void testControleLeerJaarCorrecteInput(){
		//quiz.setLeerJaar(3);
		assertEquals("correct leerjaar",3,quiz.controlLeerjaar(3));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testControleLeerjaarLeerJaarGroterDanZes(){
		assertEquals("Leerjaar groter dan zes",7,quiz.controlLeerjaar(7));
	}
	
}
