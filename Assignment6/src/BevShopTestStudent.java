/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit test for BevShop
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

class BevShopTestStudent {

	BevShop bevShop;
	
	@BeforeEach
	void setUp() throws Exception {
		
		bevShop = new BevShop();
        bevShop.setNumOfAlcoholDrink(0);
	}

	@AfterEach
	void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(5));
    }


    @Test
    void testGetMaxOrderForAlcohol() {
        assertEquals(3, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    void testIsEligibleForMore() {
        bevShop.setNumOfAlcoholDrink(3);

        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    void testGetNumOfAlcoholDrink() {
        bevShop.setNumOfAlcoholDrink(2);
        assertEquals(2, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    void testIsValidAge() {
        assertTrue(bevShop.isValidAge(22));
    }

    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    void testProcessCoffeeOrder() {
        bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    void testProcessAlcoholOrder() {
        bevShop.startNewOrder(12, Day.TUESDAY, "Chris", 22);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    void testProcessSmoothieOrder() {
        bevShop.startNewOrder(17, Day.WEDNESDAY, "Jane", 19);
        bevShop.processSmoothieOrder("Berry Smoothie", Size.LARGE, 5, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(15, Day.SATURDAY, "Kelvin", 28);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertEquals(0, bevShop.findOrder(orderNo));
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.FRIDAY, "Claudia", 22);
        bevShop.processCoffeeOrder("Espresso", Size.MEDIUM, false, false);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertTrue(bevShop.totalOrderPrice(orderNo) > 0);
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.THURSDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
        bevShop.startNewOrder(11, Day.MONDAY, "Jane", 30);
        bevShop.processSmoothieOrder("Berry Smoothie", Size.LARGE, 5, true);
        assertTrue(bevShop.totalMonthlySale() > 0);
    }

    @Test
    void testTotalNumOfMonthlyOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.startNewOrder(11, Day.MONDAY, "Jane", 30);
        assertEquals(2, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    void testGetCurrentOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    void testGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getOrderAtIndex(0));
    }

   
   
}
