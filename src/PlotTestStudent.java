/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit test for plot class
 * Due: 10/28/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlotTestStudent {
	private Plot testPlot1, testPlot2, testPlot3,testPlot4;
	
	/**
	 * creating test Plot objects
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		testPlot1 = new Plot(2,2, 5,5); 
		testPlot2 = new Plot(testPlot1); // copy constructor
		testPlot3 = new Plot(); // default constructor
		testPlot4 = new Plot(3,3,4,4);
	}
	
	/**
	 * setting each object instance to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		testPlot1 = null; testPlot2 = null; testPlot3 = null; testPlot4 = null;
	}
	
	/**
	 * testing each constructor works as expected
	 */
	@Test
	public void testConstructor()
	{
		assertEquals(testPlot1.getX(), testPlot2.getX());
		assertEquals(testPlot3.getDepth(), 1);
	}
	
	/**
	 * testing encompasses method
	 */
	@Test
	public void testEncompasses()
	{
		assertTrue(testPlot1.encompasses(testPlot2));
	}
	
	/**
	 * testing overlaps method
	 */
	@Test
	public void testOverlaps()
	{
		assertTrue(testPlot2.overlaps(testPlot4));
	}
	
	/**
	 * testing toString method
	 */
	@Test
	public void testToString() {
		assertEquals("2,2,5,5",testPlot1.toString());	
	}

}
