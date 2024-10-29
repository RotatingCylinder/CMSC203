/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: Plot class file, defines the dimensions of a plot of land and checks if other plots overlap/encompass this plot
 * Due: 10/28/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


public class Plot 
{
	// fields
	private int width,depth,x,y;
	
	// constructors
	
	/**
	 * Default plot constructor
	 */
	public Plot()
	{
		width = 1;depth =1;
	}
	
	/**
	 * Initializes each field of Plot using the given parameter values
	 * @param x - x coordinate of upper left corner
	 * @param y - y coordinate of upper left corner
	 * @param depth - depth of the plot
	 * @param width - width of the plot
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;this.y = y;this.width = width;this.depth = depth;
	}
	
	/**
	 * Copy constructor, shallow copy
	 * @param otherPlot - Plot object to be copied from
	 */
	public Plot(Plot otherPlot)
	{
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
		this.x = otherPlot.x;
		this.y = otherPlot.y;
	}
	
	// accessors
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	// mutators
	
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * checks if plot is encompassed by this plot
	 * @param plot - plot to check
	 * @return true or false
	 */
	public boolean encompasses(Plot plot)
	{
		
		boolean valid = true;
		
		if(plot.getX() < this.x || plot.getX() > this.x+this.width)
		{
			return false;
		}
		else if (plot.getY() < this.y || plot.getY() > this.y+this.depth)
		{
			return false;
		}
		
		if(plot.getY() + plot.getDepth() > this.y + this.depth || plot.getX() + plot.getWidth() > this.x + this.width )
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * checks if plot is overlapped by this plot
	 * @param plot - plot to check
	 * @return true or false
	 */
	public boolean overlaps(Plot plot)
	{
		//boolean valid = false;			
		if (encompasses(plot) == true)
		{
			return true;
		}
		
		if (plot.getX() > this.x && plot.getX() < this.x + this.width)
		{
		
			if(plot.getY()+plot.getDepth() > plot.getY() + this.y)
			{
				return true;
			}
			
		}
		else if (plot.getY() > this.y && plot.getY() < this.y + this.depth)
		{
			if(plot.getX()+plot.getWidth() > plot.getX() + this.x)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * toString function
	 */
	public String toString()
	{
		return (x+","+y+","+width+","+depth);
	}
	
	
	
	
}
