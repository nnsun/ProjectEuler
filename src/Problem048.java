import java.math.BigInteger;

//Project Euler Problem 48
public class Problem048
{
	public static void main(String[] args)
	{
		BigInteger sum = new BigInteger("0");
		
		for(int i = 1; i <= 1000; i++)
		{
			BigInteger temp = BigInteger.valueOf(i);
			sum = sum.add(temp.pow(i));
		}
		System.out.println(sum);
	}
}
