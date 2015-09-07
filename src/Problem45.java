//Project Euler Problem 45
public class Problem45
{
	public static void main(String[] args)
	{
		long n = 0;
		long j = 0;
		long k = 0;
		long temp;
		for(long i = 286; i >= 0; i++)
		{
			n = i * (i+1) / 2;
			
			j = (long) ((1 + Math.sqrt(1 + 4 * 3 * 2 * n)) / 6);
			if(n == j * (3 * j - 1) / 2)
			{
				k = (long) ((1 + Math.sqrt(1 + 4 * 2 * n)) / 4);
				if(n == k * (2 * k - 1))
				{
					break;
				}
			}
		}
		
		System.out.println(n);
		System.out.println(j);
		System.out.println(k);
	}
}
