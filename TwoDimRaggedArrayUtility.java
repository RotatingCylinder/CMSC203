/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: TwoDimRaggedAArrayUtility class, a utility class that can navigate a 2D array 
 * Due: 11/18/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class TwoDimRaggedArrayUtility {
	
	// file utilities
	
	/**
	 * Takes a file holding sales figures and converts it to a 2D array
	 * @param file - file holding sales figures
	 * @return data - 2D array that holds the sales figures from file
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile (File file) throws FileNotFoundException
	{
		int index = 0, rows = 0;
		Scanner scanner = new Scanner(file);
		
		// going through file to see how many rows data should have
		while(scanner.hasNextLine())
		{
			rows++;
			
			// the GUI doesn't work without this line and I don't know why
			System.out.print(scanner.nextLine());
		}
		scanner.close();
	
		double [][] data = new double[rows][];
		Scanner myFile = new Scanner(file);
		
		
		
		while(myFile.hasNextLine()) 
		{					
			// initializing elements of sales array to be the sales figures in the current line of the file
			String [] sales = myFile.nextLine().trim().split(" ");
			
			// defining the length of the current row in the 2D array
			data[index] = new double [sales.length];
			
			for(int i = 0; i < sales.length; i++)
			{
				// assigning each element of sales array to an entry in the 2D array
				data[index][i] = Double.parseDouble(sales[i]);
			}
			
			index++;
		}
		
		myFile.close();
		return data;
	}
	
	/**
	 * 
	 * @param data - 2D array of sales figures
	 * @param file - file to hold sales figures from data array
	 */
	public static void writeToFile(double [][] data, File file) 
	{
		try {
		FileWriter myFile = new FileWriter(file);
		
		// looping through 2D array and writing its elements to file
		for (int i = 0; i < data.length; i++)
		{
			for(int q = 0; q < data[i].length; q++)
			{
				myFile.write(data[i][q] + " ");
			}
			myFile.write("\n");
		}
		
		myFile.close();
		}
		catch(IOException e)
		{
			
		}
		
		
	}
	
	// 2D array utilities
	
	public static double getTotal(double [][] data)
	{
		double total = 0;
		for (int i = 0; i < data.length; i++)
		{
			for(int q = 0; q < data[i].length; q++)
			{
				total+= data[i][q];
			}
		}
		return total;
	}
	
	public static double getAverage(double [][] data)
	{
		int totalElements = 0;
		for (int i = 0; i < data.length; i++)
		{
			for(int q = 0; q < data[i].length; q++)
			{
				totalElements++;
			}
		}
		
		return(getTotal(data)/totalElements);
		
	}
	
	public static double getHighestInArray(double [][] data)
	{
		double highest = 0;
		for (int i = 0; i < data.length; i++)
		{
			for(int q = 0; q < data[i].length; q++)
			{
				if (data[i][q] > highest)
				{
					highest = data[i][q];
				}
			}
		}
		return highest;
	}
	
	public static double getLowestInArray(double [][] data)
	{
		double lowest = getHighestInArray(data);
		for (int i = 0; i < data.length; i++)
		{
			for(int q = 0; q < data[i].length; q++)
			{
				if (data[i][q] < lowest)
				{
					lowest = data[i][q];
				}
			}
		}
		return lowest;
	}
	
	// row utlities
	
	public static double getRowTotal(double [][] data, int row)
	{
		double total = 0;
		for (int i = 0; i < data[row].length; i++)
		{
			total += data[row][i];
		}
		
		return total;
	}
	
	public static double getHighestInRow(double [][] data, int row)
	{
		double highest = 0;
		for (int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] > highest)
			{
				highest = data[row][i];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double [][] data, int row)
	{
		double highest = 0;
		int highestIndex = 0;
		for (int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] > highest)
			{
				highest = data[row][i];
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInRow(double [][] data, int row)
	{
		double lowest = getHighestInRow(data,row);
		for (int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] < lowest)
			{
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double [][] data, int row)
	{
		double lowest = getHighestInRow(data,row);
		int lowestIndex = 0;
		for (int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] < lowest)
			{
				lowest = data[row][i];
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	
	// column utlities
	
	public static double getColumnTotal(double [][] data, int col)
	{
		double total = 0;
		for (int i = 0; i < data.length; i++)
		{
			if(data[i].length <= col || col < 0)
			{
				continue;
			}
			total+= data[i][col];
		}
		return total;
	}
	
	
	public static double getHighestInColumn(double [][] data, int col)
	{
		double highest = 0;
		for (int i = 0; i < data.length; i++)
		{
			if(data[i].length <= col || col < 0)
			{
				continue;
			}
			if(data[i][col] > highest)
			{
				highest = data[i][col];
			}
			
		}
		return highest;
	}
	
	public static int getHighestInColumnIndex(double [][] data, int col)
	{
		double highest = 0;
		int highestIndex = 0;
		for (int i = 0; i < data.length; i++)
		{
			if(data[i].length <= col || col < 0)
			{
				continue;
			}
			if(data[i][col] > highest)
			{
				highest = data[i][col];
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInColumn(double [][] data, int col)
	{
		double lowest = getHighestInColumn(data,col);
		for (int i = 0; i < data.length; i++)
		{
			if(data[i].length <= col || col < 0)
			{
				continue;
			}
			if(data[i][col] < lowest)
			{
				lowest = data[i][col];
			}
		}
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double [][] data, int col)
	{
		double lowest = getHighestInColumn(data,col);
		int lowestIndex = 0;
		for (int i = 0; i < data.length; i++)
		{
			if(data[i].length <= col || col < 0)
			{
				continue;
			}
			
			if(data[i][col] < lowest)
			{
				lowest = data[i][col];
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	
}


