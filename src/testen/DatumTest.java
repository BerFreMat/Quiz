package testen;
import static org.junit.Assert.*;

import model.Tijd;

import org.junit.Before;
import org.junit.Test;


public class DatumTest {

	/**
	 * @param args
	 */
	
	@Before
	public void setUp() throws Exception {
	}
		
	@Test
	public void test_ConstructorZonderParameters_Aanvaard_GeldigeWaarde() {
		Datum datum = new Date();
		assertEquals(10,tijd.getUur());
		assertEquals(20,tijd.getMinuut());
		assertEquals(30,tijd.getSeconde());
	}

	@Test
	public void testTijdIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerhoogTijd() {
		fail("Not yet implemented");
	}
	

}
