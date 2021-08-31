/* Egor Kolyshkin, CS210, 11/25/2020
 * Chapter 8, Exercises 1-3 */

// A Point object represents a pair of (x, y) coordinates.
// Fourth version: encapsulated.

public class Point
{
    private int x;
    private int y;

    // constructs a new point at the origin, (0, 0)
    public Point()
    {
	this(0, 0); // calls Point(int, int) constructor
    }
    
    // constructs a new point with the given (x, y) location
    public Point(int x, int y)
    {
	setLocation(x, y);
    }
    
    // returns the distance between this Point and (0, 0)
    public double distanceFromOrigin()
    {
	return Math.sqrt(x * x + y * y);
    }
    
    // returns the x-coordinate of this point
    public int getX()
    {
	return x;
    }
    
    // returns the y-coordinate of this point
    public int getY()
    {
	return y;
    }
    
    // sets this point's (x, y) location to the given values
    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    // returns a String representation of this point
    public String toString()
    {
	return "(" + x + ", " + y + ")";
    }
    
    // returns number of quadrant the point falls in
    public int quadrant()
    {
	int quad = 0;
	
	if (x > 0 && y > 0)	// 1st quadrant
	    quad = 1;
	
	if (x < 0 && y > 0)	// 2nd quadrant
	    quad = 2;
	
	if (x < 0 && y < 0)	// 3rd quadrant
	    quad = 3;
	
	if (x > 0 && y < 0)	// 4th quadrant
	    quad = 4;
	
	return quad;
    }
    
    public int manhattanDistance(Point other)
    {
	return Math.abs(x - other.x) + Math.abs(y - other.y);
    }
    
    // shifts this point's location by the given amount
    public void translate(int dx, int dy)
    {
	setLocation(x + dx, y + dy);
    }
    
    // negates and swaps x and y coordinates
    public void flip()
    {
	int t = x;
	
	setLocation(x = y * -1, y = t * -1);
    }
}