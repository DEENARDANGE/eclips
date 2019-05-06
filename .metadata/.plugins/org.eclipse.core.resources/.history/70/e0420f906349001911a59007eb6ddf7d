package com.bridgelabz.algorithmprograms;
import com.bridgelabz.common.utils.InputUtility;
public class VendingMachine
{
			static int i, total;
			static int[] note = { 1000, 500, 100, 50, 10, 5, 2, 1 };
			static void notes(int value)
			{
				if (value / note[i] != 0) 
				{
					total += (value / note[i]);
					System.out.println(note[i] + "rs notes :" + value / note[i]);
					value = value % note[i];
				}
				    i++;
				if (value == 0)
				{
					System.out.println("Total notes :" + total);
					return;
				}

				notes(value);

			}
			public static void main(String[] args) {
				System.out.println("Enter amoumt");
					int value=InputUtility.readIntValues();
					notes(value);
				
				}
			
		

	}


