import java.math.BigInteger;

//Project Euler Problem 16
public class Problem016
{
	public static void main(String[] args)
	{
		long pow2_50l = (long)Math.pow(2,50);
		BigInteger pow2_50 = new BigInteger(Long.toString(pow2_50l));
		BigInteger pow2_1000 = pow2_50.pow(20);
		String resultStr = pow2_1000.toString();
		int[] resultArray = new int[resultStr.length()];
		for(int i = 0; i < resultStr.length(); i++)
		{
			resultArray[i] = Integer.parseInt(Character.toString(resultStr.charAt(i)));
		}
		
		int sum = 0;
		for(int i = 0; i < resultArray.length; i++)
		{
			sum += resultArray[i];
		}
		System.out.println(sum);
	}
}