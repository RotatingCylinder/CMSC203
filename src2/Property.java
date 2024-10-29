
/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Property class file, defines the owner, location, and rent of a plot of land
 * Due: 10/28/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/
public class Property 
{
	// fields
	private String city,owner,propertyName;
	private double rentAmount;
	private Plot plot;
	
	/*
	 * Default constructor
	 */
	public Property()
	{
		plot = new Plot();
		city = ""; owner = "";propertyName = "";
	}
	
	/**
	 * Initializes Property object using given parameter values
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount,String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		plot = new Plot();
	}
	
	/**
	 * initializes Property object using given paramter values
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Property(String propertyName, String city, double rentAmount,String owner, int x, int y, int width, int depth) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		plot = new Plot(x,y,width,depth);
	}
	
	
	/**
	 * copy constructor, shallow copy
	 * @param otherProperty - object to copy from 
	 */
	public Property(Property otherProperty)
	{
		
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.propertyName=otherProperty.propertyName;
		this.rentAmount = otherProperty.rentAmount;
		this.plot = new Plot(otherProperty.plot);
		
	}
	
	// accessors
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	// mutators
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	public void setName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public void setRent(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		return (propertyName +","+city+","+getOwner()+","+rentAmount);
	}
}
