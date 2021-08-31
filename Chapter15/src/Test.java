/* no imports required, we're writing our own
 * optional iterator import if your curious
 * 
 * CS211, W.P. Iverson, instructor and author
 * This is a start at test code for Chapter 15 Assignment
 * Other tests can and will happen....
 * version 2021
 */
public class Test {

// Testing for Exercises in Chapter 15
	
	public static void main(String[] args) {
		ArrayIntList test = new ArrayIntList();		// my data structure
		ArrayList<Integer> test2 = new ArrayList<Integer>();
		int[] a = {2,9,6,1,3,9,0};	// sample data
		for (int i: a) {			// use for each 
			test.add(i);
			test2.add(i);
		}
		
		System.out.println(test);
		System.out.println(test2);
		System.out.println(test.lastIndexOf(9));			// 15.1  should be 5?
		System.out.println(test2.lastIndexOf(9));			// 15.1
		test.reverse();									// 15.4
		System.out.println(test);
		System.out.println(test.count(2));									// 15.8
		//test.removeLast(9);								// 15.11
		test.removeFront(4);								// 15.12
		System.out.println(test);
		test.removeAll(9);								// 15.13
		System.out.println(test);
		test.mirror();									// 15.15
		System.out.println(test);
		test.stutter();									// 15.16
		System.out.println(test);
		test.stretch(3);									// 15.17
		System.out.println(test);							// changed if above code is run
		
		System.out.print("\nLearning about iterators:\n[");
		ArrayIntList.ArrayIntListIterator itr =  test.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next()+", ");
		}

		// Programming Project #2 
//		for (int i: test) System.out.println(i);	// requires Oracle Iterable or Iterator?  Know the difference!
		System.out.print("\n\nText Project #2 solution was done on BJP site:\n[");
		for (Integer data: test2) System.out.print(data+", "); // uses a generic Java API Iterator<E>
	}

}