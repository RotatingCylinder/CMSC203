/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit test for Order class
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

class OrderTest {
	
	private Order testOrder;

	@BeforeEach
	void setUp() throws Exception 
	{
		Customer testCustomer = new Customer("Kelvin", 18);
        testOrder = new Order(10, Day.MONDAY, testCustomer);
        testOrder.setOrderNo(12345);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testOrder = null;
	}
	@Test
    void testConstructor() {
        assertEquals(12345, testOrder.getOrderNo());
        assertEquals(10, testOrder.getOrderTime());
        assertEquals(Day.MONDAY, testOrder.getOrderDay());
        assertEquals("Kelvin", testOrder.getCust().getName());
    }
	
	@Test
    void testGenerateOrder() 
	{
        int orderNo = testOrder.generateOrder();
        assertTrue(orderNo >= 10000 && orderNo < 90000);
    }
	
	@Test
    void testCompareTo() {
        Order anotherOrder = new Order(10, Day.MONDAY, new Customer("Jane", 25));
        anotherOrder.setOrderNo(12345);
        assertEquals(0, testOrder.compareTo(anotherOrder));
    }
	
	@Test
    void testIsWeekend() 
	{
        testOrder.setOrderDay(Day.SATURDAY);
        assertTrue(testOrder.isWeekend());
    }
	
	@Test
    void testAddNewBeverage_Coffee() {
        testOrder.addNewBeverage("Latte", Size.MEDIUM, false, false);
        
        testOrder.addNewBeverage("Beer", Size.SMALL);
        
        testOrder.addNewBeverage("Berry Smoothie", Size.LARGE, 5, true);
        assertEquals(3, testOrder.getTotalItems());
    }
	
	@Test
    void testCalcOrderTotal() {
        testOrder.addNewBeverage("Latte", Size.MEDIUM, false, false);
        testOrder.addNewBeverage("Berry Smoothie", Size.LARGE, 5, true);
        double total = testOrder.calcOrderTotal();
        assertTrue(total > 0);
    }

    @Test
    void testFindNumOfBeveType() {
        testOrder.addNewBeverage("Latte", Size.MEDIUM, false, false);
        testOrder.addNewBeverage("Berry Smoothie", Size.LARGE, 5, true);
        assertEquals(1, testOrder.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    void testGetTotalItems() {
        testOrder.addNewBeverage("Latte", Size.MEDIUM, false, false);
        testOrder.addNewBeverage("Beer", Size.SMALL);
        assertEquals(2, testOrder.getTotalItems());
    }

    @Test
    void testToString() {
        testOrder.addNewBeverage("Latte", Size.MEDIUM, false, false);
        String result = testOrder.toString();
        assertTrue(result.contains("Order No.: 12345"));
        assertTrue(result.contains("Latte"));
    }

}
