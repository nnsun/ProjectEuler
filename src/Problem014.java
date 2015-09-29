//Project Euler Problem 14
public class Problem014
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int largest = 10;
		int chain = 0;
		int n = 13;
		for(long i = 13; i < 1000000; i++)
		{
			long temp = i;
			while(temp != 1)
			{
				if(temp % 2 == 0)
					temp /= 2;
				else
					temp = 3*temp + 1;
				chain++;
			}
			if(chain > largest)
			{
				largest = chain;
				if(i > n)
					n = (int)i;
			}
			chain = 0;
		}
		System.out.println(n);
	}
}