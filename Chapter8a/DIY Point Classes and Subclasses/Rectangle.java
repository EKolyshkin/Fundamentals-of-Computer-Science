
public class Rectangle
{
    private int x;
    private int y;
    private int width;
    private int height;
    
    // makes Rectangle at (0, 0) with width 1 and height 1
    public Rectangle()
    {
	this(0, 0, 1, 1); // calls Rectangle constructor with 4 int methods
    }
    
    // makes Rectangle at point Point with width width and height height
    public Rectangle(Point p, int width, int height)
    {
	this(p.getX(), p.getY(), width, height);
    }
    
    // makes Rectangle at (x, y) with width width and height height
    public Rectangle(int x, int y, int width, int height) throws IllegalArgumentException
    {
	if (width < 0 || height < 0)
	    throw new IllegalArgumentException();
	
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
    }
    
    // gets width of this Rectangle
    public int getWidth()
    {
	return width;
    }
    
    // gets height of this Rectangle
    public int getHeight()
    {
	return height;
    }
    
    // gets x of this Rectangle
    public int getX()
    {
	return x;
    }
    
    // gets y of this Rectangle
    public int getY()
    {
	return y;
    }
    
    // returns String representation of this Rectangle
    public String toString()
    {
	return "Rectangle[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
    }
    
    // returns whether point (x, y) lies within this Rectangle
    public boolean contains(int x, int y)
    {
	if (x >= this.x && y >= this.y && x <= this.x + width && y <= this.y + height)
	    return true;
	
	return false;
    }
    
    public boolean contains(Point p)
    {
	if (p.getX() >= this.x && p.getY() >= this.y && p.getX() <= this.x + width && p.getY() <= this.y + height)
	    return true;
	
	return false;
    }
}
