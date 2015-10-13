import java.util.ArrayList;
import java.util.Collections;

//Project Euler Problem 43
//Solved on 10/13/2015
public class Problem043
{
	public static void main(String[] args)
	{
		long sum = 0;
		ArrayList<String> pandigitals = new ArrayList<String>();
		pandigitals = Problem024.permute("0123456789", "", pandigitals);	//array list of all permutations of 0-9 pandigital numbers
		Collections.sort(pandigitals);		//sort pandigitals
		pandigitals.subList(0, 362880).clear();		//remove all permutations that start with 0 (total of 9! or 362880)
		for(int i = 0; i < pandigitals.size(); i++)		//loop through all remaining pandigitals to find ones that satisfy the requirement
		{
			String temp = pandigitals.get(i);
			if(Long.parseLong(temp.substring(1, 4)) % 2 == 0)
			{
				if(Long.parseLong(temp.substring(2, 5)) % 3 == 0)
				{
					if(Long.parseLong(temp.substring(3, 6)) % 5 == 0)
					{
						if(Long.parseLong(temp.substring(4, 7)) % 7 == 0)
						{
							if(Long.parseLong(temp.substring(5, 8)) % 11 == 0)
							{
								if(Long.parseLong(temp.substring(6, 9)) % 13 == 0)
								{
									if(Long.parseLong(temp.substring(7, 10)) % 17 == 0)
									{
										sum += Long.parseLong(temp);	//add pandigital that satisfies requirement to sum
									}
								}
							}
						}
					}
				}
			}
		}		
		System.out.println(sum);
	}
}
