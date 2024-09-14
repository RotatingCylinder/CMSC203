/*
 * Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: This program gets and displays a list of colors from a text file, chooses
a random color, and asks the user to guess the random color 3 times.
 * Due: 9/16/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class ESPGame 
{
	// IOException for file management
	public static void main(String [] args) throws IOException
	{
		// defining variables
		Scanner keyboard = new Scanner(System.in);
		String fileName, colorName, colorGuess, colors, myName,description, dueDate;
		int colorNumber, correctGuesses = 0;
		Random randomNumber = new Random();
		
		final String COLOR_1 = "black";
		final String COLOR_2 = "white";
		final String COLOR_3 = "gray";
		final String COLOR_4 = "silver";
		final String COLOR_5 ="maroon";
		final String COLOR_6 = "red";
		final String COLOR_7 = "purple";
		final String COLOR_8 = "fuchsia";
		final String COLOR_9 = "green";
		final String COLOR_10 = "lime";
		final String COLOR_11 = "olive";
		final String COLOR_12 = "yellow";
		final String COLOR_13 = "navy";
		final String COLOR_14 = "blue";
		final String COLOR_15 = "teal";
		final String COLOR_16 = "aqua";
		
		// asking user to enter file name
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.print("Enter the filename: ");
		fileName = keyboard.nextLine();
				
		// assigning colorsFile to colors.txt file
		File colorsFile = new File(fileName);
		// Initializing Scanner variable readFile to contents of colorsFile
		Scanner readFile = new Scanner(colorsFile);
		
		
		// while loop to read contents of readFile line by line, then close readFile
		while (readFile.hasNext())
		{
			colors = readFile.nextLine();
			System.out.println(colors);
		}
		readFile.close(); 
		System.out.print("\n");
		
		// for loop to repeat the ESP skill test for 3 rounds
		for (int i = 0; i < 3; i++)
		{
			// storing new random number in colorNumber
			colorNumber = randomNumber.nextInt(15);
			
			// switch statement to initialize colorName based on the random number stored in colorNumber
			// cases start at 0 because the nextInt() function generates integers starting at 0
			colorName = switch (colorNumber)
			{
				case 0 -> COLOR_1;
				case 1 -> COLOR_2;
				case 2 -> COLOR_3;
				case 3 -> COLOR_4;
				case 4 -> COLOR_5;
				case 5 -> COLOR_6;
				case 6 -> COLOR_7;
				case 7 -> COLOR_8;
				case 8 -> COLOR_9;
				case 9 -> COLOR_10;
				case 10 -> COLOR_11;
				case 11 -> COLOR_12;
				case 12 -> COLOR_13;
				case 13 -> COLOR_14;		
				case 14 -> COLOR_15;
				case 15 -> COLOR_16;
				default -> "N/A";
			};
			
			// telling user the current round and asking them to guess the color
			System.out.println("Round " + (i+1) + "\n");
			System.out.println("I am thinking of a color.");
			System.out.println("Is it one of list of colors above?");
			System.out.print("Enter your guess: ");
			colorGuess = keyboard.nextLine();
			
			// if statement to track number of correct guesses 
			// user input is made lowercase in case user guesses correctly but input uppercase letters
			if (colorName.equals(colorGuess.toLowerCase()) == true)
			{
				correctGuesses += 1;
			}
			System.out.println("\nI was thinking of " + colorName);
		}
		
		// telling user how many colors they guessed correctly
		System.out.println("Game Over");
		System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly");		
		
		// asking user for name, description, and due date, then displaying that information
		System.out.print("Enter your name: ");
		myName = keyboard.nextLine();
		System.out.print("Describe yourself: "); 
		description = keyboard.nextLine();
		System.out.print("Due Date: "); 
		dueDate = keyboard.nextLine();
		keyboard.close();
		
		System.out.println("User namee: " + myName); 
		System.out.println("User description: " + description);
		System.out.print("Date: " + dueDate);
	}

}
