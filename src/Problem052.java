import java.util.Arrays;

// Project Euler problem 52
// Solved on 10/14/2015
public class Problem052
{
	public static void main(String[] args)
	{
		int n = 0;
		for(int i = 10; true; i++)	// loops through numbers, 10 is lowest possible answer to problem since 6*10 has 2 digits like 10 does
		{
			// takes number times 1, 2, 3, 4, 5, and 6 and creates a char array of their digits, then sorts them numerically
			char[] times1 = Integer.toString(i).toCharArray();
			Arrays.sort(times1);
			char[] times2 = Integer.toString(2*i).toCharArray();
			Arrays.sort(times2);
			char[] times3 = Integer.toString(3*i).toCharArray();
			Arrays.sort(times3);
			char[] times4 = Integer.toString(4*i).toCharArray();
			Arrays.sort(times4);
			char[] times5 = Integer.toString(5*i).toCharArray();
			Arrays.sort(times5);
			char[] times6 = Integer.toString(6*i).toCharArray();
			Arrays.sort(times6);
			
			// the sorted arrays should then all be equal in order to be an answer to the problem
			if(Arrays.equals(times1, times2) && Arrays.equals(times1, times3) && Arrays.equals(times1, times4)
					&& Arrays.equals(times1, times5) && Arrays.equals(times1, times6))
			{
				n = i;
				break;
			}
				
		}
		System.out.println(n);
	}
}
