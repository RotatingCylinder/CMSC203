/* Class: CMSC203 CRN 23488 
 * Instructor: Huseyin Aygun
 * Description: HolidayBonus class, calculates a store's holiday bonus in a category and its total bonus
 * Due: 11/18/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Kelvin Hernandez Salas
*/


public class HolidayBonus {
	
	// initializing static bonuses
	private static double LEAST_BONUS = 1000; 
	private static double MOST_BONUS = 5000;
	private static double NORMAL_BONUS = 2000;
	
	/**
	 * Calculates the total holiday bonus for each store
	 * @param data - 2D array of sales figures
	 * @return bonus - array of holiday bonuses
	 */
	public static double[] calculateHolidayBonus(double[][] data)
	{
		// array to hold each store's total bonus
		double [] bonus = new double[data.length];
		
		// looping through 2D array
		for (int i = 0; i < data.length; i++)
		{
			for (int q = 0; q < data[i].length;q++)
			{
				// checking sales of current category to determine what bonus to add
				if (data[i][q] == TwoDimRaggedArrayUtility.getHighestInColumn(data,q)) 
				{
					bonus[i] += MOST_BONUS;
				}
				else if(data[i][q] <= 0)
				{
					bonus[i] += 0;
				}
				else if(data[i][q] == TwoDimRaggedArrayUtility.getLowestInColumn(data,q)) 
				{
					bonus[i] += LEAST_BONUS;
				}
				else
				{
					bonus[i] += NORMAL_BONUS;
				}
			}
		}		
		return bonus;
	}
	
	/**
	 * Calculates the total holiday bonus of all stores
	 * @param data
	 * @return total - total holiday bonus
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		
		double total = 0;
		
		// looping through the bonus array generated by calculateHolidayBonus function
		// and summing its elements
		for(int i =0; i < calculateHolidayBonus(data).length; i++)
		{
			total += calculateHolidayBonus(data)[i];
		}
		return total;
	}
}
