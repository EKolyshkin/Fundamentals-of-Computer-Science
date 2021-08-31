public class Octagon implements Shape
{
    private double side;

    public Octagon(double side)
    {
        this.side = side;
    }

    public double getArea()
    {
        return 2 * Math.pow(side, 2) * (1 + Math.sqrt(2));
    }   

    public double getPerimeter()
    {
        return side * 8;
    }
}
