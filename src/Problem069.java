import java.util.ArrayList;

//Project Euler Problem 69
//Solved on 11/27/2015
//I wrote the two methods for brute-forcing, but since that method is slow for n = 1,000,000, I did some research and found a better solution.
//I kept the two methods because they'll probably be useful later.
public class Problem069
{
	public static void main(String[] args)
	{
		//the ratio n/phi(n) depends on the number of prime factors that n has, so the number with the most prime factors has the highest ratio.
		int product = 1;
		int prime = 2;
		while(product * prime <= 1000000)		
		{
			if(Problem035.isPrime(prime))
			{
				product *= prime;
			}
			prime++;
		}
		System.out.println(product);
	}
	
	public static int GCD(int a, int b)		//returns greatest common divisor of a and b
	{
		if(b == 0)
		{
			return a;
		}
		if (a % b != 0)
   			return GCD(b, a % b);
   		else
   			return b;
	}
	
	public static ArrayList<Integer> relativePrimes(int n)		//returns ArrayList<Integer> of all relative primes of n
	{
		ArrayList<Integer> relativePrimes = new ArrayList<Integer>();
		for(int i = 1; i < n; i++)
		{
			if(GCD(n, i) == 1)
			{
				relativePrimes.add(i);
			}
		}
		return relativePrimes;
	}
}
