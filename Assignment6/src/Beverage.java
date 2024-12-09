/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Abstract class for all beverages 
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/



public abstract class Beverage {
	
	// fields
	private final double BASE_PRICE = 2.00;
	private final double SIZE_PRICE = 0.50;
	
	private String bevName; 
	Type type;
	Size size;
	
	/**
	 * constructor
	 * @param bevName
	 * @param type
	 * @param size
	 */
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName; this.type = type; this.size = size;
	}
	
	/**
	 * overriden equals method
	 */
	@Override
    public boolean equals(Object obj) 
    { 
		
		// checking if the two objects have the same memory address
		if(this == obj)
		{
			return true;
		}
		
		// checking if obj is null or a Beverage object
		if(this.getClass() != obj.getClass() || obj == null)
		{
			return false;
		}
		
		// typecasting obj to Beverage class to compare individual elements
		Beverage beverage = (Beverage) obj;
		
		if (this.bevName == beverage.bevName && this.type == beverage.type && this.size == beverage.size)
		{
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * checks size of of beverage and adds to price accordingly
	 * @return
	 */
	public double addSizePrice()
	{
		double price = BASE_PRICE;
		
		// since size small has no price increase, it's not checked
		
		if(size == Size.MEDIUM)
		{
			price += SIZE_PRICE;
		}
		else if (size == Size.LARGE)
		{
			price += SIZE_PRICE + SIZE_PRICE;
		}
		
		return price;
	}
	
	/**
	 * overriden toString method
	 */
	@Override
	public String toString()
	{
		return ("Beverage bevName: " + bevName + " Beverage size: " + size);
	}
	
	public abstract double calcPrice();
	
	
	// Setters and Getters
	
	public void setbevName(String bevName)
	{
		this.bevName = bevName;
	}
	
	public void setType(Type type)
	{
		this.type = type;
	}
	
	public void setSize(Size size)
	{
		this.size = size;
	}
	
	public String getBevName()
	{
		return bevName;
	}
	
	public Type getType()
	{
		return type;
	}
	
	public Size getSize()
	{
		return size;
	}
	
	public double getBasePrice()
	{
		return BASE_PRICE;
	}
	
	public double getSizePrice()
	{
		return SIZE_PRICE;
	}
	
}
