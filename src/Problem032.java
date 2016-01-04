import java.util.ArrayList;
import java.util.Arrays;

//Project Euler Problem 32
//Solved on 1/3/2016
public class Problem032
{
	public static void main(String[] args)
	{
		int sum = 0;		//total sum of valid products
		char[] pandigital = "123456789".toCharArray();		//array of pandigital sequence used for comparison
		ArrayList<Integer> solutions = new ArrayList<Integer>();		//holds product solutions
		for(int a = 2; a <= 98765; a++)		//loop through multiplicands
		{
			for(int b = 123; a * b <= 98765; b++)		//loop through multipliers
			{
				int c = a * b;		//assign product
				char[] combination = (Integer.toString(a) + Integer.toString(b) + Integer.toString(c)).toCharArray();	//char array of fact family
				Arrays.sort(combination);		//sort the array
				if(Arrays.equals(combination, pandigital))		//compare contents of pandigital array and fact family array
				{
					if(solutions.size() != 0)		//if solution's size isn't zero...
					{
						boolean matching = false;		//check if solution already exists
						for(int i = 0; i < solutions.size(); i++)
						{
							if(solutions.get(i) == c)
							{
								matching = true;
							}
						}
						if(!matching)		//add product to array list and sum
						{
							solutions.add(c);
							sum += c;
						}
					}
					else		//add product to array list and sum
					{
						solutions.add(c);
						sum += c;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
