import java.awt.*;

public class ClientDriver
{
	public static void main(String[] args)
	{
		// "[(22, 3), (4, 7)]" from Practice-IT
		Line zero = new Line(); // REQUIRED you write with this(... called
		Line little = new Line(new Point(22,3), new Point(4,7));
		Line other = new Line(new Point(100,100), new Point(200,200));
		System.out.println(little.print());;
		System.out.println(zero);
		
		// From Chapter 3G
		DrawingPanel canvas = new DrawingPanel(200,200);
		Graphics golly = canvas.getGraphics();
		little.plot(golly);
		other.plot(golly);
		
		// Some test code
		System.out.println(little.getP1());
		System.out.println(little.getSlope()); // you write a method
		System.out.println(little.getLength()); // you write a method
		System.out.println(little.intersect(other)); // you write a method
	}

}
