// Basic tests for Chapter 17 Exercises
// upgraded into generic Search Tree use
// CS211, January 2021, W.P. Iverson, instructor

public class Post
{
	public static void main(String[] args)
	{
		SearchTree<Double> empty = new SearchTree<Double>();
		SearchTree<CalendarDate> test = new SearchTree<CalendarDate>();
		test.add(new CalendarDate(1,1,2021));  test.add(new CalendarDate(12,12,2016));
		SearchTree<CalendarDate> fat = new SearchTree<CalendarDate>();
		fat.add(new CalendarDate(1,1,2021));  fat.add(new CalendarDate(12,12,2016));
		fat.add(new CalendarDate(1,5,2019));  fat.add(new CalendarDate(5,25,1999));
		fat.add(new CalendarDate(1,2,2021)); fat.add(new CalendarDate(6,23,2010));

//		A.  Exercise #7   isFull();		
// 		System.out.println(test.isFull());	// false
// 		System.out.println(empty.isFull());	// true
// 		System.out.println(test);	// 2 nodes using toString()
		
// //		B.  Exercise #9   equals(t2);		
// 		System.out.println(test.equals(test));	// true
// 		System.out.println(test.equals(empty)); // false
		
//		D.  Exercise #12    removeLeaves();
		empty.removeLeaves();	empty.print();	// nothing to print
		test.removeLeaves();	test.print();	// [1/1/2021]
		System.out.println();
		System.out.println(fat);
		System.out.println();
		fat.removeLeaves();	System.out.println(fat);		// 2 nodes
		
//		C.  remove process explained in detail via PowerPoint at BJP site		
		// System.out.println(test);
		// empty.remove(42.);  empty.print();	// nothing to print
		// test.remove(new CalendarDate(1,1,2021));  test.print(); // all gone
		// System.out.println();
		// System.out.println(fat);
		// System.out.println();
		// fat.remove(new CalendarDate(12,12,2016));	System.out.println(fat);
	}
}
