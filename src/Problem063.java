import java.math.BigInteger;

//Project Euler Problem 63
//Solved on 11/30/2015
public class Problem063
{
	public static void main(String[] args)
	{
		int power = 1;		//power of the exponent being calculated
		int base = 1;		//base
		int count = 0;		//number of n-digit positive integers that are also nth power
		BigInteger n = (new BigInteger(Integer.toString(base)).pow(power));			//exponent result
		
		parse:
		while(true)
		{
			n = (new BigInteger(Integer.toString(base)).pow(power));

			if(n.toString().length() == power)		//if exponent has same number of digits as the power
			{
				count++;
				base++;
			}
			else if(n.toString().length() > power)		//if exponent has more digits than power
			{
				power++;
				base = 1;
			}
			else		//else (if exponent has less digits than power)
			{
				//if base equals 10, than number of digits in n has to be more than power.
				if(base >= 9)
				{
					break parse;
				}
				base++;
			}
		}
		System.out.println(count++);
	}
}
