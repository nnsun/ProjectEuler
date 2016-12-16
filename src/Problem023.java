import java.util.ArrayList;

// Project Euler problem 23
// Solved on 8/3/2015
public class Problem023
{
	public static void main(String args[])
	{
		int sum = 0;
		ArrayList<Integer> abundant = new ArrayList<Integer>();		// ArrayList for storing abundant numbers
		for(int i = 1; i <= 28123 - 12; i++)	// loops through all numbers to populate abundant numbers list
		{
			if(Problem021.factorSum(i) > i)		// if number is abundant...
			{
				abundant.add(i);
			}
		}
		
		boolean[] sumOfAbundants = new boolean[28123];	// boolean array to store whether or not 
														// corresponding number to element is sum of two abundant numbers
		
		for(int i = 0; i < abundant.size(); i++)	// loops through abundant numbers to get all sums at or below 28123
		{
			for(int j = 0; j <= i; j++)
			{
				if(abundant.get(i) + abundant.get(j) <= 28123)
				{
					sumOfAbundants[abundant.get(i) + abundant.get(j) - 1] = true;	// element in sumOfAbundants becomes true if it's a sum of abundants
				}
			}
		}
		for(int i = 0; i < sumOfAbundants.length; i++)	// adds all numbers that aren't sums of abundant numbers
		{
			if(!sumOfAbundants[i])
			{
				sum += i + 1;
			}
		}
		System.out.println(sum);
	}
}
