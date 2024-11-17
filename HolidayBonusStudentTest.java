/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit testing for HolidayBonus class
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


public class HolidayBonusStudentTest {
	
	private double [][] testData = {{1,2,-3},{2,2,0},{4,4,4}};
	private double [] testBonus = HolidayBonus.calculateHolidayBonus(testData);
	private double total = testBonus[0] + testBonus[1] + testBonus[2];

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCalculateHolidayBonus()
	{		
		assertEquals(testBonus[0], 2000.0,.001);
		assertEquals(testBonus[2], 15000.0,0.001);
	}
	
	@Test
	public void TestCalculateTotalHolidayBonus()
	{
		assertEquals(HolidayBonus.calculateTotalHolidayBonus(testData), total,.001);
	}

}
