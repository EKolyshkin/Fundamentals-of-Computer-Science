
public class LooseChangeDriver
{
    public static void main(String[] args)
    {
	try
	{
		LooseChange zero = new LooseChange();
		LooseChange one = new LooseChange(319,34,155,11);
		LooseChange two = new LooseChange(1,2,3,4);
		LooseChange three = new LooseChange(23,34,65,235);
		LooseChange four = new LooseChange(39211,434,983,381);
		LooseChange five = new LooseChange(2387285,2784587,34720872,88);
		System.out.println(zero); // $0.0
		System.out.println(one);  // $23.14
		System.out.println(two.getPennies()); // 1
		System.out.println(two.getNickels()); // 2
		zero.setQuarters(400);  // void
		zero.setDimes(0);       // void		
		System.out.println(zero.add(two));  // true
		System.out.println(zero.getQuarters()); // 404
		one.setDimes(-13); // illegal
		zero = new LooseChange(-1,-1,-1,-1); // also illegal
	}
	catch (IllegalArgumentException event)
	{
		System.out.println("Negative coin count not allowed");
	}
    }
}
