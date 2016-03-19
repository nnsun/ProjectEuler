//Project Euler Problem 40
//Solved on 9/29/2015
public class Problem040
{
	public static void main(String[] args)
	{
		int d = 0;		//the total number of digits in the constant
		int num = 1;	//the number being appended to the end of the constant
		int product = 1;	//stores the product of the digits in the specified positions
		while (d < 1000000)		//while loop that goes through one million digits appended
		{
			int length = Integer.toString(num).length();	//number of digits of number being appended
			d += length;	//increases the digit count
			for(int i = 0; i <= 6; i++)		//loops through and checks for digits in specified positions
			{
				if (d - length < Math.pow(10, i) && d >= Math.pow(10, i))	//if the number being checked has a digit in one of the specified positions...
				{
					char[] temp = Integer.toString(num).toCharArray();	//creates character array holding each digit
					int difference = (int)(d - Math.pow(10, i));		//used to find which digit in the number falls on the specified position
					int multiplier = Integer.parseInt(Character.toString(temp[length - 1 - difference]));	//takes the digit that falls on the 
																											//specified position
					product *= multiplier;		//multiples the digit found
				}
			}
			num++;	//increments to the next sequential number
		}
		
		System.out.println(product);
	}
}
