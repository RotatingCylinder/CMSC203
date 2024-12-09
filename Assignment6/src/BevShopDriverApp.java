/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: This project creates the necessary classes to run a beverage shop, allowing the user to multiple orders of drinks
 * Due: 12/8/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import java.util.Scanner;

public class BevShopDriverApp {
	
	
	public static void main(String [] args) {
		
	// bevShop object
	BevShop bevShop = new BevShop();
	
	System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages");
	System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
	
	
	boolean keepOrdering = true; boolean addDrink = false; String keepGoing;

	// while loop to make multiple orders 
	while(keepOrdering)
	{
		Customer cust; String customerName; int customerAge; Day day; int time; String tempDay;
		
		Scanner scanner = new Scanner(System.in);
		
		// asking user for their name, age, order day and time, to create new order
		System.out.print("Enter your name: ");
		customerName = scanner.nextLine();
		System.out.print("Enter your age: ");
		customerAge = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter order day: ");
		tempDay = scanner.nextLine();
		System.out.print("Enter order time: ");
		time = scanner.nextInt();
		scanner.nextLine();
		
		// using valueOf method to convert string to Day enum
		day = Day.valueOf(tempDay.toUpperCase());

		// telling user to reneter time if time is invalid
		while(bevShop.isValidTime(time) == false)
		{
			System.out.println("Invalid order time, please enter a valid order time: ");
			time = scanner.nextInt();
			scanner.nextLine();
		}
		
		// creating new cust object and adding order to bevShop
		cust = new Customer(customerName,customerAge);
		bevShop.startNewOrder(time, day, customerName, customerAge);
		
		// checking if user can order alcoholic drinks
		if(bevShop.isValidAge(cust.getAge()))
		{
			
			System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");
			// setting numOfAlcoholDrink to 0
			bevShop.setNumOfAlcoholDrink(0);
			
			System.out.print("Would you like to add an alcoholic beverage to the order?: ");
			keepGoing = scanner.nextLine();
			if(keepGoing.equals("Y") || keepGoing.equals("y"))
			{
				addDrink = true;
			}
			else
			{
				addDrink = false;
			}
			
			// while loop to let user keep ordering alcoholic drinks
			while(addDrink == true)
			{
				String tempSize; Size size;
				
				// if user has already reached max amount of alcoholic drinks, exit while loop
				if(bevShop.isEligibleForMore() == false)
				{
					System.out.println("You have ordered the maximum amount of alcoholic drinks.\n");
					break;
				}
				else
				{
					System.out.println("You have ordered " + bevShop.getNumOfAlcoholDrink() + " alcoholic drinks and can order up to " + bevShop.getMaxOrderForAlcohol());
				}
				
				// asking user for size and name of drink
				System.out.print("What is the size of the drink: ");
				tempSize = scanner.nextLine();
				
				System.out.print("What is the name of the drink: ");
				String drinkName = scanner.nextLine();
				
				// using valueOf method to convert string to Size enum
				size = Size.valueOf(tempSize.toUpperCase());
				
				// adding beverage to bevList
				bevShop.processAlcoholOrder(drinkName, size);
				// iterating numOfAlcoholDrink
				bevShop.setNumOfAlcoholDrink(bevShop.getNumOfAlcoholDrink() + 1);
							
				// asking user if they'd like to order more alcoholic drinks
				System.out.print("Would you like to add an alcoholic beverage to the order?: ");
				keepGoing = scanner.nextLine();
				if(keepGoing.equals("Y") || keepGoing.equals("y"))
				{
					addDrink = true;
				}
				else
				{
					addDrink = false;
				}
			
			}
			
		}
		
		// EXACT SAME PROCESS AS ALCOHOL EXCEPT THERE IS NO AGE MINIMUM OR DRINK MAXIMUM
		// USING WHILE LOOPS TO ASK USER FOR DRINK INFORMATION AND IF THEY WANT TO KEEP ADDING DRINKS TO THE CURRENT ORDER
		
		System.out.print("Would you like to add a coffee to the order?: ");
		keepGoing = scanner.nextLine();
		
		if(keepGoing.equals("Y") || keepGoing.equals("y"))
		{
			addDrink = true;
		}
		else
		{
			addDrink = false;
		}
		
		while(addDrink == true)
		{
			boolean extraShot; boolean extraSyrup;
			String tempSize; Size size;

			
			System.out.print("What is the name of the drink: ");
			String drinkName = scanner.nextLine();
			System.out.print("What is the size of the drink: ");
			tempSize = scanner.nextLine();
			System.out.print("Would you like an extra shot: ");
			extraShot = scanner.nextBoolean();
			scanner.nextLine();

			System.out.print("Would you like extra syrup: ");
			extraSyrup = scanner.nextBoolean();
			scanner.nextLine();

			
			size = Size.valueOf(tempSize.toUpperCase());
			
			bevShop.processCoffeeOrder(drinkName, size, extraShot, extraSyrup);
			
			System.out.print("Would you like to add a coffee to the order?: ");
			keepGoing = scanner.nextLine();
			
			if(keepGoing.equals("Y") || keepGoing.equals("y"))
			{
				addDrink = true;
			}
			else
			{
				addDrink = false;
			}
		}
		
		System.out.print("Would you like to add a smoothie to the order?: ");
		
		keepGoing = scanner.nextLine();
		if(keepGoing.equals("Y") || keepGoing.equals("y"))
		{
			addDrink = true;
		}
		else
		{
			addDrink = false;
		}
		
		while(addDrink == true)
		{
			boolean addProtein; int numOfFruits = 0;
			String tempSize; Size size;

			
			System.out.print("What is the name of the drink: ");
			String drinkName = scanner.nextLine();
			System.out.print("What is the size of the drink: ");
			tempSize = scanner.nextLine();
			System.out.print("Would you like protein powder: ");
			addProtein = scanner.nextBoolean();	
			scanner.nextLine();

			
			System.out.print("How many fruits are you adding: ");
			numOfFruits += scanner.nextInt();
			scanner.nextLine();
			
			if(numOfFruits >= bevShop.getMaxNumOfFruits())
			{
				System.out.print("You have reached the maximum amount of fruits");
				numOfFruits = bevShop.getMaxNumOfFruits();
			}
			
			size = Size.valueOf(tempSize.toUpperCase());

			
			bevShop.processSmoothieOrder(drinkName, size, numOfFruits, addProtein);
			
			
			System.out.print("Would you like to add a smoothie to the order?: ");
			keepGoing = scanner.nextLine();
			if(keepGoing.equals("Y") || keepGoing.equals("y"))
			{
				addDrink = true;
			}
			else
			{
				addDrink = false;
				
			}
		}
		
		// displaying price of the order and asking user if they'd like to add another order
		
		System.out.println("The total price of the order is: " + bevShop.totalMonthlySale());
		System.out.println("#------------------------------------#");

		
		System.out.print("\nWould you like to add a new order: ");
		keepGoing = scanner.nextLine();
		if(keepGoing.equals("Y") || keepGoing.equals("y"))
		{
			keepOrdering = true;
		}
		else
		{
			keepOrdering = false;
		}
		
		
	}
	
	// using toString method to display receipt
	System.out.println("\n" + bevShop.toString());
	
	
	}
}
