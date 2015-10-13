import java.util.ArrayList;
import java.util.Collections;

//Project Euler Problem 41
//Solved on 10/13/2015
public class Problem041
{
	public static void main(String[] args)
	{
		int largest = 0;
		ArrayList<String> pandigital = new ArrayList<String>();
		largest = largestPrime(Problem024.permute("123456789", "", pandigital));	//goes through possible n-digit pandigitals
		if(largest == 0)
		{
			largest = largestPrime(Problem024.permute("12345678", "", pandigital));
			if(largest == 0)
			{
				largest = largestPrime(Problem024.permute("1234567", "", pandigital));
				if(largest == 0)
				{
					largest = largestPrime(Problem024.permute("123456", "", pandigital));
					if(largest == 0)
					{
						largest = largestPrime(Problem024.permute("12345", "", pandigital));
						if(largest == 0)
						{
							//stops here because example in problem description is a 4-digit number
							largest = largestPrime(Problem024.permute("1234", "", pandigital));	
						}
					}
				}
			}
		}
		System.out.println(largest);
	}
	
	public static int largestPrime(ArrayList<String> list)		//returns largest prime, as int, in array list containing unparsed ints as strings
	{
		int largest = 0;
		Collections.sort(list);		//sorts list so as index increases value of integer also increases
		for(int i = 0; i < list.size(); i++)
		{
			if(Problem035.isPrime(Integer.parseInt(list.get(i))))	//if the parsed int is prime...
			{
				largest = Integer.parseInt(list.get(i));
			}
		}
		return largest;
	}
}
