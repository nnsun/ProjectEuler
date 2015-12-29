//Project Euler Problem 92
//Solved on 12/29/2015
public class Problem092
{
	public static void main(String[] args)
	{
		int total = 0;
		for(int i = 1; i < 10000000; i++)		//loop through all numbers
		{
			int tempSum = digitSquaresSum(i);		//find the initial sum of digit squares
			while(tempSum != 1 && tempSum != 89)		//keep going until the sum equals 1 or 89
			{
				tempSum = digitSquaresSum(tempSum);			
			}
			if(tempSum == 89)		//if the sum equals 89, increment the total
			{
				total++;
			}
		}
		System.out.println(total);
	}
	
	public static int digitSquaresSum(int n)		//returns sum of the square of each digit in n
	{
		int total = 0;
		char[] charArray = Integer.toString(n).toCharArray();		//create an character array consisting of digits in n
		for(int i = 0; i < charArray.length; i++)			//loop through the elements of the array
		{
			total += Math.pow(Integer.parseInt(Character.toString(charArray[i])), 2);		//add the squares of each digit to the total
		}
		return total;
	}
}
