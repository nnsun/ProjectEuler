// Project Euler problem 19
// Solved on 1/16/2015
public class Problem019
{	
	public static void main(String[] args)
	{
		int sundays = 0;
		int dayOfWeek = 2;
		
		for(int year = 1900; year < 2001; year++)
		{
			for(int month = 1; month < 13; month++)
			{
				if(year % 4 != 0 || (year % 4 == 0 && year % 100 == 0 && year % 400 != 0))	// for non-leap years
				{
					for(int day = 1; day <= (28 + (15662003 >> (2 * (month - 1)) & 0b11)); day++)	// 15662003 is the magic number for 0b111011101111101110110011, the encoding for days in a month for non-leap years
					{
						if(dayOfWeek == 1 && day == 1 && year > 1900)
							sundays++;
						
						if(dayOfWeek != 7)
							dayOfWeek++;
						else
							dayOfWeek = 1;
							
					}
				}
				
				if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))	// for leap years
				{
					for(int day = 1; day <= (28 + (3915500 >> (2 * (month - 1)) & 0b11)); day++)	// 3915500 is the magic number for 0b1110111011111011101100, the encoding for days in a month for leap years
					{
						if(dayOfWeek == 1 && day == 1 && year > 1900)
								sundays++;
						
						if(dayOfWeek != 7)
							dayOfWeek++;
						else
							dayOfWeek = 1;
					}
				}
								
			}
		}
		
		System.out.println(sundays);
		
		
	}
}
