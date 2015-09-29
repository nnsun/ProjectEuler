//Project Euler Problem 4
public class Problem004
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int largest = 100*100;
		int[] productArray = new int[6];
		
		for(int i = 100; i < 1000; i++)
		{
			for(int j = 100; j < 1000; j++)
			{
				int product = i*j;
				productArray = toArray(product);
				if(productArray[0] == productArray[5] && productArray[1] == productArray[4] && productArray[2] == productArray[3] && product > largest)
					largest = product;
			}
		}
		System.out.println(largest);
		
	}
	
	//takes a 6 digit number, ABCDEF and creates an array of its digits: {A,B,C,D,E,F}
	//Jan 10, 2015: better method would've been just to convert it into a string and create an array. Thanks Adam!
	public static int[] toArray(int n)
	{
		int[] array = new int[6];
		array[0] = (int)Math.floor(n/100000);
		int bcdef = n-(array[0]*100000);
		array[1] = (int)Math.floor(bcdef/10000);
		int cdef = bcdef-(array[1]*10000);
		array[2] = (int)Math.floor(cdef/1000);
		int def = cdef-(array[2]*1000);
		array[3] = (int)Math.floor(def/100);
		int ef = def-(array[3]*100);
		array[4] = (int)Math.floor(ef/10);
		int f = ef-(array[4]*10);
		array[5] = f;
		return array;
	}
}