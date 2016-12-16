import java.math.BigInteger;

// Project Euler problem 15
// Solved on 12/28/2014
// Easily solvable without using a program
public class Problem015
{
	public static void main(String[] args)
	{
		BigInteger paths = factorial(40).divide(factorial(20).multiply(factorial (40 - 20)));	// paths is equal to 40 C 20
		System.out.println(paths);
	}
	
	public static BigInteger factorial(int n)	// returns BigInteger representation of n!
	{
		if(n == 0)
		{
			return new BigInteger("1");
		}
		BigInteger factorial = new BigInteger("1");
		for(int i = n; i != 1; i--)
		{
			BigInteger temp = new BigInteger(Integer.toString(i));
			factorial = factorial.multiply(temp);
		}
		return factorial;
	}
}
