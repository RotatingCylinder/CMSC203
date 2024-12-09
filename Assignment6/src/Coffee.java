/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Class for Coffee beverages, inherits from Beverage class
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


public class Coffee extends Beverage{
	
	private boolean extraShot; 
	private boolean extraSyrup;
	
	private final double EXTRA_SHOT = .50;
	private final double EXTRA_SYRUP = .50;
	
	/**
	 * constructor, uses super keyword to call superclass constructor
	 * @param name
	 * @param size
	 * @param extraCoffee
	 * @param extraSyrup
	 */
	public Coffee (String name, Size size, boolean extraCoffee, boolean extraSyrup)
	{
		super(name, Type.COFFEE, size);
		
		this.extraShot = extraCoffee;
		this.extraSyrup = extraSyrup;		
	}
	
	/**
	 * overriden equals method
	 */
	@Override
	public boolean equals(Object obj)
	{
		// if superclass equals method returns false, then objects are not equal
			if (super.equals(obj) == false)
			{
					return false;
			}
		
		// typecasting obj to Coffee 
		Coffee coffee = (Coffee) obj;
		
		// comparing instance fields
		if(this.extraShot == coffee.extraShot && this.extraSyrup == coffee.extraSyrup)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 *  checking if extraShot or extraSyrup are true and changing price accordingly 
	 */
	@Override
	public double calcPrice()
	{
		double price = this.addSizePrice();
		
		if (extraShot == true)
		{
			price+= EXTRA_SHOT;
		}
		
		if(extraSyrup == true)
		{
			price += EXTRA_SYRUP;
		}
		
		return price;
	}
	
	/**
	 * overriden toString method
	 */
	@Override
	public String toString()
	{
		return ("Coffee name: " + this.getBevName() + " Coffee size: " + this.getSize() 
		+ " Extra coffee: " + Boolean.toString(extraShot) + " Extra syrup: " + Boolean.toString(extraSyrup));
	}

	// getters and setters
	
	public boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	
}
