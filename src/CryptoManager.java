
public class CryptoManager 
{	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	public static boolean isStringInBounds(String plainText)
	{
		boolean inBounds = true; 
		int lower = LOWER_RANGE;int upper = UPPER_RANGE;
		for (int i = 0; i < plainText.length(); i++)
		{
			if(plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE)
			{
				inBounds = false;
			}
		}
		return inBounds;
	}
	
	public static String caesarEncryption (String plainText, int key)
	{
		String encryptedText = "";
		int nextElement;
		
		if (isStringInBounds(plainText) == false)
		{
			return "The selected string is not in bounds, Try again.";
		}
		
		for (int i = 0; i < plainText.length(); i++)
		{
			nextElement = plainText.charAt(i) + key;
			while (nextElement > UPPER_RANGE)
			{
				nextElement = LOWER_RANGE +(nextElement-UPPER_RANGE-1);
			}
			encryptedText += Character.toString ((char) nextElement);
		}
		return encryptedText;
		
	}
	
	public static String caesarDecryption (String encryptedText, int key)
	{
		String plainText = "";
		int nextElement;
		
		if (isStringInBounds(encryptedText) == false)
		{
			return "The selected string is not in bounds, Try again.";
		}
		
		for (int i = 0; i < encryptedText.length(); i++)
		{
			nextElement = encryptedText.charAt(i) - key;
			while (nextElement < LOWER_RANGE)
			{
				nextElement = UPPER_RANGE - (LOWER_RANGE - nextElement -1);
			}
			plainText += Character.toString ((char) nextElement);
		}
		return plainText;
	}
	
	public static String bellasoEncryption(String plainText,String bellasoString)
	{
		String encryptedText = "";
		int nextElement,bellasoCounter = 0;
		
		if (isStringInBounds(plainText) == false || isStringInBounds(bellasoString) == false)
		{
			return "The selected string is not in bounds, Try again.";
		}
		
		for (int i = 0; i < plainText.length(); i++)
		{
			if (bellasoCounter == bellasoString.length())
			{
				bellasoCounter = 0;
			}
			
			nextElement = plainText.charAt(i) + bellasoString.charAt(bellasoCounter);
			bellasoCounter++;

			while (nextElement > UPPER_RANGE)
			{
				nextElement-=RANGE;
			}
			encryptedText += Character.toString ((char) nextElement);
		}
		return encryptedText;
		
	}
	
	public static String bellasoDecryption(String encryptedText,String bellasoString)
	{
		String plainText = "";
		int nextElement, bellasoCounter = 0;
		
		if (isStringInBounds(encryptedText) == false || isStringInBounds(bellasoString) == false)
		{
			return "The selected string is not in bounds, Try again.";
		}
		
		for (int i = 0; i < encryptedText.length(); i++)
		{
			if (bellasoCounter == bellasoString.length())
			{
				bellasoCounter = 0;
			}
			nextElement = encryptedText.charAt(i) - bellasoString.charAt(bellasoCounter);
			bellasoCounter++;
			
			while (nextElement < LOWER_RANGE)
			{
				nextElement+=RANGE;
			}
			plainText += Character.toString ((char) nextElement);
		}
		return plainText;
		
	}	
}
