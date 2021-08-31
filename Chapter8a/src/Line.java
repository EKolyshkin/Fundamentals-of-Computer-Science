/* Egor Kolyshkin, CS 210, 11/23/2020
 * Assignment 8a */

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Line
{
    private Point p1;
    private Point p2;
    
    public Line() // zero parameters constructor
    {
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 0);
    }
    
    public Line(Point point, Point point2) // both parameters constructor
    {
        p1 = point;
        p2 = point2;
    }
    
    public Point getP1() // returns first point 
    {
        return p1;
    }
    
    public Point getP2() // returns second point 
    {
        return p2;
    }
    
    public double getSlope() // returns slope of line
    {
        double rise = p2.y - p1.y;
        double run = p2.x - p1.x;
        return rise / run;
    }
    
    public double getLength() // returns length of line
    {
        double rise = p2.y - p1.y;
        double run = p2.x - p1.x;
        return Math.sqrt(Math.pow(run, 2) + Math.pow(rise, 2));
    }
    
    public boolean intersect(Line line) // returns true if line intersects with parameter line
    {
	    return Line2D.linesIntersect(p1.x, p1.y, p2.x, p2.y, line.p1.x, line.p1.y, line.p2.x, line.p2.y);
    }
    
    public String print() // prints both points of line
    {
	    return p1 + " " + p2;
    }
    
    public String toString() // replaces default toString method to print zero parameter line properly
    {
	    return new String("[(" + p1.x + ", " + p1.y +"), ("+ p2.x+", "+p2.y + ")]");
    }
    
    void plot(Graphics gee) // draws line
    {
	    gee.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
