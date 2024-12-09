/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Class for Alcoholic beverages, inherits from Beverage class
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


public class Alcohol extends Beverage{
	
	private boolean isWeekend;	
	private final double IS_WEEKEND = 0.60;
	
	/**
	 * constructor
	 * @param bevName
	 * @param size
	 * @param isWeekend
	 */
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		
		this.isWeekend = isWeekend;
		
	}
	
	/**
	 * checks if two alcohol objects are equal using superclass equals method
	 */
	@Override 
	public boolean equals(Object obj)
	{
		// if superclass equals method returns false, then objects are not equal
		if (super.equals(obj) == false)
		{
			return false;
		}
		
		// type casting to Alcohol class
		Alcohol alcohol = (Alcohol) obj;
		
		// checking instance fields
		if(this.isWeekend == alcohol.isWeekend)
		{
			return true;
		}
		
		return false;
		
	}
	
	
	/**
	 * calculates price of alcoholic beverage
	 */
	@Override
	public double calcPrice()
	{
		double price = this.addSizePrice();
		
		if (isWeekend)
		{
			price += IS_WEEKEND;
		}
		
		return price;
		
	}
	
	/**
	 * overriden toString method
	 */
	@Override
	public String toString()
	{
		return("Beverage name: " + this.getBevName() + " Beverage size: " + 
				this.getSize() + " Offered on Weekend: " + Boolean.toString(isWeekend) + " Price: " + calcPrice());
		
	}

	/**
	 * returns isWeekend field
	 * @return
	 */
	public boolean getIsWeekend() {
		return isWeekend;
	}

	/**
	 * sets value of isWeekend to parameter
	 * @param isWeekend
	 */
	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	
	
	
	

}
