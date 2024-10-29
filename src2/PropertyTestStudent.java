/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit test for Property class
 * Due: 10/28/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PropertyTestStudent {
	
	private Property testProperty1,testProperty2,testProperty3,testProperty4;
	
	/**
	 * creating test Property objects
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception
	{
		testProperty1 = new Property(); // default constructor
		testProperty2 = new Property("Sample Property1", "Rockville", 2500.00, "Kelvin Hernandez Salas");
		testProperty3 = new Property("Sample Property2", "Rockville", 1300.00, "Jane Doe", 2,2,3,3);
		testProperty4 = new Property(testProperty3);
	}
	
	/**
	 * setting each object instance to null
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception
	{
		testProperty1 = null;testProperty2 = null;testProperty3 = null;testProperty4 = null;
	}
	
	/**
	 * checking each constructor
	 */
	@Test
	public void testConstructors()
	{
		assertEquals(testProperty1.getCity(), "");
		assertEquals(testProperty1.getPlot().getWidth(),1);
		
		assertEquals(testProperty3.getPropertyName(),testProperty4.getPropertyName());
		assertEquals(testProperty3.getPlot().getWidth(),testProperty4.getPlot().getWidth());
		
		assertEquals(testProperty2.getCity(), "Rockville");
		
	}
	
	/**
	 * testing toString method
	 */
	@Test
	public void testToString()
	{
		assertEquals("Sample Property2,Rockville,Jane Doe,1300.0",testProperty4.toString());	
	}
	
	/**
	 * testing setRent method
	 */
	@Test
	public void testSetRent()
	{
		testProperty2.setRent(1200.00);
		assertEquals(testProperty2.getRentAmount(),1200.00);
	}

}
