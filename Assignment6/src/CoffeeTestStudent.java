/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit tests for Coffee class
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

class CoffeeTestStudent {

	private Coffee testCoffee;
	@BeforeEach
	void setUp() throws Exception 
	{
		
        testCoffee = new Coffee("Latte", Size.MEDIUM, false, false);

	}


	@AfterEach
	void tearDown() throws Exception 
	{
		testCoffee = null;
	}

	@Test
    public void testEquals() 
	{
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, false, false);
        assertTrue(testCoffee.equals(coffee));
	}
	
	@Test
    public void testCalcPrice() {
        testCoffee.setExtraShot(true);
        testCoffee.setExtraSyrup(true);
        double expectedPrice = testCoffee.addSizePrice() + 0.50 + 0.50;
        assertEquals(expectedPrice, testCoffee.calcPrice(), 0.01);
    }
	
	@Test
    public void testToString() {
        String expected = "Coffee name: Latte Coffee size: MEDIUM Extra coffee: false Extra syrup: false";
        assertEquals(expected, testCoffee.toString());
    }
	
	@Test
    public void testGetExtraShot() {
        assertFalse(testCoffee.getExtraShot());
    }

    @Test
    public void testGetExtraSyrup() {
        assertFalse(testCoffee.getExtraSyrup());
    }
    
    @Test
    public void testSetExtraShot() {
        testCoffee.setExtraShot(true);
        assertTrue(testCoffee.getExtraShot());
    }

    @Test
    public void testSetExtraSyrup() {
        testCoffee.setExtraSyrup(true);
        assertTrue(testCoffee.getExtraSyrup());
    }

}
