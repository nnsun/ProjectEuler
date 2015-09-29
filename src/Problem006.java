//Project Euler Problem 6
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
