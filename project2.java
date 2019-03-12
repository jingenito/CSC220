//Name		 : Joe Ingenito
//Date		 : 3/12/19
//Title		 : project2.java
//Description: Generate 300 rows in a 2D array applying rule 30 and translate the 2D array to an image object.
//Commands	 : javac -cp doodlepad.jar project2.java
//			   java -cp doodlepad.jar.; project2

import doodlepad.*;

public class project2
{
	private static int rows = 301;
	private static int cols = 601;
	
	public static void main(String[] args)
	{
		int[][] pixels = applyRule30();
		
		Image img = new Image(0, 0, cols, rows);
		setImagePixels(img, pixels);
	}
	
	public static void setImagePixels(Image img, int[][] pixels)
	{
		for(int x = 0; x < cols; ++x) //width
		{
			for(int y = 0; y < rows; ++y) //height
			{
				//if pixel value is 0 then set pixel in image to white, otherwise set to black
				img.setPixel(x, y, (pixels[y][x] == 0 ? 255 : 0));
			}
		}
		img.scale(2,2); //scales image in both directions by 2
		System.out.println("Finished!");
	}
	
	public static int[][] applyRule30()
	{
		int[][] p = new int[rows][cols];
		int center = cols / 2; //integer division will truncate the decimal
		p[0][center] = 1; //initialize center of first row
		
		//start at 2nd row 
		for(int y = 1; y < rows; ++y)
		{
			//loop needs to start at 2nd column to always scan 1 before and 1 ahead
			for(int x = 1; x < cols - 1; ++x) //only loop until 2nd to last col
			{
				//only apply rule if at least one of the 3 values are not 0
				if(p[y-1][x-1] > 0 || p[y-1][x] > 0 || p[y-1][x+1] > 0)
				{
					p[y][x] = applyRowRule(p[y-1][x-1], p[y-1][x], p[y-1][x+1]);
				}
			}
		}
		return p;
	}
	
	public static int applyRowRule(int e1, int e2, int e3)
	{
		int x1 = e1 << 2; // e1 0 0
		int x2 = e2 << 1; // 0 e2 0
		int rule = x1 | x2 | e3; //creates the integer from bitwise operations where e1 is most significant bit and e3 is least significant bit
		switch(rule)
		{
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 1;
			case 3:
				return 1;
			case 4:
				return 1;
			case 5:
				return 1;
			case 6:
				return 0;
			case 7:
				return 0;
		}
		return 0; //switch should always find a case but just in case
	}
}










