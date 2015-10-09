//Project Euler Problem 34
//Solved on 10/8/2015
public class Problem034
{
	public static void main(String[] args)
	{
		int upperBound = 2540160;	//obtained by finding highest possible value that x * 9! could possibly equal x, where x is the number of digits.
		int sum = 0;
		for(int i = 3; i <= upperBound; i++)	//parse through numbers between 3 (the smallest allowable number) and the upper bound
		{
			int factorialSum = 0;
			char[] digits = Integer.toString(i).toCharArray();	//creates a char array containing the digits
			
			for(int j = 0; j < digits.length; j++)	//loops through char array and takes sum of digit factorials
			{
				int factorial = 1;
				for(int k = Integer.parseInt(Character.toString(digits[j])); k > 1; k--)	//finds the factorial of each digit
				{
					factorial *= k;
				}
				factorialSum += factorial;
			}

			if(factorialSum == i)	//checks if sum matches the original number
			{
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
