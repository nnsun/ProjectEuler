//Project Euler Problem 2
public class Problem002
{
	public static void main(String[] args)
	{
		int sum = 0;
		int term;
		int temp = 1;
		for(term = 1; term < 4000000; term += temp)
		{
			if(term % 2 == 0)
				sum += term;
			temp = term - temp;
		}
		System.out.println(sum);
	}
}
