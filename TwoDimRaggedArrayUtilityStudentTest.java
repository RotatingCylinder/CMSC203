/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit testing for TwoDimRaggedArrayUtility
 * Due: 11/18/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TwoDimRaggedArrayUtilityStudentTest {
	
	private double [][] testData1 = {{5,5,3},{1,2,3,4,5,6},{8,7,8}, {-2,3,-1}};
	private double [][] testData2 = {{4.2,3.1,2.2,7.4},{2.2,1.5}, {2.9,5.7,8.2,9.0}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetTotal()
	{
		  assertEquals(TwoDimRaggedArrayUtility.getTotal(testData1), 57.0, .001);
		
	}
	
	@Test
	public void testGetHighestInArray()
	{
		assertEquals(TwoDimRaggedArrayUtility.getHighestInArray(testData1), 8.0,.001);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInArray(testData2), 9.0, .001);
	}
	
	@Test
	public void testGetLowestInRowIndex()
	{
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(testData1, 3),0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(testData2, 1),1);
	}
	
	@Test
	public void testGetHighestInColumn()
	{
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(testData1, 0), 8.0,.001);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(testData2, 0),4.2,.001);
	}

}
