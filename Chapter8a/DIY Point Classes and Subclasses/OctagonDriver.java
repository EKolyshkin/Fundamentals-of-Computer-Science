
public class OctagonDriver {
    public static void main(String[] args)
    {
	 // Client tests the Class we've made
	Octagon h1 = new Octagon(new Point(13,57),41);
	h1.setSide(36);
	System.out.println(h1.area());  // returns 6257.6 (as double)
	System.out.println(h1.perimeter());   // returns 288.0
    }

}
