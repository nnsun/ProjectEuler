//Project Euler Problem 17
public class Problem17
{
	public static void main(String[] args)
	{
		int sum = 0;
		
		int sumUnder10 = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4;		//36
		int sum10to19 = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8;	//70
		int twenty = 6;
		int thirty = 6;
		int forty = 5;
		int fifty = 5;
		int sixty = 5;
		int seventy = 7;
		int eighty = 6;
		int ninety = 6;
		
		int sumTwenties = 10 * twenty + sumUnder10;
		int sumThirties = 10 * thirty + sumUnder10;
		int sumForties = 10 * forty + sumUnder10;
		int sumFifties = 10 * fifty + sumUnder10;
		int sumSixties = 10 * sixty + sumUnder10;
		int sumSeventies = 10 * seventy + sumUnder10;
		int sumEighties = 10 * eighty + sumUnder10;
		int sumNineties = 10 * ninety + sumUnder10;
		
		int sum100 = sumUnder10 + sum10to19 + sumTwenties + sumThirties + sumForties + sumFifties + sumSixties + sumSeventies + sumEighties + sumNineties;
		sum += sum100;
		
		int oneHundredAnd = 13;
		int twoHundredAnd = 13;
		int threeHundredAnd = 15;
		int fourHundredAnd = 14;
		int fiveHundredAnd = 14;
		int sixHundredAnd = 13;
		int sevenHundredAnd = 15;
		int eightHundredAnd = 15;
		int nineHundredAnd = 14;
		
		sum += 99 * oneHundredAnd + 99 * twoHundredAnd + 99 * threeHundredAnd + 99 * fourHundredAnd + 99 * fiveHundredAnd + 99 * sixHundredAnd + 99 * sevenHundredAnd + 
				99 * eightHundredAnd + 99 * nineHundredAnd + 7 * 9 + sumUnder10 + sum100 * 9;
		
		int OneThousand = 11;
		sum += OneThousand;
		
		System.out.println(sum);
	}
}
