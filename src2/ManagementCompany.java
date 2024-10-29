/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: ManagementCompany class file, defines a management company which has its own plot and list of managed properties
 * Due: 10/28/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import java.util.Arrays;

public class ManagementCompany 
{
	// fields
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;	 
	static final int MGMT_WIDTH = 10;
	
	private String name, taxID;
	private double mgmFee;
	private int numberOfProperties;
	private Plot plot;
	private Property [] properties; 
	
	/**
	 *  Default constructor
	 */
	public ManagementCompany()
	{
		properties = new Property [MAX_PROPERTY];
		plot = new Plot(); plot.setWidth(MGMT_WIDTH); plot.setDepth(MGMT_DEPTH);
		
		name = ""; taxID = "";
	}
	
	/**
	 * Initializes each field of ManagementCompany with the given parameter value
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		properties = new Property [MAX_PROPERTY];
		plot = new Plot(); plot.setWidth(MGMT_WIDTH); plot.setDepth(MGMT_DEPTH);
		
		this.name = name; this.mgmFee = mgmFee; this.taxID = taxID;
	}
	
	/**
	 * Initializes each field of ManagementCompany and plot with the given parameter value
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		properties = new Property [MAX_PROPERTY];
		plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Copy constructor, shallow copy
	 * @param otherCompany - object to be copied from
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.numberOfProperties = otherCompany.numberOfProperties;
		this.properties = Arrays.copyOf(otherCompany.properties, MAX_PROPERTY);
		this.plot = new Plot(otherCompany.plot);
	}
	
	// overloaded addProperty methods
	
	/**
	 * initializes a Property object using the given parameters
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property property = new Property(name,city,rent,owner);
		int val = 0;
		
		for (int i = 0; i < properties.length; i++)
		{
			if( properties[i] != null) {
				if (i == properties.length - 1)
				{
					val = -1;
					break;
				}
				else if(property == null)
				{
					val = -2;
					break;
				}
				else if(plot.encompasses(property.getPlot()) == true)
				{
					val = -3;
					break;
				}
				else if(properties[i].getPlot().overlaps(property.getPlot()) == true)
				{
					val = -4;
					break;
				}
				
				}
			else if(properties[i] == null)
			{
				
				properties[i] = new Property(property);
				val = i;
				break;
				
			}
			
		}
		return val;
	
	}
	
	/**
	 * initializes a Property object using the given parameters
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property property = new Property(name,city,rent,owner,x,y,width,depth);
		int val = 0;
		
		for (int i = 0; i < properties.length; i++)
		{
			if( properties[i] != null) {
				if (i == properties.length - 1)
				{
					val = -1;
					break;
				}
				else if(property == null)
				{
					val = -2;
					break;
				}
				else if(plot.encompasses(property.getPlot()) == true)
				{
					val = -3;
					break;
				}
				else if(properties[i].getPlot().overlaps(property.getPlot()) == true)
				{
					val = -4;
					break;
				}
				
				}
			else if(properties[i] == null)
			{
				
				properties[i] = new Property(property);
				val = i;
				break;
				
			}
			
		}
		return val;
		
	}
	
	/**
	 * Initializes a Property object using the given parameter
	 * @param newProperty
	 * @return
	 */
	public int addProperty(Property newProperty)
	{
		Property property = new Property(newProperty);
		int val = 0;
		
		for (int i = 0; i < properties.length; i++)
		{
			if( properties[i] != null) {
				if (i == properties.length - 1)
				{
					val = -1;
					break;
				}
				else if(property == null)
				{
					val = -2;
					break;
				}
				else if(plot.encompasses(property.getPlot()) == true)
				{
					val = -3;
					break;
				}
				else if(properties[i].getPlot().overlaps(property.getPlot()) == true)
				{
					val = -4;
					break;
				}
				
				}
			else if(properties[i] == null)
			{
				
				properties[i] = new Property(property);
				val = i;
				break;
				
			}
			
		}
		return val;
	}
	
	public Property getHighestRentPropperty()
	{
		double highest = 0; 
		int index = 0;;
		
		for(int i = 0; i < properties.length; i++)
		{
			if(properties[i] != null && properties[i].getRentAmount() > highest)
			{
				highest = properties[i].getRentAmount();
				index = i;
			}
		}
		
		return properties[index];
	}
	
	public double getTotalRent()
	{
		double totalRent = 0; 
		
		for(int i = 0; i < properties.length; i++)
		{
			if(properties[i] != null)
			{
			totalRent += properties[i].getRentAmount();
			}
			
		}
		
		return totalRent;
	}
	
	// accessors
	
	public double getMgmFee()
	{
		return mgmFee;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public int getPropertiesCount()
	{
		int index = 0;
		
		for(int i = 0; i < MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
			{
				index++;
			}
		}
		
		return index;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	// mutators
	public void setMgmFee(double mgmFee)
	{
		this.mgmFee = mgmFee;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTaxID(String taxID)
	{
		this.taxID = taxID;
	}
	
	/**
	 * checks if mgmFee is with 0-100
	 * @return true or false
	 */
	public boolean isMangementFeeValid()
	{
		if (mgmFee > 0 && mgmFee < 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * checks if properties array is full
	 * @return true or false
	 */
	public boolean isPropertiesFull()
	{
		boolean valid = false;
		for (int i = 0; i < properties.length; i++)
		{
			if (i == properties.length - 1 && properties[i] != null)
			{
				valid = true;
			}
		}
		return valid;
	}
	
	/**
	 * removes last Property obejct from properties array
	 */
	public void removeLastProperty()
	{
		for (int i = properties.length - 1; i > 0;i--)
		{
			if(properties[i] != null)
			{
				properties[i] = null;
				break;
			}
		}
	}
	
	/**
	 * toString method
	 */
	public String toString()
	{
		String toString = "List of the properties for " + name + ", taxID: " + taxID +  "\n______________________________________________________\n";
		for(int i = 0; i < properties.length; i++)
		{
			if(properties[i] != null)
			{
			toString += properties[i].toString() + "\n";
			}
		}
		
		toString += ("______________________________________________________\n\n total management Fee: " + (getTotalRent()*(mgmFee/100)));
		return toString;
	}
	
	
	
}
