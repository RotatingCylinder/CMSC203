/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit test for ManagementCompany class
 * Due: 10/28/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/ 

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestStudent {

	private ManagementCompany testCompany1, testCompany2, testCompany3,testCompany4;
	private Property testProperty1,testProperty2;
	
	/**
	 * creating ManagementCompany and Property test objects
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		testCompany1 = new ManagementCompany("testCo1", "12345",7);
		testCompany2 = new ManagementCompany();
		testCompany3 = new ManagementCompany("testCo2", "54321", 8,2,2,3,3);
		testCompany4 = new ManagementCompany(testCompany3);
		
		testProperty1 = new Property ("property1", "Silver Spring", 1888, "John Doe",2,5,2,2);	
		testProperty2 = new Property("property2", "Baltimore", 1200, "Jane Doe", 3,3,5,5);
	}
	
	/**
	 * setting each object instance to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		testCompany1 = null; testCompany2 = null; testCompany3 = null; testCompany4 = null;
		testProperty1 = null; testProperty2 = null;
	}
	
	/**
	 * testing constructos
	 */
	@Test
	public void testConstructors()
	{
		assertEquals(testCompany2.getName(), "");
		assertEquals(testCompany2.getPlot().getDepth(),10);
		
		assertEquals(testCompany3.getName(),testCompany4.getName());
		
		assertEquals(testCompany1.getMgmFee(),7);
	}
	
	/**
	 * testing getTotalRent function
	 */
	@Test
	public void testGetTotalRent()
	{
		testCompany2.addProperty(testProperty1); 
		
		assertEquals(testCompany2.getTotalRent(), 1888);
	}
	
	/**
	 * testing getPropertiesCount function 
	 */
	@Test
	public void testGetPropertiesCount() {
		testCompany2.addProperty(testProperty1); 
		assertEquals(testCompany2.getPropertiesCount(), 1);
	}

	/**
	 * testing toString function
	 */
	@Test
	public void testToString() {
		testCompany2.addProperty(testProperty1);
		testCompany2.setMgmFee(5); testCompany2.setName("Black Rock"); testCompany2.setTaxID("12345");
		String expectedString = "List of the properties for Black Rock, taxID: 12345\n"
				+ "______________________________________________________\n"
				+ "property1,Silver Spring,John Doe,1888.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 94.4";
		
		assertEquals(expectedString, testCompany2.toString());
				
	}
}
