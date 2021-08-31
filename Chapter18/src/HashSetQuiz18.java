// copyright Bellevue College
public class HashSetQuiz18
{
     public static void main(String[] q98)
     {
          HashSet<Integer> test = new HashSet<Integer>();
          test.add(1); test.add(2); test.add(3); test.add(98);  test.add(561);
          System.out.println(test); // [1, 2, 3, 98, 561]
          // System.out.println(test.toString2()); // to see chained hashing
          System.out.println(test.backwards()); // above in reverse order
             
          test.add(13);  test.add(23);  test.add(33); // forcing collisions
          System.out.println(test.toString()); // more data
          //System.out.println(test.toString2()); // to see chained hashing
          System.out.println(test.backwards()); // reverse order

          HashSet<Integer> empty = new HashSet<Integer>();
          System.out.println(empty);
          System.out.println(empty.backwards());
     }
}