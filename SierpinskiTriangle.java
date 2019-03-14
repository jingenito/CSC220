//Title	 	 : Sierpinski Triangle
//FileName   : SierpinskiTriangle.java
//Author	 : Joe Ingenito
//Date		 : 3/14/19
//Description: Creates the Sierpinski Triangle in a Doodlepad Window

import doodlepad.*;

public class SierpinskiTriangle
{
	public static int rows = 1081;
	public static int cols = 1721;
	
	public static void main(String[] args)
	{
		int[][] pixels = getSierpinskiTriangle();
		
		Image img = new Image(0, 0, cols, rows);
		setPixels(img, pixels);
	}
	
	public static void setPixels(Image img, int[][] pixels)
	{
		for(int x = 0; x < cols; ++x) //width
		{
			for(int y = 0; y < rows; ++y) //height
			{
				//if pixel value is 0 then set pixel in image to white, otherwise set to black
				img.setPixel(x, y, (pixels[y][x] == 0 ? 255 : 0));
			}
		}
		System.out.println("Finished!");
	}
	
	public static int[][] getSierpinskiTriangle()
	{
		int[][] p = new int[rows][cols];
		p[0][cols / 2] = 1;
		
		for(int y = 1; y < rows; ++y)
		{
			//even rows need to start on an even column
			for(int x = (y % 2 == 0 ? 2 : 1); x < cols; x+=2)
			{
				if(x + 2 >= cols){ break;}
				p[y][x] = applyRowRule(p[y-1][x-1], p[y-1][x+1]);
			}
		}
		return p;
	}
	
	public static int applyRowRule(int b1, int b2)
	{
		b1 <<= 1;
		int num = b1 | b2;
		switch(num)
		{
			case 1:
			case 2:
				return 1;
			case 0:
			case 3:
				return 0;
		}
		return 0;
	}
}












