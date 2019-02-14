/*
*	Joseph Ingenito
*	2/14/19
*	Lab03.java
*	Insert lab03 description here.
*/

import doodlepad.*;

public class Lab03
{
	static int women = 0;
	static int men = 0;
	static StringBuilder sb;
	
	public static void main(String[] args)
	{
		sb = new StringBuilder();
	}
	
	public static void menOval_Click(Shape shp, double x, double y, int button)
	{
		men++;
		sb.append("M");
	}
	
	public static void womenOval_Click(Shape shp, double x, double y, int button)
	{
		women++;
		sb.append("W");
	}
	
	public static void showSummary(Shape shp, double x, double y, int button)
	{
		System.out.println("Men: " + men);
		System.out.println("Women: " + women);
		System.out.println(sb.ToString());
	}