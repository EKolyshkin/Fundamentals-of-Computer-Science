/* Egor Kolyshkin, CS210, 11/25/2020
 * Chapter 8a Quiz */

public class Octagon
{
    private Point center;	// center point of Octagon 
    private double side;	// length of side of Octagon 
    
    public Octagon()	// default Octagon constructor
    {
	this(new Point(0, 0), 0);	// calls Octagon(Point, int) constructor
    }
    
    public Octagon(Point c, double s)	// makes Octagon with center point c and side s
    {
	this.center = c;
	this.side = s;
    }
    
    public Point getCenter()	// returns center point of Octagon
    {
	return center;
    }
    
    public double getSide()	// returns side length of Octagon
    {
	return side;
    }
    
    public double area()	// returns area of Octagon (Google has formula)
    {
	return 2 * Math.pow(side, 2) * (1 + Math.sqrt(2));
    }
    
    public double perimeter()	// returns perimeter of Octagon
    {
	return side * 8;
    }
    
    public void setCenter(Point c)	// sets center point of Octagon
    {
	this.center = c;
    }
    
    public void setSide(double r)	// sets side of Octagon as r
    {
	this.side = r;
    }
}
