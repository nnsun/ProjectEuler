//Project Euler Problem 18
public class Problem018
{
	public static void main(String[] args)
	{
		int[] row0 = {75};
		int[] row1 = {95, 64};
		int[] row2 = {17, 47, 82};
		int[] row3 = {18, 35, 87, 10};
		int[] row4 = {20, 4, 82, 47, 65};
		int[] row5 = {19, 1, 23, 75, 3, 34};
		int[] row6 = {88, 2, 77, 73, 7, 63, 67};
		int[] row7 = {99, 65, 4, 28, 6, 16, 70, 92};
		int[] row8 = {41, 41, 26, 56, 83, 40, 80, 70, 33};
		int[] row9 = {41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
		int[] row10 = {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
		int[] row11 = {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
		int[] row12 = {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
		int[] row13 = {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
		int[] row14 = {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23};
		
		int maxSum = 0;
		
		for(int i = 0; i < row1.length; i++)
		{
			int sumi = row1[i];
			for(int j = i; j <= i+1; j++)
			{
				int sumj = sumi + row2[j];
				for(int k = j; k <= j+1; k++)
				{
					int sumk = sumj + row3[k];
					for(int l = k; l <= k+1; l++)
					{
						int suml = sumk + row4[l];
						for(int m = l; m <= l+1; m++)
						{
							int summ = suml + row5[m];
							for(int n = m; n <= m+1; n++)
							{
								int sumn = summ + row6[n];
								for(int o = n; o <= n+1; o++)
								{
									int sumo = sumn + row7[o];
									for(int p = o; p <= o+1; p++)
									{
										int sump = sumo + row8[p];
										for(int q = p; q <= p+1; q++)
										{
											int sumq = sump + row9[q];
											for(int r = q; r <= q+1; r++)
											{
												int sumr = sumq + row10[r];
												for(int s = r; s <= r+1; s++)
												{
													int sums = sumr + row11[s];
													for(int t = s; t <= s+1; t++)
													{
														int sumt = sums + row12[t];
														for(int u = t; u <= t+1; u++)
														{
															int sumu = sumt + row13[u];
															for(int v = u; v <= u+1; v++)
															{
																int sumv = sumu + row14[v];
																
																if(sumv > maxSum)
																	maxSum = sumv;															
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		maxSum += 75;
		System.out.println(maxSum);
	}
}
