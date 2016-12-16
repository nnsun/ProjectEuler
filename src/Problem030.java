// Project Euler problem 30
// Solved on 10/7/2015
public class Problem030
{
	public static void  main(String[] args)
	{
		int upperBound = 354294;	// obtained by finding highest possible value that x * 9^5 could possibly equal x, where x is the number of digits.
		int sum = 0;
		for(int i = 2; i <= upperBound; i++)	// parse through numbers between 2 (the smallest allowable number) and the upper bound
		{
			char[] digits = Integer.toString(i).toCharArray();	// creates a char array containing the digits
			int fifthPowerSum = 0;
			for(int j = 0; j < digits.length; j++)	// loops through char array and adds fifth power of the digits
			{
				fifthPowerSum += Math.pow(Integer.parseInt(Character.toString(digits[j])), 5);
			}
			if(fifthPowerSum == i)	// checks if sum matches the original number
			{
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
