import java.util.ArrayList;

//Project Euler Problem 10
public class Problem10
{
	public static void main (String[] args) throws java.lang.Exception
	{
		long sum = 0l;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		for (int i = 2; i < 2000000; i++)
		{
			for (int o = 2; o < Math.sqrt(i); o++)
			{
				if(i % o == 0)
				{
					break;
				}
				if(o == (int)(Math.sqrt(i)) && o*o != i)
				{
					primes.add(i);
				}
			}
		}
		
		for(int i = 0; i < primes.size(); i++)
		{
			sum += (int)primes.get(i);
		}
		System.out.println(sum);
	}
}