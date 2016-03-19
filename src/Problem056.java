import java.math.BigInteger;

//Project Euler Problem 56
//Solved on 1/17/2015
public class Problem056
{	
	public static void main(String[] args)
	{
		int maxSum = 0;
		int sum = 0;
		for(int i = 1; i < 100; i++)
		{
			BigInteger a = new BigInteger(Integer.toString(i));
			for(int j = 1; j < 100; j++)
			{
				sum = 0;
				BigInteger temp = a.pow(j);
				
				char[] charArray = temp.toString().toCharArray();
				for(int k = 0; k < charArray.length; k++)
				{
					sum += Integer.parseInt(Character.toString(charArray[k]));
				}
				
				if(sum > maxSum)
					maxSum = sum;
			}
		}
		
		System.out.println(maxSum);
	}
}
