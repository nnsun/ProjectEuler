import java.math.BigInteger;
import java.util.ArrayList;

//Project Euler Problem 29
//Solved on 10/7/2015
public class Problem29
{
	public static void main(String[] args)
	{
		ArrayList<BigInteger> uniques = new ArrayList<BigInteger>();	//ArrayList to store all unique powers
		for(int a = 2; a <= 100; a++)	//loops through all values for a and b
		{
			for(int b = 2; b <= 100; b++)
			{
				BigInteger base = new BigInteger(Integer.toString(a));	//since many powers are too big for long, BigInteger is used
				BigInteger power = new BigInteger(base.pow(b).toString());	//BigInteger result of a raised to the b power
				if(!uniques.contains(power))	//if answer isn't in the ArrayList, add it
				{
					uniques.add(power);
				}
			}
		}
		System.out.println(uniques.size());		//print number of elements in the ArrayList
	}
}
