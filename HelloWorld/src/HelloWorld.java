import doodlepad.*;

public class HelloWorld {
	
	public static void main(String[] args) {
		Oval o = new Oval();
		o.setFillColor(0,0,255);
		o.setMouseClickedHandler(HelloWorld::oval_Click);
	}
	
	public static void oval_Click(Shape shp, double x, double y, int button) {
		System.out.println("Hello World");
	}
}
