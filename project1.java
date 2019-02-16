/*
*	Joseph Ingenito
*	2/14/19
*	project1.java
*	A game to record how fast the user can select the oval which moves upon mouse click.
*/

import java.util.Random;
import doodlepad.*;

public class project1
{
	private static Rectangle rectStart;
	private static Rectangle rectEnd;
	private static Oval target;
	private static Text textbox;
	private static int ClickCount;
	private static long startTime;
	private static Random rnd;
	
	private enum ViewMode
	{
		Show, Hide, Toggle;
	}
	
	public static void main(String[] args)
	{
		rectStart = new Rectangle(0,0,100,100);
		rectStart.setFillColor(0,255,0);
		rectStart.setMouseClickedHandler(project1::onStart);
		
		rectEnd = new Rectangle(500,500,100,100);
		rectEnd.setFillColor(255,0,0);
		rectEnd.setMouseClickedHandler(project1::onStop);
		changeVisibility(rectEnd, ViewMode.Hide);
		
		target = new Oval();
		target.setFillColor(0,0,255);
		target.setMouseClickedHandler(project1::onJump);
		changeVisibility(target, ViewMode.Hide);
		
		textbox = new Text();
		textbox.setText("GO!");
		textbox.setLocation(200,20);
		
		rnd = new Random();
	}
	
	public static void onStart(Shape shp, double x, double y, int button)
	{
		ClickCount = 0;
		startTime = System.currentTimeMillis();
		textbox.setText("" + ClickCount);
		changeVisibility(target, ViewMode.Show);
		changeVisibility(rectEnd, ViewMode.Show);
		changeVisibility(textbox, ViewMode.Show);
		changeVisibility(rectStart, ViewMode.Hide);
		changeTargetLocation();
	}
	
	public static void onStop(Shape shp, double x, double y, int button)
	{
		changeVisibility(target, ViewMode.Hide);
		changeVisibility(rectEnd, ViewMode.Hide);
		changeVisibility(rectStart, ViewMode.Show);
		double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;
		textbox.setText("Clicks: " + ClickCount + ", Time: " + elapsed + " s");
	}
	
	public static void onJump(Shape shp, double x, double y, int button)
	{
		ClickCount++;
		textbox.setText("" + ClickCount);
		changeTargetLocation();
	}
	
	private static void changeTargetLocation()
	{
		double x = 500 * rnd.nextDouble();
		double y = 500 * rnd.nextDouble();
		target.setLocation(x,y);
	}
	
	private static void changeVisibility(Shape shp, ViewMode mode)
	{
		switch(mode)
		{
			case Show:
				shp.setVisible(true);
				break;
			case Hide:
				shp.setVisible(false);
				break;
			case Toggle:
				shp.setVisible(!shp.getVisible());
				break;
		}
	}
}