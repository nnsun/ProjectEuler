import java.math.BigInteger;

//Project Euler Problem 57
//Solved on 11/26/2015
public class Problem057
{
	public static void main(String[] args)
	{
		BigInteger num = new BigInteger("1");	//numerator
		BigInteger den = new BigInteger("1");	//denominator
		long count = 0;	//number of times numerator has more digits than numerator
		
		for(int i = 0; i < 1000; i++)	//loop through 1000 iterations
		{
			BigInteger prevNum = num;		//numerator and denominator is function of previous iteration's numerator and denominator,
			BigInteger prevDen = den;		//so those are stored here
			
			//calculating current iteration's numerator and denominators
			den = prevNum.subtract(prevDen).add(prevDen.add(prevDen));
			num = prevDen.add(den);
			
			if(prevNum.toString(10).length() > prevDen.toString(10).length())		//if numerator has more digits than denominator, increment count
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
