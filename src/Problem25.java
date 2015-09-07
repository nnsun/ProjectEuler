import java.math.BigInteger;

//Project Euler Problem 25
public class Problem25
{
	public static void main(String[] args)
	{
		BigInteger term = new BigInteger("1");
		BigInteger temp = new BigInteger("1");
		int n = 2;
		for(int digits = 1; digits <= 1000; digits = term.toString().length())
		{
			if(digits == 1000)
			{
				System.out.println(n);
				break;
			}
			term = term.add(temp);
			temp = term.subtract(temp);
			n++;
		}
	}
}
