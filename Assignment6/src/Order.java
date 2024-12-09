/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Class that manages information of beverage orders
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable{
	
	private int orderNo; private int orderTime; private Day orderDay; private Customer cust;
	// arrayList of beverages, tracks every beverage in this order
	private ArrayList<Beverage> bevList = new ArrayList<Beverage>();
	
	
	/**
	 * constructor
	 * @param orderTime
	 * @param orderDay
	 * @param cust
	 */
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime; this.orderDay = orderDay; this.cust = new Customer(cust);
		
	}
	 
	/**
	 * random number generator used to create orderNo
	 * @return
	 */
	public int generateOrder()
	{
		Random random = new Random();
		return random.nextInt(10000,90000);
	}
	
	/**
	 * overriden compareTo method
	 */
	@Override
	public int compareTo(Object o) {
		
		// typecasting o to Order class to compare fields
		Order order = (Order) o;
		
		if(this.orderNo > order.orderNo)
		{
			return 1;
		}
		else if (this.orderNo < order.orderNo)
		{
			return -1;
		}
		
		
		return 0;
	}
	/**
	 * returns true if orderDay equals SATURDAY or SUNDAY enums
	 */
	@Override
	public boolean isWeekend() {
		
		if (this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * returns beverage in bevList with the corresponding itemNo
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
		
		return bevList.get(itemNo);
		 
	}
	
	/**
	 * adds a new coffee object to bevList
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		Coffee coffee = new Coffee(bevName, size, extraShot,extraSyrup);
		
		bevList.add(coffee);
		
	}
	
	/**
	 * adds a new alcoholic beverage to bevList
	 */
	@Override
	public void addNewBeverage(String bevName, Size size) {
		
		Alcohol alcohol = new Alcohol(bevName,size, isWeekend());
		
		bevList.add(alcohol);		
	}
	
	/**
	 * adds a new smoothie object to bevList
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		Smoothie smoothie = new Smoothie(bevName,size,numOfFruits,addProtein);
		
		bevList.add(smoothie);		
	}
	
	/**
	 * returns sum of cost of each item in bevList
	 */
	@Override
	public double calcOrderTotal() {
		
		double total = 0;
		
		for(Beverage beverage : bevList)
		{
			total += beverage.calcPrice();
		}
		
		return total;
	}
	
	/**
	 * returns the number of objects in bevlist of the same type as the parameter
	 */
	@Override
	public int findNumOfBeveType(Type type) {
		
		int numOfType = 0;
		
		for(Beverage beverage : bevList)
		{
			if(beverage.getType() == type)
			{
				numOfType++;
			}
		}
		
		return numOfType;
	}
	
	/**
	 * sums the amount of items in bevList
	 * @return
	 */
	public int getTotalItems() {
		
		int items = 0;
		
		for(Beverage beverage : bevList)
		{
			
				items++;
			
		}
		
		return items;
	}

	// getters and setters
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCust() {
		
		Customer custCopy = new Customer(this.cust);
		
		return custCopy;
	}

	public void setCust(Customer cust) {
		this.cust = new Customer(cust);
	}
	
	/**
	 * overriden toString method
	 */
	@Override
	public String toString()
	{
		
		String order = "Order No.: " + orderNo + " Order time: " + orderTime + " Order day: " + orderDay
				+ "\n" +  cust.toString();
		
		for (Beverage beverage : bevList)
		{
			order += ("\n" + beverage.toString());
		}
		
		return order;
		
	}
	
}
