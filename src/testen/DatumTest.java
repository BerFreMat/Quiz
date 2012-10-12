package testen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import utils.Datum;

public class DatumTest {

	/**
	 * @param args
	 */
	
	private Date geldigDateObject;

	@Before
	public void setUp() throws Exception {
		//Datum 01/01/2012
		Date geldigDateObject = new Date(112,1,1);
	}

	@Test
	public void test_ConstructorZonderParam_Aanvaard_GeenParameter() {
		Datum geldigeDatum = null;
		geldigeDatum = new Datum();
		assertNotNull(geldigeDatum);
	}	
	
	@Test
	public void test_Constructor1Param_Aanvaard_GeldigDateObject() {
		Datum geldigeDatum = new Datum(geldigDateObject);
		assertEquals("1/1/2012",Datum.getDatumInEuropeesFormaat());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor1Param_Exception_Als_DateObjectIsNull() {
		Date nullDateObject = null ;
		Datum geldigeDatum = new Datum(nullDateObject);
	}	
		
	@Test
	public void test_Constructor3Param_Aanvaard_3GeldigeParameters() {
		Datum geldigeDatum = new Datum(10,12,2010);
		assertEquals("10/12/2010",Datum.getDatumInEuropeesFormaat());
	}	

	@Test
	public void test_Constructor3Param_Aanvaard_KleineGetallen() {
		Datum geldigeDatum = new Datum(1,1,0);
		assertEquals("1/1/0",Datum.getDatumInEuropeesFormaat());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_NegatieveDag() {
		Datum onGeldigeDatum = new Datum(-10,12,2010);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_NegatieveDagMaand() {
		Datum onGeldigeDatum = new Datum(10,-12,2010);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_geenInt() {
		Datum onGeldigeDatum = new Datum(0.1,0.5,2010);
	}	
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_nullArgumenten() {
		Datum onGeldigeDatum = new Datum(null,null,null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_geenInt() {
		Datum onGeldigeDatum = new Datum(0.1,0.5,2010);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_ongeldigeDag() {
		Datum onGeldigeDatum = new Datum(0,10,2010);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Constructor3Param_Exception_Als_ongeldigeMaand() {
		Datum onGeldigeDatum = new Datum(1,40,2010);
	}
	
	@Test
	public void test_ConstructorStringParam_Aanvaard_GeldigeStringMet2CijfersVoorDag() {
		String geldigeStringMet2CijfersVoorDag = "02/10/2007";
		Datum geldigeDatum = new Datum(geldigeStringMet2CijfersVoorDag);
		assertEquals("2/10/2007",Datum.getDatumInEuropeesFormaat());
	}	
	
	@Test
	public void test_ConstructorStringParam_Aanvaard_GeldigeStringMet1CijferVoorDag() {
		String geldigeStringMet1CijferVoorDag = "2/10/2007";
		Datum geldigeDatum = new Datum(geldigeStringMet1CijferVoorDag);
		assertEquals("2/10/2007",Datum.getDatumInEuropeesFormaat());
	}
	
	@Test
	public void test_ConstructorStringParam_Aanvaard_GeldigeStringMetKoppeltekens() {
		String geldigeStringMetKoppeltekens = "02-10-2007";
		Datum geldigeDatum = new Datum(geldigeStringMet1CijferVoorDag);
		assertEquals("2/10/2007",Datum.getDatumInEuropeesFormaat());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_ConstructorStringParam_Exception_Als_letters() {
		String ongeldigeString = "AA/BB/CCCC";
		Datum geldigeDatum = new Datum(ongeldigeString);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_ConstructorStringParam_Exception_Als_VerkeerdeLayoutYYYYMMDD() {
		String ongeldigeString = "2012/10/05";
		Datum geldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_ConstructorStringParam_Exception_Als_null() {
		String ongeldigeString = null;
		Datum geldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_ConstructorStringParam_Exception_Als_null() {
		String ongeldigeString = null;
		Datum geldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_ConstructorStringParam_Exception_Als_ongeldigeDag() {
		String ongeldigeDagString = "40/10/2012";
		Datum geldigeDatum = new Datum(ongeldigeDagString);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_ConstructorStringParam_Exception_Als_ongeldigeMaand() {
		String ongeldigeMaandString = "4/20/2012";
		Datum geldigeDatum = new Datum(ongeldigeMaandString);
	}
	
	
}
