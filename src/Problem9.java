//Project Euler Problem 9
public class Problem9
{
	public static void main (String[] args) throws java.lang.Exception
	{
		for(int i = 0; i < 400; i++)
		{
			for(int j = 0; j < 400; j++)
			{
				double k = Math.sqrt(i*i + j*j);
				if(i+j+k == 1000)
				{
					System.out.println("i = " + i + "\nj = " + j + "\nk = " + k);
					int product = i*j*(int)k;
					System.out.println("Product: " + product);
				}
			}
		}
	}
}