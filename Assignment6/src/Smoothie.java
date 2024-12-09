
public class Smoothie extends Beverage {
	
	private int numOfFruit;
	private boolean addProtein;
	
	private final double ADD_FRUIT = 0.50;
	private final double ADD_PROTEIN = 1.50;
	
	
	public Smoothie(String bevName, Size size, int numOfFruit, boolean addProtein)
	{
		super(bevName,Type.SMOOTHIE,size);
		
		this.numOfFruit = numOfFruit; this.addProtein = addProtein;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// if superclass equals method returns false, then objects are not equal
		if (super.equals(obj) == false)
		{
			return false;
		}
		
		Smoothie smoothie = (Smoothie) obj;
		
		if(this.addProtein == smoothie.addProtein && this.numOfFruit == smoothie.numOfFruit)
		{
			return true;
		}
		
		return false;
	}
	
	@Override 
	public double calcPrice()
	{
		double price = this.addSizePrice();
		
		price += (ADD_FRUIT * numOfFruit);
		
		if (addProtein)
		{
			price += ADD_PROTEIN;
		}
		
		return price;
	}
	
	@Override
	public String toString()
	{
		return ("Smoothie name: " + this.getBevName() + " Smoothie size: " + this.getSize() 
		+ " Add protein: " + Boolean.toString(addProtein) + " Number of fruits: " + numOfFruit + " Price: " + calcPrice());
	}

	public int getNumOfFruit() {
		return numOfFruit;
	}

	public void setNumOfFruit(int numOfFruit) {
		this.numOfFruit = numOfFruit;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	
	
	

}
