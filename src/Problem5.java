//Project Euler Problem 5
//Easily solvable without using a program
public class Problem5
{
	public static void main(String[] args)
	{
		int product10 = 2520;	//smallest number divisible by numbers 1-10
		int product = product10;	//smallest number divisible by numbers 1-20
		int[] primes = {11, 13, 17, 19};
		for(int i = 0; i < primes.length; i++)
		{
			product *= primes[i];
		}
		product *= 2;	//multiply by an extra 2 to account for 16 being 2^4
		
		System.out.println(product);
	}
}
