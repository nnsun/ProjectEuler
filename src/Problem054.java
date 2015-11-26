import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Project Euler Problem 54
//Solved on 11/26/2015
//Implementation could've been simpler but I wanted to get some experience with using Maps in Java.
public class Problem054
{
	public static void main(String[] args) throws IOException
	{
		String[] hands = new String[1000];		//holds all hands in the file
		Path path = Paths.get("src/Files/p054_poker.txt");
		int index = 0;
		for(String line : Files.readAllLines(path))		//reads all hands and puts them in an array with one hand for each line
		{
			hands[index] = line;
			index++;
		}
		
		int wins = 0;		//number of wins for player 1
		for(int i = 0; i < hands.length; i++)		//goes through each hand
		{
			String player1Str = hands[i].substring(0, 14);		//splits up the hand by player
			String player2Str = hands[i].substring(15);
			String[] player1 = player1Str.split(" ");		//splits the cards up and puts them into a string array
			String[] player2 = player2Str.split(" ");
			
			int player1Score = 0;	//scores for each player
			int player2Score = 0;

			Map<String, Integer> player1Suits = new HashMap<String, Integer>();		//creates a hash map for suits for both players
			Map<String, Integer> player2Suits = new HashMap<String, Integer>();
			player1Suits.put("Hearts", 0);
			player1Suits.put("Diamonds", 0);
			player1Suits.put("Clubs", 0);
			player1Suits.put("Spades", 0);
			player2Suits.put("Hearts", 0);
			player2Suits.put("Diamonds", 0);
			player2Suits.put("Clubs", 0);
			player2Suits.put("Spades", 0);
			
			Map<Integer, Integer> player1Numbers = new LinkedHashMap<Integer, Integer>();	//linked hash map for card numbers for both players
			Map<Integer, Integer> player2Numbers = new LinkedHashMap<Integer, Integer>();
			player1Numbers.put(2, 0);
			player1Numbers.put(3, 0);
			player1Numbers.put(4, 0);
			player1Numbers.put(5, 0);
			player1Numbers.put(6, 0);
			player1Numbers.put(7, 0);
			player1Numbers.put(8, 0);
			player1Numbers.put(9, 0);
			player1Numbers.put(10, 0);
			player1Numbers.put(11, 0);
			player1Numbers.put(12, 0);
			player1Numbers.put(13, 0);
			player1Numbers.put(14, 0);
			player2Numbers.put(2, 0);
			player2Numbers.put(3, 0);
			player2Numbers.put(4, 0);
			player2Numbers.put(5, 0);
			player2Numbers.put(6, 0);
			player2Numbers.put(7, 0);
			player2Numbers.put(8, 0);
			player2Numbers.put(9, 0);
			player2Numbers.put(10, 0);
			player2Numbers.put(11, 0);
			player2Numbers.put(12, 0);
			player2Numbers.put(13, 0);
			player2Numbers.put(14, 0);
			
			//arrays storing card numbers for each player. Was added after hash map implementations, used for high card tiebreakers
			int[] player1NumbersArray = new int[5];		
			int[] player2NumbersArray = new int[5];
			
			for(int j = 0; j < player1.length; j++)		//goes through cards for player 1
			{
				for(int k = 0; k < player1[j].length(); k++)
				{
					switch(player1[j].charAt(k))	//adds number of each suit and card number into the appropriate hash map element
					{
						case 'H':
							player1Suits.put("Hearts", player1Suits.get("Hearts") + 1);
							break;
						case 'D':
							player1Suits.put("Diamonds", player1Suits.get("Diamonds") + 1);
							break;
						case 'C':
							player1Suits.put("Clubs", player1Suits.get("Clubs") + 1);
							break;
						case 'S':
							player1Suits.put("Spades", player1Suits.get("Spades") + 1);
							break;
							
						case '2':
							player1Numbers.put(2, player1Numbers.get(2) + 1);
							player1NumbersArray[j] = 2;
							break;
						case '3':
							player1Numbers.put(3, player1Numbers.get(3) + 1);
							player1NumbersArray[j] = 3;
							break;
						case '4':
							player1Numbers.put(4, player1Numbers.get(4) + 1);
							player1NumbersArray[j] = 4;
							break;
						case '5':
							player1Numbers.put(5, player1Numbers.get(5) + 1);
							player1NumbersArray[j] = 5;
							break;
						case '6':
							player1Numbers.put(6, player1Numbers.get(6) + 1);
							player1NumbersArray[j] = 6;
							break;
						case '7':
							player1Numbers.put(7, player1Numbers.get(7) + 1);
							player1NumbersArray[j] = 7;
							break;
						case '8':
							player1Numbers.put(8, player1Numbers.get(8) + 1);
							player1NumbersArray[j] = 8;
							break;
						case '9':
							player1Numbers.put(9, player1Numbers.get(9) + 1);
							player1NumbersArray[j] = 9;
							break;
						case 'T':
							player1Numbers.put(10, player1Numbers.get(10) + 1);
							player1NumbersArray[j] = 10;
							break;
						case 'J':
							player1Numbers.put(11, player1Numbers.get(11) + 1);
							player1NumbersArray[j] = 11;
							break;
						case 'Q':
							player1Numbers.put(12, player1Numbers.get(12) + 1);
							player1NumbersArray[j] = 12;
							break;
						case 'K':
							player1Numbers.put(13, player1Numbers.get(13) + 1);
							player1NumbersArray[j] = 13;
							break;
						case 'A':
							player1Numbers.put(14, player1Numbers.get(14) + 1);
							player1NumbersArray[j] = 14;
							break;
					}
				}
			}
			for(int j = 0; j < player2.length; j++)		//same thing for player 2
			{
				for(int k = 0; k < player2[j].length(); k++)
				{
					switch(player2[j].charAt(k))
					{
						case 'H':
							player2Suits.put("Hearts", player2Suits.get("Hearts") + 1);
							break;
						case 'D':
							player2Suits.put("Diamonds", player2Suits.get("Diamonds") + 1);
							break;
						case 'C':
							player2Suits.put("Clubs", player2Suits.get("Clubs") + 1);
							break;
						case 'S':
							player2Suits.put("Spades", player2Suits.get("Spades") + 1);
							break;
						
						case '2':
							player2Numbers.put(2, player2Numbers.get(2) + 1);
							player2NumbersArray[j] = 2;
							break;
						case '3':
							player2Numbers.put(3, player2Numbers.get(3) + 1);
							player2NumbersArray[j] = 3;
							break;
						case '4':
							player2Numbers.put(4, player2Numbers.get(4) + 1);
							player2NumbersArray[j] = 4;
							break;
						case '5':
							player2Numbers.put(5, player2Numbers.get(5) + 1);
							player2NumbersArray[j] = 5;
							break;
						case '6':
							player2Numbers.put(6, player2Numbers.get(6) + 1);
							player2NumbersArray[j] = 6;
							break;
						case '7':
							player2Numbers.put(7, player2Numbers.get(7) + 1);
							player2NumbersArray[j] = 7;
							break;
						case '8':
							player2Numbers.put(8, player2Numbers.get(8) + 1);
							player2NumbersArray[j] = 8;
							break;
						case '9':
							player2Numbers.put(9, player2Numbers.get(9) + 1);
							player2NumbersArray[j] = 9;
							break;
						case 'T':
							player2Numbers.put(10, player2Numbers.get(10) + 1);
							player2NumbersArray[j] = 10;
							break;
						case 'J':
							player2Numbers.put(11, player2Numbers.get(11) + 1);
							player2NumbersArray[j] = 11;
							break;
						case 'Q':
							player2Numbers.put(12, player2Numbers.get(12) + 1);
							player2NumbersArray[j] = 12;
							break;
						case 'K':
							player2Numbers.put(13, player2Numbers.get(13) + 1);
							player2NumbersArray[j] = 13;
							break;
						case 'A':
							player2Numbers.put(14, player2Numbers.get(14) + 1);
							player2NumbersArray[j] = 14;
							break;
					}
				}
			}
			
			Arrays.sort(player1NumbersArray);		//sorts card numbers
			Arrays.sort(player2NumbersArray);
			
			boolean player1Flush = false;		//variable for whether or not player 1 has a flush
			for(String suits : player1Suits.keySet())		//goes through each key
			{
				if(player1Suits.get(suits) == 5)	//if there are five cards with same suit, it's a flush
				{
					player1Flush = true;
					break;
				}
				if(player1Suits.get(suits) < 5 && player1Suits.get(suits) != 0)
				{
					break;
				}
			}
			
			boolean player1Straight = false;	//whether there's a straight
			int player1Pair = 0;		//card number of pair, 0 if non-existent
			int[] player1TwoPair = {0, 0};		//array with card numbers of two pairs, {0, 0} if non-existent
			int player1Three = 0;		//card number of triples
			int[] player1Full = {0, 0};		//card numbers of triple and double in full house
			int player1Four = 0;		//card number of four of a kind
			int player1Lowest = 0;		//card number of the lowest card
			int player1Consecutive = 0;		//consecutive cards, variable used for determining straight
			
			for(int numbers : player1Numbers.keySet())		//checks if cards form a straight
			{	
				if(player1Consecutive == 0 && player1Numbers.get(numbers) == 1)
				{
					player1Lowest = numbers;
					player1Consecutive++;
				}
				else if(player1Consecutive > 0 && player1Numbers.get(numbers) == 1)
				{
					player1Consecutive++;
				}
				if(player1Consecutive == 5)
				{
					player1Straight = true;
					break;
				}
				if(player1Numbers.get(numbers) > 1)
				{
					break;
				}
				if(player1Consecutive > 0 && player1Consecutive != 5 && player1Numbers.get(numbers) == 0)
				{
					break;
				}
			}
			
			for(int numbers : player1Numbers.keySet())		//checks if cards form a pair, two pair, triple, full house, or four of a kind
			{
				if(player1Numbers.get(numbers) == 2)
				{
					if(player1Pair != 0)
					{
						player1TwoPair[0] = player1Pair;
						player1TwoPair[1] = numbers;
					}
					else if(player1Three != 0)
					{
						player1Full[0] = player1Three;
						player1Full[1] = numbers;
					}
					else
					{
						player1Pair = numbers;
					}
				}
				
				if(player1Numbers.get(numbers) == 3)
				{
					player1Three = numbers;
					if(player1Pair != 0)
					{
						player1Full[0] = numbers;
						player1Full[1] = player1Pair;
					}
				}
				
				if(player1Numbers.get(numbers) == 4)
				{
					player1Four = numbers;
					break;
				}
			}
			
			//assigns scores to the cards held
			if(player1Straight && player1Lowest == 10 && player1Flush)		
			{
				player1Score = 9;
			}
			else if(player1Straight && player1Flush)
			{
				player1Score = 8;
			}
			else if(player1Four != 0)
			{
				player1Score = 7;
			}
			else if(player1Full[0] != 0)
			{
				player1Score = 6;
			}
			else if(player1Flush)
			{
				player1Score = 5;
			}
			else if(player1Straight)
			{
				player1Score = 4;
			}
			else if(player1Three != 0)
			{
				player1Score = 3;
			}
			else if(player1TwoPair[0] != 0)
			{
				player1Score = 2;
			}
			else if(player1Pair != 0)
			{
				player1Score = 1;
			}
			
			//same thing, for player 2
			boolean player2Flush = false;
			for(String suits : player2Suits.keySet())
			{
				if(player2Suits.get(suits) == 5)
				{
					player2Flush = true;
					break;
				}
				if(player2Suits.get(suits) < 5 && player2Suits.get(suits) != 0)
				{
					break;
				}
			}
			
			boolean player2Straight = false;
			int player2Pair = 0;
			int[] player2TwoPair = {0, 0};
			int player2Three = 0;
			int[] player2Full = {0, 0};
			int player2Four = 0;
			int player2Lowest = 0;
			int player2Consecutive = 0;
			
			for(int numbers : player2Numbers.keySet())
			{	
				if(player2Consecutive == 0 && player2Numbers.get(numbers) == 1)
				{
					player2Lowest = numbers;
					player2Consecutive++;
				}
				else if(player2Consecutive > 0 && player2Numbers.get(numbers) == 1)
				{
					player2Consecutive++;
				}
				if(player2Consecutive == 5)
				{
					player2Straight = true;
					break;
				}
				if(player2Numbers.get(numbers) > 1)
				{
					break;
				}
				if(player2Consecutive > 0 && player2Consecutive != 5 && player2Numbers.get(numbers) == 0)
				{
					break;
				}
			}
			
			for(int numbers : player2Numbers.keySet())
			{
				if(player2Numbers.get(numbers) == 2)
				{
					if(player2Pair != 0)
					{
						player2TwoPair[0] = player2Pair;
						player2TwoPair[1] = numbers;
					}
					else if(player2Three != 0)
					{
						player2Full[0] = player2Three;
						player2Full[1] = numbers;
					}
					else
					{
						player2Pair = numbers;
					}
				}
				
				if(player2Numbers.get(numbers) == 3)
				{
					player2Three = numbers;
					if(player2Pair != 0)
					{
						player2Full[0] = numbers;
						player2Full[1] = player2Pair;
					}
				}
				
				if(player2Numbers.get(numbers) == 4)
				{
					player2Four = numbers;
					break;
				}
			}

			if(player2Straight && player2Lowest == 10 && player2Flush)
			{
				player2Score = 9;
			}
			else if(player2Straight && player2Flush)
			{
				player2Score = 8;
			}
			else if(player2Four != 0)
			{
				player2Score = 7;
			}
			else if(player2Full[0] != 0)
			{
				player2Score = 6;
			}
			else if(player2Flush)
			{
				player2Score = 5;
			}
			else if(player2Straight)
			{
				player2Score = 4;
			}
			else if(player2Three != 0)
			{
				player2Score = 3;
			}
			else if(player2TwoPair[0] != 0)
			{
				player2Score = 2;
			}
			else if(player2Pair != 0)
			{
				player2Score = 1;
			}

			if(player1Score == player2Score)	//tiebreakers
			{
				switch(player1Score)
				{	
					case 0:
					{
						for(int j = player1NumbersArray.length - 1; j >= 0; j--)
						{
							if(player1NumbersArray[j] > player2NumbersArray[j])
							{
								player1Score++;
								break;
							}
							else if(player1NumbersArray[j] < player2NumbersArray[j])
							{
								player2Score++;
								break;
							}
						}
						break;
					}
					case 1:
					{
						if(player1Pair > player2Pair)
						{
							player1Score++;
							break;
						}
						else if(player1Pair < player2Pair)
						{
							player2Score++;
							break;
						}
						else
							for(int j = player1NumbersArray.length - 1; j >= 0; j--)
							{
								if(player1NumbersArray[j] > player2NumbersArray[j])
								{
									player1Score++;
									break;
								}
								else if(player1NumbersArray[j] < player2NumbersArray[j])
								{
									player2Score++;
									break;
								}
							}
						break;
					}
					case 2:
					{
						if((player1TwoPair[0] > player2TwoPair[0] && player1TwoPair[0] > player2TwoPair[1]) || 
								player1TwoPair[1] > player2TwoPair[0] && player1TwoPair[0] > player2TwoPair[1])
						{
							player1Score++;	
							break;
						}
						else if((player2TwoPair[0] > player1TwoPair[0] && player2TwoPair[0] > player1TwoPair[1]) || 
						player2TwoPair[1] > player1TwoPair[0] && player2TwoPair[0] > player1TwoPair[1])
						{
							player2Score++;
							break;
						}
						else
							for(int j = player1NumbersArray.length - 1; j >= 0; j--)
							{
								if(player1NumbersArray[j] > player2NumbersArray[j])
								{
									player1Score++;
									break;
								}
								else if(player1NumbersArray[j] < player2NumbersArray[j])
								{
									player2Score++;
									break;
								}
							}
						break;
					}
					case 3:
					{
						if(player1Three > player2Three)
						{
							player1Score++;
							break;
						}
						else if(player1Three < player2Three)
						{
							player2Score++;
							break;
						}
						else
							for(int j = player1NumbersArray.length - 1; j >= 0; j--)
							{
								if(player1NumbersArray[j] > player2NumbersArray[j])
								{
									player1Score++;
									break;
								}
								else if(player1NumbersArray[j] < player2NumbersArray[j])
								{
									player2Score++;
									break;
								}
							}
						break;
					}
					case 4:
					{
						for(int j = player1NumbersArray.length - 1; j >= 0; j--)
						{
							if(player1NumbersArray[j] > player2NumbersArray[j])
							{
								player1Score++;
								break;
							}
							else if(player1NumbersArray[j] < player2NumbersArray[j])
							{
								player2Score++;
								break;
							}
						}
						break;
					}
					case 5:
					{
						for(int j = player1NumbersArray.length - 1; j >= 0; j--)
						{
							if(player1NumbersArray[j] > player2NumbersArray[j])
							{
								player1Score++;
								break;
							}
							else if(player1NumbersArray[j] < player2NumbersArray[j])
							{
								player2Score++;
								break;
							}
						}
						break;
					}
					case 6:
					{
						if(player1Full[0] > player2Full[0])
						{
							player1Score++;
							break;
						}
						else if(player1Full[0] < player2Full[0])
						{
							player2Score++;
							break;
						}
						else if(player1Full[1] > player2Full[1])
						{
							player1Score++;
							break;
						}
						else if(player1Full[1] < player2Full[1])
						{
							player2Score++;
							break;
						}
						else
							for(int j = player1NumbersArray.length - 1; j >= 0; j--)
							{
								if(player1NumbersArray[j] > player2NumbersArray[j])
								{
									player1Score++;
									break;
								}
								else if(player1NumbersArray[j] < player2NumbersArray[j])
								{
									player2Score++;
									break;
								}
							}
						break;
					}
					case 7:
					{
						if(player1Four > player2Four)
						{
							player1Score++;
							break;
						}
						else if(player1Four < player2Four)
						{
							player2Score++;
							break;
						}
						else
							for(int j = player1NumbersArray.length - 1; j >= 0; j--)
							{
								if(player1NumbersArray[j] > player2NumbersArray[j])
								{
									player1Score++;
									break;
								}
								else if(player1NumbersArray[j] < player2NumbersArray[j])
								{
									player2Score++;
									break;
								}
							}
						break;
					}
					case 8:
					{
						for(int j = player1NumbersArray.length - 1; j >= 0; j--)
						{
							if(player1NumbersArray[j] > player2NumbersArray[j])
							{
								player1Score++;
								break;
							}
							else if(player1NumbersArray[j] < player2NumbersArray[j])
							{
								player2Score++;
								break;
							}
						}
						break;
					}
				}
				
			}
			
			if(player1Score > player2Score)		//if player 1 beats player 2, increment number of wins
			{
				wins++;
			}
			
		}
		System.out.println(wins);
	}
}
