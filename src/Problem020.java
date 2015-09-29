import java.math.BigInteger;

//Project Euler Problem 20
public class Problem020
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] numbers = new int[100];
		for(int i = 1; i < numbers.length + 1; i++)
		{
			numbers[i - 1] = i;
		}
		
		BigInteger product = new BigInteger("1");
		for(int i = 0; i < numbers.length; i++)
		{
			String tempStr = Integer.toString(numbers[i]);
			BigInteger temp = new BigInteger(tempStr);
			product = product.multiply(temp);
		}
		String productStr = product.toString();
		String[] productStrArray = productStr.split("(?!^)");
		int[] productArray = new int[productStrArray.length];
		for(int i = 0; i < productStrArray.length; i++)
		{
			productArray[i] = Integer.parseInt(productStrArray[i]);
		}
		int sum = 0;
		for(int i = 0; i < productArray.length; i++)
		{
			sum += productArray[i];
		}		
		System.out.println(sum);
		
	}
}