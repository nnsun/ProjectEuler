//Project Euler Problem 7
public class Problem7
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int prime = 13;
		int counter = 6;
		
		for (int i = 14; counter < 10001; i++)
		{
			for (int o = 2; o < Math.sqrt(i); o++)
			{
				if(i % o == 0)
				{
					break;
				}
				if(o == (int)(Math.sqrt(i)) && o*o != i)
				{
					prime = i;
					counter++;
					if(counter > 10000)
						System.out.println(counter + "\t" + prime);
				}
			}
		}
	}
}