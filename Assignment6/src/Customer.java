/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Class to hold customer information when managing orders
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


public class Customer {
	
	private int age; private String name;
	
	/**
	 * constructor
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age)
	{
		this.age = age; this.name = name;
	}
	
	/**
	 * copy constructor
	 * @param customer
	 */
	public Customer(Customer customer)
	{
		this.age = customer.age;
		this.name = customer.name;
	}
	
	/**
	 * overriden toString method
	 */
	@Override
	public String toString()
	{
		return ("Customer name: " + name + " Customer age: " + age);
	}

	// getters and setters
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
