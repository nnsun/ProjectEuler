//Project Euler Problem 3
public class Problem003
{
	public static void main(String[] args)
	{
		long number = 600851475143l;
		int largestFactor = 1;
		long temp = number;

		for(int i = 2; i < Math.sqrt(number); i++)
		{
			if(temp % i == 0)
			{
				temp /= i;
				largestFactor = i;
				i--;
			}
		}
		System.out.println(largestFactor);
	}
}
