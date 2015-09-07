//Project Euler Problem 28
public class Problem28
{
	public static void main(String[] args)
	{
		int[][] spiralArray = new int[1001][1001];
		int yPos = 0;
		int xPos = 1000;
		int bound = 0;
		
		for(int i = 1002001; i > 0; i--)	//populate the array
		{
			if((yPos == bound) && (xPos > bound))
			{
				spiralArray[yPos][xPos] = i;
				xPos--;
			}
			else
				if((yPos < 1000 - bound) && (xPos == bound))
				{
					spiralArray[yPos][xPos] = i;
					yPos++;
				}
				else
					if((yPos == 1000 - bound) && (xPos < 1000 - bound))
					{
						spiralArray[yPos][xPos] = i;
						xPos++;
					}
					else
						if((yPos > bound) && (xPos == 1000 - bound))
						{
							spiralArray[yPos][xPos] = i;
							
							if(yPos == bound + 1)
							{
								bound++;
								yPos++;
								xPos--;
							}
							yPos--;
						}
			if(i == 1)
			{
				spiralArray[500][500] = 1;
			}
		}

		int sum = 0;
		for(int i = 0; i < 1001; i++)	//add the diagonals
		{
			sum += spiralArray[i][i];
			sum += spiralArray[1000 - i][i];
		}
		sum -= spiralArray[500][500];
		System.out.println(sum);
	}
}
