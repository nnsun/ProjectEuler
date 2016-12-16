import java.util.ArrayList;

// Project Euler problem 36
// Solved on 9/28/2015
public class Problem036
{
	public static void main(String[] args)
	{
		ArrayList<Integer> palindromes = new ArrayList<Integer>();	// holds base-10 palindromes
		for(int i = 0; i < 1000000; i++)	// populates palindromes ArrayList
		{
			String numString = Integer.toString(i);	
			if(isPalindrome(numString))
			{
				palindromes.add(i);
			}
			
		}

		int sum = 0;
		for(int i = 0; i < palindromes.size(); i++)		// checks if the palindromes are also binary palindromes and adds them to the sum if they are
		{
			String binaryString = Integer.toBinaryString(palindromes.get(i));
			if(isPalindrome(binaryString))
			{
				sum += palindromes.get(i);
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isPalindrome(String str)	// returns true if String is a palindrome, false otherwise
	{
		char[] array = str.toCharArray();	// converts the String to a char array
		int length = array.length;
		
		// goes through half of the characters and checks they match their corresponding characters on the other side of the array
		for(int i = 0; i <= (array.length-1) / 2 ; i++)		
		{
			if(array[i] != array[length - i - 1])			
			{
				return false;
			}
		}
		return true;
	}
}
