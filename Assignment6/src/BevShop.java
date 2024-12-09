/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Class for Alcoholic beverages, inherits from Beverage class
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface {

	private int numOfAlcoholDrink;
	
	// arraylist for tracking all orders
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	
	/**
	 * checks if time is within min and max time
	 */
	@Override
	public boolean isValidTime(int time) {
		
		if(time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		
		return false;
	}

	/**
	 * returns max fruits
	 */
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	/**
	 * returns mimimum drinking age
	 */
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * checks if numOfFruits has reached maximum
	 */
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		
		if(numOfFruits == MAX_FRUIT)
		{
			return true;
		}
		
		return false;
	}

	/**
	 * returns max amount of alcoholic drinks that can be ordered
	 */
	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * returns true if numOfAlcoholDrink hasn't reached limit
	 */
	@Override
	public boolean isEligibleForMore() {
		
		if (numOfAlcoholDrink < MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		
		return false;
	}

	
	/**
	 * returns number of alcoholic drinks ordered for this order
	 */
	@Override
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}

	/**
	 * sets numOfAlcoholDrink to parameter
	 * @param numOfAlcoholDrink
	 */
	public void setNumOfAlcoholDrink(int numOfAlcoholDrink) {
		this.numOfAlcoholDrink = numOfAlcoholDrink;
	}
	
	/**
	 * returns true if age is greater than minimum drinking age
	 */
	@Override
	public boolean isValidAge(int age) {
		
		if(age >= MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		
		return false;
	}

	/**
	 * creates a new order using parameters and adds it to the arrayList
	 */
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		
		Customer cust = new Customer(customerName,customerAge);
		
		Order newOrder = new Order(time, day, cust);
		
		newOrder.setOrderNo(newOrder.generateOrder());
		
		orders.add(newOrder);
		
	}

	/**
	 * adds a coffee object to bevList using parameters
	 */
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
		
		orders.get(orders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	/**
	 * adds a alcohol object to bevList
	 */
	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size);		
	}

	/**
	 * adds a smoothie object to bevList
	 */
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);		
	}

	/**
	 * returns orders index of Order object with matching orderNo
	 */
	@Override
	public int findOrder(int orderNo) {
		
		
		for(Order order: orders)
		{
			if(order.getOrderNo() == orderNo)
			{
				 return orders.indexOf(order);
			}
		}
		
		
		return -1;
	}

	/**
	 * returns the price of the order with the matching orderNo
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		
		for(Order order: orders)
		{
			if(order.getOrderNo() == orderNo)
			{
				return order.calcOrderTotal();
			}
		}
		
		return -1;
	}

	/**
	 * returns the sum of the prices of every order 
	 */
	@Override
	public double totalMonthlySale() {
		
		double total = 0;
		
		for(Order order: orders)
		{
			total += order.calcOrderTotal();
		}
				
		return total;
	}

	/**
	 * returns the number of orders 
	 */
	@Override
	public int totalNumOfMonthlyOrders() {
		
		
		int totalOrders = 0;
		
		for(Order order: orders)
		{
			totalOrders++;
		}
				
		return totalOrders;
		
	}

	/**
	 * returns the most recent order added to orders
	 */
	@Override
	public Order getCurrentOrder() {
		
		if (orders.get(orders.size()-1) != null)
		{
			return orders.get(orders.size()-1);
		}
		
		return null;
	}

	/**
	 * returns shallow copy of the order object at index of orders array
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		
		if(orders.get(index) != null)
		{
			return orders.get(index);
		}
		
		return null;
	}

	/**
	 * sorts all orders by orderNo using a selection sort
	 */
	@Override
	public void sortOrders() {
		
		
		int minIndex, minVal;
		
		for(int i = 0; i < orders.size() - 1; i++)
		{
			minIndex = i; 
			minVal = orders.get(minIndex).getOrderNo();
			
			for (int q = i+1; q < orders.size(); q++)
			{
				if(orders.get(q).getOrderNo() < minVal)
				{
					minIndex = q;
				}
			}
			
			orders.set(minIndex, orders.get(i));
			orders.set(i, orders.get(minIndex));
			
		}
		
	}
	
	
	/**
	 * overriden toString method
	 */
	@Override 
	public String toString()
	{
		String fullOrder = "";
		
		for(Order order: orders)
		{
			fullOrder += order.toString() + "\n";
		}
		
		fullOrder+= "Total: " + totalMonthlySale();
		
		return fullOrder;
	}
	

}
