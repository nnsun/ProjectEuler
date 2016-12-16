// Project Euler problem 35
// Solved on 9/8/2015
public class Problem035
{
	public static void main(String[] args)
	{
		int count = 0;	// variable used to keep track of number of circular primes
		
		for(int i = 2; i < 1000000; i++)	// for loop to go through each prime
		{
			if(isPrime(i))	// checks for primes
			{
				String str = Integer.toString(i);	// converts the int to a string
				int length = str.length();	// length will be used to keep track of how many digit rotations are required
				if(length == 1)	// if the prime is a one-digit number, it's automatically a circular prime
				{
					count++;
				}
				char[] strArray = str.toCharArray();	// creates a char array of digits in the prime.
				for(int j = 0; j < length-1; j++)	// rotates the digit however many times is required
				{
					char[] tempArray = new char[length];	// new temp char array that will be used for rotation	
					for(int k = 0; k < length-1; k++)	// rotates all digits to the right one space
					{
						tempArray[k] = strArray[k+1];
					}
					tempArray[length-1] = strArray[0];	
					
					strArray = tempArray;
					if(!isPrime(Integer.parseInt(String.valueOf(tempArray))))	// if any of the rotations isn't a prime, break out of the loop
					{
						break;
					}
					
					if(j == length - 2)	// if the number's reached its final rotation and none are primes, a circular prime's been found
					{
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isPrime(int n)	// simple method for finding primes
	{		
		if(n <= 1)
		{
			return false;
		}
		for(int i = 2; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
