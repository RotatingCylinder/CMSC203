/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit test for Alcohol class
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	
	// test objects
	private Alcohol testAlcoholWeekday;
    private Alcohol testAlcoholWeekend;

	@BeforeEach
	void setUp() throws Exception {
		
		testAlcoholWeekday = new Alcohol("Beer", Size.MEDIUM, false);
        testAlcoholWeekend = new Alcohol("Wine", Size.LARGE, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		testAlcoholWeekday = testAlcoholWeekend = null;
	}

	/**
	 * checking if equals method works
	 */
	public void testEquals() 
	{
        Alcohol testAlcoholWeekend2 = new Alcohol("Wine", Size.LARGE, true);
        assertTrue(testAlcoholWeekend.equals(testAlcoholWeekend2));
    }
	
	/**
	 * checking if calcPrice works
	 */
	@Test
    public void testCalcPrice() {
        double expectedPrice = testAlcoholWeekend.addSizePrice() + 0.60;
        assertEquals(expectedPrice, testAlcoholWeekend.calcPrice(), 0.01);
        
        double expectedPrice2 = testAlcoholWeekday.addSizePrice();
        assertEquals(expectedPrice2, testAlcoholWeekday.calcPrice(), 0.01);
    }
	
	/**
	 * testing output of toString
	 */
	@Test
    public void testToString() 
	{
        String expected = "Beverage name: Wine Beverage size: LARGE Offered on Weekend: true Price: " + testAlcoholWeekend.calcPrice();
        assertEquals(expected, testAlcoholWeekend.toString());
    }
	
	
}
