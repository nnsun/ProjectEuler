//Project Euler Problem 12
public class Problem012
{
	public static void main(String[] args)
	{
		int triangleNumber = 1;
		int divisors = 0;
		int n = 1;
		int count = 1;
		
		while(divisors <= 500)
		{
			count++;
			divisors = 0;
			triangleNumber += count;
			for(int i = 1; i <= Math.sqrt(triangleNumber); i++)
			{
				if(triangleNumber % i == 0)
					divisors++;
			}
			divisors *= 2;
			if((int)Math.sqrt(triangleNumber) * (int)Math.sqrt(triangleNumber) == triangleNumber)
				divisors--;
			if(divisors > 500)
			{
				n = triangleNumber;
			}
		}
		System.out.println(n);
	}
}
