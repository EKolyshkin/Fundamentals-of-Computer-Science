
public class App
{
    public static void main(String[] args) 
    {
	B obj1 = new B();
	obj1.inc();
	System.out.println(obj1.x);
	System.out.println(obj1.y);
	
	B obj2 = new B();
	obj2.inc();
	System.out.println(obj2.x);
	System.out.println(obj2.y);
    }

}
