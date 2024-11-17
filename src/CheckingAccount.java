
public class CheckingAccount extends BankAccount 
{
	private static double FEE = 0.15;
	
	
	public CheckingAccount(String name, int initialAmount)
	{
			// using super keyword to call superclass constructor
			super(name,initialAmount);
			
			// concatenating -10 to account number
			setAccountNumber(getAccountNumber()+"-10");
	}
	
	// overriding withdraw function
	@Override
	public boolean withdraw(double amount)
	{
		// adding fee to amount, and passing it to superclass withdraw function
		amount+=FEE;
		return super.withdraw(amount);
	}
	
	
	
	

}
