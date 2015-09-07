import java.util.ArrayList;

//Project Euler Problem 26
public class Problem26
{
	public static void main(String[] args)
	{
		int longestCycle = 0;
		int d = 0;
		for(int i = 2; i < 1000; i++)
		{
			int cycle = 0;
			ArrayList<Integer> remainderList = new ArrayList<Integer>();
			int remainder = 10 % i;
			remainderList.add(remainder);
			do
			{
				remainder = remainder * 10 % i;
				remainderList.add(remainder);
			}
			while(remainderList.indexOf(remainder) == remainderList.lastIndexOf(remainder));
			
			if(remainderList.indexOf(remainder) != remainderList.lastIndexOf(remainder))
			{
				cycle = remainderList.lastIndexOf(remainder) - remainderList.indexOf(remainder);
			}
			
			if(cycle > longestCycle)
			{
				longestCycle = cycle;
				d = i;
			}
		}
		System.out.println(d);
	}
}
