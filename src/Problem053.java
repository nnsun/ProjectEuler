import java.math.BigInteger;

// Project Euler problem 53
// Solved on 11/26/2015
public class Problem053
{
	public static void main(String[] args)
	{
		int total = 0;
		for(int n = 23; n <= 100; n++)		// loops through possible n values, starting at given min value
		{
			for(int r = 0; r <= n; r++)		// loops through possible r values
			{
				// BigInteger representation of resulting n C r value
				BigInteger combinations = 
						new BigInteger(Problem015.factorial(n).divide((Problem015.factorial(r).multiply(Problem015.factorial(n-r)))).toString());
				
				BigInteger million = new BigInteger("1000000");		// BigInteger representation of one million
				
				if(combinations.compareTo(million) == 1)	// checks if n C r is greater than one million
				{
					total++;
				}
			}
		}
		System.out.println(total);
	}
}
