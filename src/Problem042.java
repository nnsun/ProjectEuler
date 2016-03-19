import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//Project Euler Problem 42
//Solved on 9/29/2015
public class Problem042
{
	public static void main(String[] args) throws IOException
	{
		Path path = Paths.get("src/Files/p042_words.txt");	//assigns path of text file
		ArrayList<String> text = new ArrayList<String>();	//holds the text of the file
		for(String line : Files.readAllLines(path))		//populates ArrayList with the text
		{
			text.add(line);
		}
		
		String[] words = text.get(0).split(",");	//creates a String array that holds the words
		int[] values = new int[words.length];		//contains word values of each word
		for(int i = 0; i < words.length; i++)		//cycles through each word
		{
			int wordValue = 0;
			char[] characters = words[i].toCharArray();		//cycles through each character in the word
			for(int j = 0; j < characters.length; j++)
			{
				if(characters[j] != '\"')
				{
					wordValue += (int)characters[j] - 64;	//takes the Unicode for the character and subtracts 64 (since 'A' has a value of 65)
				}
			}
			values[i] = wordValue;
		}
		
		int count = 0;
		
		//word is triangular if the the truncated square root of its value * the truncated square root plus 1 is twice the value
		for(int i = 0; i < values.length; i++)
		{
			if( 2 * values[i] == (int)Math.sqrt(2 * values[i]) * (int)((Math.sqrt(2 * values[i]) + 1)))
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
