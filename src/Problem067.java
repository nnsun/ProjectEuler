import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// Project Euler problem 67
// Solved on 9/27/2015
public class Problem067
{
	public static void main(String[] args)
	{
		ArrayList<String> lineList = new ArrayList<String>();	// ArrayList for String representations of each line
		Path path = Paths.get("src/Files/p067_triangle.txt");	// Path to text file
		try
		{
			for(String line : Files.readAllLines(path))		// populates ArrayList with lines
			{
				lineList.add(line);	
			}
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		int numberOfLines = lineList.size();	// number of rows in the triangle
		int[][] numberList = new int[100][];	// array that will contain the numerical values of the triangle
		
		// populates the array with numerical values. Array has 100 rows and the number of columns in each row equals the row number
		for(int i = 0; i < numberOfLines; i++)	
		{
			numberList[i] = new int[i + 1];
			int digit = 0;
			for(int j = 0; j < lineList.get(i).length() + 1; j++)
			{
				switch (j % 3)
				{
					case 0:		// the first digit in each number in the triangle appears every three characters starting at the zeroth element
						digit = 10 * Integer.parseInt(Character.toString(lineList.get(i).charAt(j)));
						break;
					case 1:		// the second digit in each number in the triangle appears every three characters starting at the 
								// first element (zero-based numbering)
						digit += Integer.parseInt(Character.toString(lineList.get(i).charAt(j)));
						break;
					case 2:		// every 3 characters starting at the 2nd element (with zero-based numbering) is a space
						numberList[i][(j-2)/3] = digit;
						digit = 0;
						break;
				}
				
			}
			
		}
		/*	A quick way of getting the largest sum: take the last row, and for each element in it (except the last one),
		 * 	take its neighbor and check to see which is bigger. 
		 * 	Add the bigger value to the element in the row directly above. 
		 * 	Repeat until you finish the first row (numberList[1]). The resulting value in the zeroth row (numberList[0])
		 *	is the largest possible sum. 
		 */ 
		for(int i = numberOfLines; i > 1; i--)
		{
			for(int j = 0; j < numberList[i - 2].length; j++)
			{
				numberList[i - 2][j] += (numberList[i - 1][j] > numberList[i - 1][j + 1]) ? numberList[i - 1][j] : numberList[i - 1][j + 1];
			}
		}
		System.out.println(numberList[0][0]);
	}
}
