import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

//Project Euler Problem 59
//Solved on 9/29/2015
public class Problem059
{
	//the solution involves brute forcing the possible keys until a decryption with coherent words is found.
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> text = new ArrayList<String>();		
		Path path = Paths.get("src/Files/p059_cipher.txt");		//path to find the cipher text file
		for(String line : Files.readAllLines(path))		//stores the text all in an ArrayList as a String
		{
			text.add(line);
		}
		
		String[] encryptedString = text.get(0).split(",");		//puts all the raw text in a String array with each element being a number
		int[] encrypted = new int[encryptedString.length];
		for(int i = 0; i < encrypted.length; i++)		//takes encryptedString and parses it into ints, which are stored into encrypted
		{
			encrypted[i] = Integer.parseInt(encryptedString[i]);
		}
		
		String[] commonWords = {"the", "be", "to", "of", "and", "in", "that", "have", "it"};	//list of the most common English words
		int maxScore = 0;	//stores the highest occurrences of common English words out of all decryption keys
		int[] bestCipher = new int[3];	//an int array containing the three numbers that make up the best cipher
		int count = 0;		//helper variable to cycle through the cipher keys
		int score = 0;		//the temporary score of the current decryption key set
		
		//next three for-loops cycle through all possible cipher key combinations
		for(int x = 97; x < 123; x++)
		{
			for(int y = 97; y < 123; y++)
			{
				for(int z = 97; z < 123; z++)	
				{
					int[] cipher = {x, y, z};
					char[] decrypted = new char[encrypted.length];
					
					//cycles through the cipher keys and performs an XOR on each corresponding character and its cipher
					for(int i = 0; i < encrypted.length; i++)	
					{
						if(count == 3)	
						{
							count = 0;
						}
						decrypted[i] = (char)(encrypted[i] ^ cipher[count]);
						count++;
					}
					String decryptedString = Arrays.toString(decrypted);	//output string resulting from the decryption
					
					//removes leading left bracket and trailing right bracket
					decryptedString = decryptedString.replace(Character.toString(decryptedString.charAt(0)), "");
					decryptedString = decryptedString.replace(Character.toString(decryptedString.charAt(decryptedString.length() - 1)), "");
					
					//removes the comma + space combination that separates each character in the output string
					for(int i = 0; i < decryptedString.length() - 1; i++)
					{
						if(decryptedString.charAt(i) == ',' && decryptedString.charAt(i + 1) == ' ')
						{
							decryptedString = decryptedString.replace(Character.toString(decryptedString.charAt(i)), "");
							decryptedString = decryptedString.replace(Character.toString(decryptedString.charAt(i)), "");
						}
					}
					
					for(int i = 0; i < commonWords.length; i++)		//searches the output string for the common words
					{
						if(decryptedString.toLowerCase().contains(commonWords[i]))
						{
							score++;
						}
					}
					if(score > maxScore)	//if a string contains more than the previous max amount of common words
					{
						maxScore = score;
						bestCipher[0] = x;
						bestCipher[1] = y;
						bestCipher[2] = z;
					}
					
					score = 0;
					count = 0;
				}
			}
		}
		count = 0;
		int sum = 0;
		
		//takes the best cipher and uses it to decrypt the message and add the sum of the character values together
		for(int i = 0; i < encrypted.length; i++)
		{
			if(count == 3)
			{
				count = 0;
			}
			sum += encrypted[i] ^ bestCipher[count];
			count++;
		}
		System.out.println(sum);
	}
}
