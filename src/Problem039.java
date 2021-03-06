import java.util.ArrayList;
import java.util.Arrays;

// Project Euler problem 39
// Solved on 1/3/2016
public class Problem039
{
	public static void main(String[] args)
	{
		int p = 3;		// index variable to loop through all possible p values
		int[] max = {p, 0};		// max[0] stores p with most solutions, max[1] stores max number of solutions
		while(p <= 1000)		// loop through p values
		{
			ArrayList<int[]> triples = new ArrayList<int[]>();		// holds 3-element arrays containing side lengths for solutions
			int solutions = 0;		// number of solutions for this current p value
			for(int a = 1; a < p; a++)		// loop through possible a values
			{
				for(int b = 1; b < p; b++)		// loop through possible b values
				{
					int c = (int)Math.sqrt(a*a + b*b);		// finds c
					if(a+b+c == p && a*a + b*b == c*c)		// checks if c is a valid value for right triangle
					{
						int[] triple = {a, b, c};		// creates the triple for this specific solution
						Arrays.sort(triple);
						if(triples.size() != 0)		// if there are already solutions for this p...
						{
							boolean matching = false;		// keeps track if triple has already been created
							for(int i = 0; i < triples.size(); i++)		
							{
								if(Arrays.equals(triples.get(i), triple))		
								{
									matching = true;
									break;
								}
							}
							if(!matching)		// if triple has not been added, add triples to collection and increment solutions for this p
							{
								triples.add(triple);
								solutions++;
							}
						}
						else		// if there are no current solutions for this p...
						{
							triples.add(triple);
							solutions++;
						}
					}
				}
			}
			if(solutions > max[1])		// if this p has more solutions than the previous max, update max
			{
				max[0] = p;
				max[1] = solutions;
			}
			p++;
		}
		
		System.out.println(max[0]);
	}
}
