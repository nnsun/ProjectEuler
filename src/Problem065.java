import java.math.BigInteger;

//Project Euler Problem 65
//Solved on 11/28/2015
public class Problem065
{
	public static void main(String[] args)
	{
		int sum = 0;	//sum of numerator digits
		
		BigInteger num = new BigInteger("0");	//numerator
		BigInteger den = new BigInteger("1");	//denominator
		
		int k = 1;		//index in sequence e = [2; 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8...]
		int[] seq = new int[100];		//sequence
		for(int i = 0; i < 100; i++)	//generating elements in sequence
		{
			if(i == 1)
			{
				seq[i] = 2;
			}
			else if(i % 3 == 0)
			{
				seq[i] = 2 * k;
				k++;
			}
			else
			{
				seq[i] = 1;
			}
		}
		
		for(int i = seq.length-1; i >= 0; i--)		//computing fraction value
		{
			num = num.add(new BigInteger(Integer.toString(seq[i])).multiply(den));
			BigInteger temp = num;
			num = den;
			den = temp;
		}
		
		num = num.add(den.add(den));	//add 2 to the fracation
		
		for(int i = 0; i < num.toString(10).length(); i++)		//sum up the numerator's digits
		{
			sum += Integer.parseInt(Character.toString(num.toString(10).charAt(i)));
		}
		System.out.println(sum);
	}
}
