// Project Euler problem 46
// Solved on 11/26/2015
public class Problem046
{
	public static void main(String[] args)
	{
		int n = 33; 	// odd composite number to be checked
		int square = 1;		// 2 * square^2 component of n
		
		check:
		while(true)
		{
			n += 2;
			if(Problem035.isPrime(n))	// check that n isn't prime
			{
				n += 2;
				continue;
			}
			square = 1;
			while(true)
			{
				while(2 * square * square < n)		// while 2 * square^2 is less than n...
				{
					if(Problem035.isPrime(n - 2 * square * square))		// if difference is a prime, try a new n
					{
						continue check;
					}
					else		// else, try a new square
					{
						square++;
					}
				}
				break check;		// only reached if n isn't satisfied by 2 * square^2 + prime
			}
		}
		System.out.println(n);
	}
}
