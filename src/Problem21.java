//Project Euler Probem 21
public class Problem21
{
	public static void main(String[] args)
	{
		
	}
	
	public int factorSum(int n)
	{
		int sum = 0;
		for(int i = 1; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				sum += i;
			}
		}
	}
}
