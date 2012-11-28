package utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.DagException;
import exceptions.DagTeGrootDoorSchrikkeljaarException;
import exceptions.DatumException;
import exceptions.DatumStringException;
import exceptions.MaandException;

import utils.Datum;

public class DatumTest {
	

	private Datum geldigDatumObject20120101;
	private Datum geldigDatumObject20120229;
	private Datum geldigDatumObject20121231;

	@Before
	public void setUp() throws Exception {
		//Datum 01/01/2012
		geldigDatumObject20120101 = new Datum(1,1,2012);
		geldigDatumObject20120229 = new Datum(29,2,2012);
		geldigDatumObject20121231 = new Datum(31,12,2012);
	}
	
	@Test
	public void test_ConstructorZonderParam_Geen_parameter_Wordt_aanvaard() throws DagException, MaandException  {
		Datum geldigeDatum = null;
		geldigeDatum = new Datum();
		assertNotNull(geldigeDatum);
	}
	
	@Test
	public void test_ConstructorZonderParam_Zonder_parameter_Geeft_geldige_dagwaarde_voor_datum() throws DagException, MaandException  {
		Datum geldigeDatum = new Datum();
		if(geldigeDatum.getDag()<1 || geldigeDatum.getDag()>31)
		{
			fail("Dag moet tussen 1 en 31 vallen"+ geldigeDatum.getDag());
		}
	}	

	@Test
	public void test_ConstructorZonderParam_Zonder_parameter_Geeft_geldige_maandwaarde_voor_datum() throws DagException, MaandException{
		Datum geldigeDatum = new Datum();
		if(geldigeDatum.getMaand()<1 || geldigeDatum.getMaand()>12)
		{
			fail("Maand moet tussen 1 en 12 vallen "+ geldigeDatum.getMaand());
		}
	}	
	
	@Test
	public void test_ConstructorZonderParam_Zonder_parameter_Geeft_geldige_Jaarwaarde_voor_datum() throws DagException, MaandException{
		Datum geldigeDatum = new Datum();
		if(geldigeDatum.getJaar()<2011 || geldigeDatum.getJaar()>2200)
		{
			fail("Jaar heeft geen realistische waarde "+ geldigeDatum.getJaar());
		}
	}
	
	@Test
	public void test_Constructor3Param_Aanvaard_3GeldigeParameters() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(10,12,2010);
		assertEquals(10,geldigeDatum.getDag());
		assertEquals(12,geldigeDatum.getMaand());
		assertEquals(2010,geldigeDatum.getJaar());

	}	

	@Test
	public void test_Constructor3Param_Kleine_getallen_Worden_aanvaard() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,1,0);
		assertEquals(1,geldigeDatum.getDag());
		assertEquals(1,geldigeDatum.getMaand());
		assertEquals(0,geldigeDatum.getJaar());
	}
	
	@Test
	public void test_Constructor3Param_Schrikkeldag_Wordt_aanvaard() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(29,2,2012);
		assertEquals(29,geldigeDatum.getDag());
		assertEquals(2,geldigeDatum.getMaand());
		assertEquals(2012,geldigeDatum.getJaar());
	}

	@Test (expected = DagTeGrootDoorSchrikkeljaarException.class)
	public void test_Constructor3Param_Exception_Als_Valse_schrikkeldag() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(29,2,2013);
	}
	
	@Test (expected = Exception.class)
	public void test_Constructor3Param_Exception_Als_NegatieveDag() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(-10,12,2010);
	}
	
	@Test (expected = Exception.class)
	public void test_Constructor3Param_Exception_Als_NegatieveDagMaand() throws DagException, MaandException{
		Datum onGeldigeDatum = new Datum(10,-12,2010);
	}

	@Test (expected = Exception.class)
	public void test_Constructor3Param_Exception_Als_ongeldigeDag() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(0,10,2010);
	}
	
	@Test (expected = Exception.class)
	public void test_Constructor3Param_Exception_Als_ongeldigeMaand() throws DagException, MaandException {
		Datum onGeldigeDatum = new Datum(1,40,2010);
	}
	
	@Test
	public void test_Constructor1Param_Geldig_datum_object_Wordt_aanvaard() throws DatumException, DagException, MaandException {
		Datum geldigeDatum = new Datum(geldigDatumObject20120101);
		assertEquals(1,geldigeDatum.getDag());
		assertEquals(1,geldigeDatum.getMaand());
		assertEquals(2012,geldigeDatum.getJaar());
	}
	
	@Test (expected = DatumException.class)
	public void test_Constructor1Param_Exception_Als_DateObjectIsNull() throws DatumException, DagException, MaandException {
		Datum nullDatumObject = null ;
		Datum testDatum = new Datum(nullDatumObject);
	}	
	
	@Test
	public void test_ConstructorStringParam_Geldige_string_met_2_cijfers_voor_dag_Wordt_aanvaard() throws DatumStringException, DagException, MaandException  {
		String geldigeStringMet2CijfersVoorDag = "02/10/2007";
		Datum geldigeDatum = new Datum(geldigeStringMet2CijfersVoorDag);
		assertEquals(2,geldigeDatum.getDag());
		assertEquals(10,geldigeDatum.getMaand());
		assertEquals(2007,geldigeDatum.getJaar());
	}	
	
	@Test
	public void test_ConstructorStringParam_Geldige_string_met_1_cijfer_voor_dag_Wordt_aanvaard() throws DatumStringException, DagException, MaandException{
		String geldigeStringMet1CijferVoorDag = "2/10/2007";
		Datum geldigeDatum = new Datum(geldigeStringMet1CijferVoorDag);
		assertEquals(2,geldigeDatum.getDag());
		assertEquals(10,geldigeDatum.getMaand());
		assertEquals(2007,geldigeDatum.getJaar());
	}
	
	@Test
	public void test_ConstructorStringParam_Geldige_string_met_koppeltekens_Wordt_aanvaard() throws DatumStringException, DagException, MaandException{
		String geldigeStringMetKoppeltekens = "02-10-2007";
		Datum geldigeDatum = new Datum(geldigeStringMetKoppeltekens);
		assertEquals(2,geldigeDatum.getDag());
		assertEquals(10,geldigeDatum.getMaand());
		assertEquals(2007,geldigeDatum.getJaar());
	}
	
	@Test (expected = DatumStringException.class)
	public void test_ConstructorStringParam_Exception_Als_letters() throws DatumStringException, DagException, MaandException {
		String ongeldigeString = "AA/BB/CCCC";
		Datum onGeldigeDatum = new Datum(ongeldigeString);
	}

	@Test (expected = DatumStringException.class)
	public void test_ConstructorStringParam_Exception_Als_VerkeerdeLayoutYYYYMMDD() throws DatumStringException, DagException, MaandException{
		String ongeldigeString = "2012/10/05";
		Datum onGeldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = DatumStringException.class)
	public void test_ConstructorStringParam_Exception_Als_null() throws DatumStringException, DagException, MaandException{
		String ongeldigeString = null;
		Datum onGeldigeDatum = new Datum(ongeldigeString);
	}
	
	@Test (expected = DagException.class)
	public void test_ConstructorStringParam_Exception_Als_ongeldigeDag() throws DatumStringException, DagException, MaandException{
		String ongeldigeDagString = "40/10/2012";
		Datum onGeldigeDatum = new Datum(ongeldigeDagString);
	}
	
	@Test (expected = MaandException.class)
	public void test_ConstructorStringParam_Exception_Als_ongeldigeMaand() throws DatumStringException, DagException, MaandException {
		String ongeldigeMaandString = "4/20/2012";
		Datum onGeldigeDatum = new Datum(ongeldigeMaandString);
	}
	

	@Test
	public void test_GetDag_Geldige_datum_Geeft_geen_exception() {
		assertEquals(31,geldigDatumObject20121231.getDag());
	}

	@Test
	public void test_GetMaand_Geldige_datum_Geeft_geen_exception() {
		assertEquals(12,geldigDatumObject20121231.getMaand());
	}

	@Test
	public void test_GetJaar_Geldige_datum_Geeft_geen_exception() {
		assertEquals(2012,geldigDatumObject20121231.getJaar());
	}
	
	@Test
	public void test_ToString_Geldige_Datum_Wordt_correct_geformateerd() {
		assertEquals("1 januari 2012",geldigDatumObject20120101.toString());
		assertEquals("31 december 2012",geldigDatumObject20121231.toString());
	}

	@Test	
	public void test_ToString_Datum_in_januari_Wordt_correct_geformateerd() throws DagException, MaandException  {
		Datum geldigeDatum = new Datum(1,1,2012);
		assertEquals("1 januari 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_februari_Wordt_correct_geformateerd() throws DagException, MaandException{
		Datum geldigeDatum = new Datum(1,2,2012);
		assertEquals("1 februari 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_maart_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum maandmaart = new Datum(1,3,2012);
		assertEquals("1 maart 2012",maandmaart.toString());
	}
	@Test	
	public void test_ToString_Datum_in_april_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,4,2012);
		assertEquals("1 april 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_mei_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,5,2012);
		assertEquals("1 mei 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_juni_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,6,2012);
		assertEquals("1 juni 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_juli_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,7,2012);
		assertEquals("1 juli 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_augustus_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,8,2012);
		assertEquals("1 augustus 2012",geldigeDatum.toString());
	}	
	@Test	
	public void test_ToString_Datum_in_september_Wordt_correct_geformateerd() throws DagException, MaandException{
		Datum geldigeDatum = new Datum(1,9,2012);
		assertEquals("1 september 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_oktober_Wordt_correct_geformateerd() throws DagException, MaandException {
		Datum geldigeDatum = new Datum(1,10,2012);
		assertEquals("1 oktober 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_november_Wordt_correct_geformateerd() throws DagException, MaandException{
		Datum geldigeDatum = new Datum(1,11,2012);
		assertEquals("1 november 2012",geldigeDatum.toString());
	}
	@Test	
	public void test_ToString_Datum_in_december_Wordt_correct_geformateerd() throws DagException, MaandException{
		Datum geldigeDatum = new Datum(1,12,2012);
		assertEquals("1 december 2012",geldigeDatum.toString());
	}
	@Test
	public void test_ToStringAmerikaans_Geldige_Datum_Wordt_correct_geformateerd() {
		assertEquals("2012/1/1",geldigDatumObject20120101.toStringAmerikaans());
		assertEquals("2012/12/31",geldigDatumObject20121231.toStringAmerikaans());
	}

	@Test
	public void test_ToStringInEuropees_Geldige_Datum_Wordt_correct_geformateerd() {
		assertEquals("1/1/2012",geldigDatumObject20120101.toStringInEuropees());
		assertEquals("31/12/2012",geldigDatumObject20121231.toStringInEuropees());
	}

	@Test
	public void test_EqualsDatum_2_dezelfde_datums_evalueren_true() throws DagException, MaandException, DatumException  {
		Datum datum1 = new Datum(1,1,2012);
		Datum datum2 = new Datum(1,1,2012);
		assertTrue(datum1.equals(datum2));
	}
	
	@Test
	public void test_EqualsDatum_2_verschillende_datums_evalueren_false() throws DatumException {
		assertFalse(geldigDatumObject20120101.equals(geldigDatumObject20120229));
	}
	
	@Test (expected = DatumException.class)
	public void test_EqualsDatum_Exception_als_null() throws DatumException {
		Datum datum2 = null;
		assertTrue(geldigDatumObject20120101.equals(datum2));
	}

	@Test
	// Als datum 1 (this) NA datum 2 (datum) komt ==> 1
	// Als datum 1 (this) VOOR datum 2 (datum) komt ==> -1
	// Indien gelijk ==> 0
	public void test_CompareTo_Datum_later_dan_meegegeven_datum_Geeft_positief_getal() throws DatumException {
		if(geldigDatumObject20120229.compareTo(geldigDatumObject20120101) <= 0)
		{fail("Datum 1 later dan Datum 2 moet een positief getal geven");}
	}
	@Test
	public void test_CompareTo_Datum_vroeger_dan_meegegeven_datum_Geeft_negatief_getal() throws DatumException{
		if(geldigDatumObject20120101.compareTo(geldigDatumObject20120229) >= 0)
		{fail("Datum 1 vroeger dan Datum 2 moet een negatief getal geven");}
	}

	@Test
	public void test_CompareTo_Datum_gelijk_aan_meegegeven_datum_Geeft_nul() throws DatumException, DagException, MaandException{
		Datum datum2 = new Datum(1,1,2012);
		if(geldigDatumObject20120101.compareTo(datum2) != 0)
		{fail("Datum 1 gelijk aan Datum 2 moet nul geven");}
	}
	@Test (expected = DatumException.class)
	public void test_CompareTo_Exception_als_null() throws DatumException {
		Datum datum2 = null;
		geldigDatumObject20120101.compareTo(datum2);
	}
	
	@Test
	public void test_IsKleinerDan_Gegeven_datum_is_kleiner_dan_huidige_datum_Geeft_True() throws DatumException{
		assertTrue(geldigDatumObject20120229.isKleinerDan(geldigDatumObject20120101));
	}
	
	@Test
	public void test_IsKleinerDan_Gegeven_datum_is_groter_dan_huidige_datum_Geeft_False() throws DatumException {
		assertFalse(geldigDatumObject20120101.isKleinerDan(geldigDatumObject20120229));
	}
	
	@Test (expected = DatumException.class)
	public void test_IsKleinerDan_Exception_als_null() throws  DatumException {
		Datum datum2 = null;
		geldigDatumObject20120101.isKleinerDan(datum2);
	}
	
	@Test
	public void test_IsSchrikkeljaar_Schrikkeljaar_Geeft_true() {
		assertTrue (geldigDatumObject20121231.isSchrikkeljaar());
	}
	
	@Test
	public void test_IsSchrikkeljaar_Jaar_2000_Geeft_true() throws DagException, MaandException {
		Datum jaar2000 = new Datum(1,1,2000);
		assertTrue (jaar2000.isSchrikkeljaar());
	}
	
	@Test
	public void test_IsSchrikkeljaar_Jaar_2100_Geeft_false() throws DagException, MaandException {
		Datum jaar2100 = new Datum(1,1,2100);
		assertFalse (jaar2100.isSchrikkeljaar());	}
	
}
