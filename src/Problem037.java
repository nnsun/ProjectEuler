// Project Euler problem 37
// Solved on 10/12/2015
public class Problem037
{
	public static void main(String[] args)
	{
		int count = 0;
		int sum = 0;
		int n = 10;		// first possible truncatable prime
		while(count < 11)	// runs until 11th truncatable prime is found
		{
			if(isTruncatablePrime(n))	// if a truncatable prime is found, it's added to the sum and the number found is incremented
			{
				sum += n;
				count++;
			}
			n++;
		}
		System.out.println(sum);
	}
	
	public static boolean isTruncatablePrime(int n)		// returns true if n is a truncatable prime, false otherwise
	{
		String digitStr = Integer.toString(n);		// string representation of the number
		for(int i = 0; i < digitStr.length(); i++)
		{
			if(!Problem035.isPrime(Integer.parseInt(digitStr.substring(i))))	// removing digits from right to left
			{
				return false;
			}
			if(!Problem035.isPrime(Integer.parseInt(digitStr.substring(0, digitStr.length() - i))))		// removing digits from left to right
			{
				return false;
			}
		}
		return true;
	}
}
