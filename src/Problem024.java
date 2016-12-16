import java.util.ArrayList;
import java.util.Collections;

// Project Euler problem 24
// Solved on 10/13/2015
public class Problem024
{
	public static void main(String[] args)
	{
		ArrayList<String> permutations = new ArrayList<String>();	// ArrayList to hold all possible permutations
		permutations = permute("0123456789", "", permutations);
		Collections.sort(permutations);		// sorts ArrayList
		System.out.println(permutations.get(1000000 - 1));		// prints one millionth element of sorted ArrayList
	}
	
	// returns ArrayList of all possible combinations of characters in str; temp and permutations should both be empty at initial call
	public static ArrayList<String> permute(String str, String temp, ArrayList<String> permutations)	
	{
	    int n = str.length();
	    if (n == 0)		// if all characters have been used up to build a permutation, add it to the ArrayList
	    {
	    	permutations.add(temp);
	    }
	    else 
	    {
	        for (int i = 0; i < n; i++)
	        {
	        	// recursive call to continue building the String permutation
	            permute(str.substring(0, i) + str.substring(i+1, n), temp + str.charAt(i), permutations);
	        }
	    }
        return permutations;
	}
}