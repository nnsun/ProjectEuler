//Project Euler Problem 27
//Solved on 10/8/2015
public class Problem027
{
	public static void main(String[] args)
	{
		int mostConsecutive = 0;	//counter for most consecutive primes
		int mostConsecutiveProduct = 0;		//stores product of a and b for quadratic with most consecutive primes
		for(int a = -999; a < 1000; a++)	//loops through a
		{
			for(int b = -999; b < 1000; b++)	//loops through b
			{
				int consecutive = 0;	//most consecutive primes for current quadratic
				for(int n = 0; true; n++)	//loops through n 
				{
					int output = n * n + a * n + b;
					if(Problem035.isPrime(output))		//checks if output is prime, increments consecutive if it is
					{
						consecutive++;
					}
					else
					{
						if(consecutive > mostConsecutive)	//if current quadratic has more consecutive primes than previous max
						{
							mostConsecutive = consecutive;
							mostConsecutiveProduct = a * b;
						}
						break;
					}
				}
			}
		}
		System.out.println(mostConsecutiveProduct);
	}
}
