//Project Euler Problem 21
public class Problem021
{
	public static void main(String[] args)
	{
		int sum = 0;
		for(int i = 0; i < 10000; i++)
		{
			if(i == factorSum(factorSum(i)) && i != factorSum(i))
			{
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	public static int factorSum(int n)		//returns sum of factors of n (not including n itself)
	{
		int sum = 0;
		for(int i = 1; i <= n/2; i++)
		{
			if(n % i == 0)
			{
				sum += i;
			}
		}
		return sum;
	}
}
