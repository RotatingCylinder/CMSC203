
public class SavingsAccount extends BankAccount 
{	
	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double initialAmount)
	{
		// calling superclass constructor
		 super(name,initialAmount);
		 
		 // using superclass accessor since this subclass overrides getAccountNumber()
		 accountNumber = (super.getAccountNumber() + "-" + savingsNumber);
	}
	
	public SavingsAccount(SavingsAccount oldSavings, double initialAmount)
	{
		// calling superclass copy constructor
		super(oldSavings,initialAmount);
		
		savingsNumber = oldSavings.savingsNumber + 1;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}
	
	public void postInterest()
	{
		// rate divided by 12 since rate is annual while this function is monthly
		setBalance(getBalance() + (getBalance() * (rate/12)));
	}
	
	// overriding getAccountNumber()
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	

}
