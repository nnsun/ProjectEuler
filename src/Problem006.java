// Project Euler problem 6
// Solved on 12/28/2014
public class Problem006
{
	public static void main(String[] args)
	{
		int sumSquared = 0;
		int squareSummed = 0;
		for(int i = 1; i < 101; i++)
		{
			sumSquared += i;
			squareSummed += i*i;
		}
		sumSquared *= sumSquared;
		System.out.println(sumSquared - squareSummed);
	}
}
