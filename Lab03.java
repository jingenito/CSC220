/*
*	Joseph Ingenito
*	2/14/19
*	Lab03.java
*	User can select a colored circle corresponding to a gender entering a room, selecting the rectangle 
*	prints the respective counts and the order in which each gender entered the room.
*/

import doodlepad.*;

public class Lab03
{
	private static int women = 0;
	private static int men = 0;
	private static StringBuilder sb;
	
	public static void main(String[] args)
	{
		sb = new StringBuilder();
		
		Oval ovalMen = new Oval(50,150,100,100);
		ovalMen.setFillColor(100,0,200);
		ovalMen.setMouseClickedHandler(Lab03::menOval_Click);
		
		Oval ovalWomen = new Oval(300,150,100,100);
		ovalWomen.setFillColor(200,0,100);
		ovalWomen.setMouseClickedHandler(Lab03::womenOval_Click);
		
		Rectangle rect = new Rectangle(100,300,300,100);
		rect.setFillColor(0,200,0);
		rect.setMouseClickedHandler(Lab03::showSummary);
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
		System.out.println(sb.toString());
	}
}