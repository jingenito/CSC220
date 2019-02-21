/*
*	Joseph Ingenito
*	2/21/19
*	Lab04.java
*	Estimate pi by using the ratio of amount of random points that fall within a circle inscribed within a square.
*
*	javac Lab04.java
* 	java Lab04
*/

import java.util.Random;

public class Lab04
{
	private static int iterations = 100000;
	
	public static void main(String[] args)
	{
		Random rnd = new Random();
		
		int count = 0; //point counter
		int i = 0;  //loop counter
		while(i < iterations){
			double x = rnd.nextDouble(); //assign x and y to random doubles in the bounds of the unit square
			double y = rnd.nextDouble();
			count = (isWithinCircle(x, y) ? count + 1 : count);
			i++;
		}
		double pi = 4 * ((double)count / iterations);
		printResults(count, pi);
	}
	
	private static Boolean isWithinCircle(double x, double y)
	{
		double tempX = Math.pow(x - 0.5, 2);
		double tempY = Math.pow(y - 0.5, 2);
		return Math.sqrt(tempX + tempY) <= 0.5;
	}
	
	private static void printResults(int count, double pi){
		System.out.println("Total iterations: " + iterations);
		System.out.println("Points within Circle: " + count);
		System.out.println("Estimate of pi: " + pi);
	}
}