/*
*	Joseph Ingenito
*	2/26/19
*	Lab05.java
*	Grayscale an image by using a weighted sum of the RGB values of each pixel, then 
*   convert the image to black and white by choosing a cutoff value for the grayscaled value
*   of each pixel.
*
*	javac -cp doodlepad.jar Lab05.java
* 	java -cp doodlepad.jar.; Lab05
*/

import doodlepad.*;

public class Lab05
{
	private static String filepath = "C:\\Users\\jinge\\Pictures\\tcnj.jpg"; //path to the image
	
	public static void main(String[] args)
	{
		Image img1 = new Image(filepath, 0, 0);
		Image img2 = new Image(filepath, img1.getWidth(), 0, img1.getWidth(), img1.getHeight());
		Image img3 = new Image(filepath, 0, img2.getHeight(), img1.getWidth(), img1.getHeight());
		grayscale(img1, img2);
		threshold(img2, img3, 150);
	}
	
	private static int RGB2gray(int r, int g, int b)
	{
		return ((int)(0.21 * r) + (int)(0.72 * g) + (int)(0.07 * b)); //return the gray scale given rgb values
	}
	
	private static void grayscale(Image img1, Image img2) 
	{
		for(int x = 0; x < img1.getWidth(); ++x)
		{
			for(int y = 0; y < img1.getHeight(); ++y)
			{
				int gray = RGB2gray(img1.getRed(x, y), img1.getGreen(x, y), img1.getBlue(x, y));
				img2.setPixel(x, y, gray); //set the pixel to the computed gray value
			}
		}
	}
	
	private static void threshold(Image img1, Image img2, int cutoff)
	{
		for(int x = 0; x < img1.getWidth(); ++x)
		{
			for(int y = 0; y < img1.getHeight(); ++y)
			{
				int gray = img1.getRed(x, y); //rgb values are the same
				img2.setPixel(x, y, (gray >= cutoff ? 0 : 255)); //set black if greater than or equal to cutoff value, otherwise set white
			}
		}
	}
}





































