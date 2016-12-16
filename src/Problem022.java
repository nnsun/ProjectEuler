import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

// Project Euler problem 22
// Solved on 10/3/2015
public class Problem022
{
	public static void main(String[] args)
	{
		ArrayList<String> textArrayList = new ArrayList<String>();	// stores all text in ArrayList
		Path path = Paths.get("src/Files/p022_names.txt");	// Path to text file
		try
		{
			for(String line : Files.readAllLines(path))		// populates ArrayList with lines
			{
				textArrayList.add(line);	
			}
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		String text = textArrayList.get(0);		// converts text to a single String
		String[] names = text.split(",");		// splits text by commas and stores names into a String array
		Arrays.sort(names);		// sorts all the names alphabetically
		int totalScore = 0;		
		for(int i = 0; i < names.length; i++)	// cycles through each name
		{
			int alphaScore = 0;		// the total score from adding up the scores for each letter in each name
			int nameScore = i + 1;	// the score multiplier from alphabetical position in the list
			char[] temp = names[i].toCharArray();	// converts name String into a character array
			for(int j = 0; j < temp.length; j++)	// cycles through each character in the array
			{
				if(temp[j] != '\"')		// makes sure that each character used is a letter and not a quotation mark
				{
					int charCode = (int)temp[j];	// gets the Unicode for each letter
					alphaScore += (charCode - 64);		// subtracts 64 from the Unicode (capital letters start at 65)
														// and adds it to the letter score
				}
			}
			nameScore *= alphaScore;	// multiplies the score multiplier with the final letter score for the name
			totalScore += nameScore;	// adds the score for the name to the total score
		}
		System.out.println(totalScore);
	}
}
