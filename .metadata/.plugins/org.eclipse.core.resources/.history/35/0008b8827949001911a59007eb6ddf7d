package com.bridgelabz.algorithmprograms;
import com.bridgelabz.util.AlgorithmLogic;
public class BubbleSort 
{
	public static void main(String[] args)
	{
		char temp;
		String sortedString=" ";
		System.out.println("The String is : ");
		String Str=AlgorithmLogic.readString();
		char[] chArr=Str.toCharArray();
		for(int i=0;i<chArr.length;i++)
		{
			for(int j=0;j<chArr.length;j++)
			{
				if(chArr[i]<chArr[j])
				{
					temp=chArr[i];
  				    chArr[i]=chArr[j];
  				    chArr[j]=temp;
  			    }
  		    }
  	   }
		for(int k=0;k<chArr.length;k++)
		{
			sortedString=sortedString+chArr[k];
		}
		System.out.println("Sorted String id " + sortedString);
		}
	}
