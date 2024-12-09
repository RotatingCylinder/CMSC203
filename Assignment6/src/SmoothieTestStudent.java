import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

    private Smoothie testSmoothie;

	@BeforeEach
	void setUp() throws Exception 
	{
        testSmoothie = new Smoothie("Banana Smoothie", Size.MEDIUM, 5, true);

	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testSmoothie = null;
	}

	@Test
    void testConstructor() 
	{
        assertEquals("Banana Smoothie", testSmoothie.getBevName());
        assertEquals(Size.MEDIUM, testSmoothie.getSize());
        assertEquals(5, testSmoothie.getNumOfFruit());
        assertTrue(testSmoothie.getAddProtein());
    }

    @Test
    void testSetNumOfFruit() {
        testSmoothie.setNumOfFruit(3);
        assertEquals(3, testSmoothie.getNumOfFruit());
    }

    @Test
    void testSetAddProtein() {
        testSmoothie.setAddProtein(false);
        assertFalse(testSmoothie.getAddProtein());
    }

    @Test
    void testCalcPrice() {
        double expectedPrice = testSmoothie.addSizePrice() +(0.50 * 5) +1.50;
        assertEquals(expectedPrice, testSmoothie.calcPrice());
    }

    @Test
    void testEquals() 
    {
        Smoothie anotherSmoothie = new Smoothie("Banana Smoothie", Size.MEDIUM, 5, true);
        assertTrue(testSmoothie.equals(anotherSmoothie));
    }
}
