import java.math.BigInteger;

//Project Euler Problem 97
//Solved on 12/29/2015
public class Problem097
{
	public static void main(String[] args)
	{
		//(28433 * 2^7830457)+1
		long modulus = 10000000000L;		//used to find last 10 digits
		int multiplicand = 28433;			
		BigInteger base = new BigInteger("2");
		BigInteger power = base.pow(7830457);
		BigInteger last10 = new BigInteger(Integer.toString(multiplicand)).multiply(power);
		last10 = last10.add(new BigInteger("1"));
		last10 = last10.mod(new BigInteger(Long.toString(modulus)));		//modulus final result to find last ten digits
		System.out.println(last10);
	}
}
