/*
*	File	   :	Lab06.java
*	Name	   :	Joe Ingenito
*	Date	   :	3/5/19
*	Description:	Practice using ArrayLists, 1D arrays and multidimensional arrays.
*	Commands   :	javac Lab06.java
*					java Lab06
*/

import java.util.ArrayList;

public class Lab06
{
	//Answers for Queston 1
	public static void Q1()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("String1");
		list.add("String2");
		list.add("String3");
		list.add("String4");
		
		System.out.println("Answers for Question 1:");
		System.out.println(list.size());
		System.out.println("-------------"); //line spacing
		
		for(String s : list)
		{
			System.out.println(s);
		}
		System.out.println("-------------"); //line spacing
		
		for(String s : list)
		{
			if(s.length() > 3){ System.out.println(s);} //print each string if its length is greater than 3
		}
		System.out.println("-------------"); //line spacing
		
		int counter = list.size() - 1;
		while(counter >= 0)
		{
			if((counter % 2 == 0) && (counter != 0)){ list.remove(counter);} //not considering 0 even or odd
			counter--;
		}
		
		counter = 0; //recycle counter from above
		do {
			System.out.println(list.get(counter));
			counter++;
		} while(counter < list.size());
		System.out.println("-------------"); //line spacing
	}
	
	//Answers for Queston 2
	public static void Q2()
	{
		double[] data1 = {1,2,3};
		System.out.println("Answers for Question 2:");
		
		int counter = 0;
		while(counter < data1.length)
		{
			System.out.println(data1[counter]);
			counter++;
		}
		System.out.println("-------------"); //line spacing
		
		int[][] data2 = { {-4, -3, -2, -1}, {0, 1, 2, 3}, {4, 5, 6, 7} };
		for(int i = 0; i < data2.length; ++i) //loops over rows
		{
			for(int j = 0; j < data2[i].length; ++j) //loops over columns
			{
				System.out.print(data2[i][j] + " "); //prints data2[i][j] without a new line
			}
			System.out.println(""); //prints a new line to format like a matrix
		}
		System.out.println("-------------"); //line spacing
		
		for(int i = 0; i < data2.length; ++i) //loops over rows
		{
			for(int j = 0; j < data2[i].length; ++j) //loops over columns
			{
				if(data2[i][j] < 0)
				{ 
					System.out.print(data2[i][j] + " "); //prints data2[i][j] if value is less than 0
				}else { System.out.print("_ ");} //leaves a _ if value is not less than 0
			}
			System.out.println(""); //prints a new line to format like a matrix
		}
		System.out.println("-------------"); //line spacing
	}
	
	//Main Method
	public static void main(String[] args)
	{
		Q1();
		Q2();
	}
}