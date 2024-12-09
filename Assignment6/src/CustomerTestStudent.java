/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: JUnit tests for Customer Class
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

class CustomerTestStudent {

	private Customer testCust;
	@BeforeEach
	void setUp() throws Exception 
	{
		testCust = new Customer("Kelvin", 18);	
	}

	@AfterEach
	void tearDown() throws Exception {
		testCust = null;
	}

	@Test
    void testConstructor() {
        assertEquals("Kelvin", testCust.getName());
        assertEquals(18, testCust.getAge());
    }
	
	 @Test
	 void testCopyConstructor() 
	 {
	       Customer copiedCustomer = new Customer(testCust);
	       assertEquals("Kelvin", copiedCustomer.getName());
	       assertEquals(18, copiedCustomer.getAge());
	 }
	 
	 @Test
	 void testSetName() {
	       testCust.setName("Jane");
	        assertEquals("Jane", testCust.getName());
	    }

	    @Test
	    void testSetAge() {
	        testCust.setAge(30);
	        assertEquals(30, testCust.getAge());
	    }

	    @Test
	    void testToString() {
	        assertEquals("Customer name: Kelvin Customer age: 18", testCust.toString());
	    }

	    @Test
	    void testGetName() {
	        assertEquals("Kelvin", testCust.getName());
	    }

	    @Test
	    void testGetAge() {
	        assertEquals(18, testCust.getAge());
	    }

}
