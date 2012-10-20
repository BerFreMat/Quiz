package utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Date;


public class DatumTest {

	/**
	 * @param args
	 */
	
	private Datum geldigDatumObject;

	@Before
	public void setUp() throws Exception {
		//Datum 01/01/2012
		geldigDatumObject = new Datum(1,1,2012);
	}

	@Test
	public void test_ConstructorZonderParam_Aanvaard_GeenParameter() throws DagException, MaandException {
		Datum geldigeDatum = null;
		geldigeDatum = new Datum();
		assertNotNull(geldigeDatum);
	}	
	
	@Test
	public void test_Constructor1Param_Aanvaard_GeldigDatumObject() throws DatumException, DagException, MaandException {
		Datum geldigeDatum = new Datum(geldigDatumObject);
		assertEquals("1/1/2012",geldigeDatum.toStringInEuropees());
	}
	
	@Test (expected = DatumException.class)
	public void test_Constructor1Param_Exception_Als_DateObjectIsNull() throws DatumException, DagException, MaandException {
		Datum nullDatumObject = null ;
		Datum testDatum = new Datum(nullDatumObject);
	}	
		
	@Test
	public void test_Constructor3Param_Aanvaard_3GeldigeParameters() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(10,12,2010);
		assertEquals("10/12/2010",geldigeDatum.toStringInEuropees());
	}	

	@Test
	public void test_Constructor3Param_Aanvaard_KleineGetallen() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,1,0);
		assertEquals("1/1/0",geldigeDatum.toStringInEuropees());
	}
	
	@Test (expected = DagException.class)
	public void test_Constructor3Param_Exception_Als_NegatieveDag() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(-10,12,2010);
	}
	
	@Test (expected = MaandException.class)
	public void test_Constructor3Param_Exception_Als_NegatieveDagMaand() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(10,-12,2010);
	}

	@Test (expected = DagException.class)
	public void test_Constructor3Param_Exception_Als_ongeldigeDag() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(0,10,2010);
	}
	
	@Test (expected = MaandException.class)
	public void test_Constructor3Param_Exception_Als_ongeldigeMaand() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(1,40,2010);
	}
	
	@Test
	public void test_ConstructorStringParam_Aanvaard_GeldigeStringMet2CijfersVoorDag() throws DatumStringException, DagException, MaandException {
		String geldigeStringMet2CijfersVoorDag = "02/10/2007";
		Datum geldigeDatum = new Datum(geldigeStringMet2CijfersVoorDag);
		assertEquals("2/10/2007",geldigeDatum.toStringInEuropees());
	}	
	
	@Test
	public void test_ConstructorStringParam_Aanvaard_GeldigeStringMet1CijferVoorDag() throws DatumStringException, DagException, MaandException {
		String geldigeStringMet1CijferVoorDag = "2/10/2007";
		Datum geldigeDatum = new Datum(geldigeStringMet1CijferVoorDag);
		assertEquals("2/10/2007",geldigeDatum.toStringInEuropees());
	}
	
	@Test
	public void test_ConstructorStringParam_Aanvaard_GeldigeStringMetKoppeltekens() throws DatumStringException, DagException, MaandException {
		String geldigeStringMetKoppeltekens = "02-10-2007";
		Datum geldigeDatum = new Datum(geldigeStringMetKoppeltekens);
		assertEquals("2/10/2007",geldigeDatum.toStringInEuropees());
	}
	
	@Test (expected = DatumStringException.class)
	public void test_ConstructorStringParam_Exception_Als_letters() throws DatumStringException, DagException, MaandException {
		String ongeldigeString = "AA/BB/CCCC";
		Datum geldigeDatum = new Datum(ongeldigeString);
	}

	@Test (expected = DatumStringException.class)
	public void test_ConstructorStringParam_Exception_Als_VerkeerdeLayoutYYYYMMDD() throws DatumStringException, DagException, MaandException {
		String ongeldigeString = "2012/10/05";
		Datum geldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = DatumStringException.class)
	public void test_ConstructorStringParam_Exception_Als_null() throws DatumStringException, DagException, MaandException {
		String ongeldigeString = null;
		Datum geldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = DagException.class)
	public void test_ConstructorStringParam_Exception_Als_ongeldigeDag() throws DatumStringException, DagException, MaandException {
		String ongeldigeDagString = "40/10/2012";
		Datum geldigeDatum = new Datum(ongeldigeDagString);
	}
	
	@Test (expected = MaandException.class)
	public void test_ConstructorStringParam_Exception_Als_ongeldigeMaand() throws DatumStringException, DagException, MaandException {
		String ongeldigeMaandString = "4/20/2012";
		Datum geldigeDatum = new Datum(ongeldigeMaandString);
	}
	
	
}
