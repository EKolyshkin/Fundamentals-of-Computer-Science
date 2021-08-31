import java.io.FileNotFoundException;

// CS211 BC, W.P. Iverson
// version January 2021
// changed sku and numbers
public class SimpleConsoleTest {

    public static void main(String[] args) throws FileNotFoundException {
    	Item one = new Item("Item #123020",13,2); // Item #123020
		Item two = new Item("book",13,0); // a book at 13
		System.out.println(one); // Item #123020 $13.00 (-$2.00)
		DiscountApp basket = new DiscountApp();
		// DiscountApp test = new DiscountApp(new Employee("you"));
		System.out.println(basket.getTotal()); // 0
		System.out.println(basket.add(one,1)); // true 
		System.out.println(basket);  // Item #123020 $13.00 (-$2.00)
		System.out.println(basket.getTotal()); // 13
		System.out.println(basket.add(one,8)); // true 	
		System.out.println(basket.getTotal()); // 104
		System.out.println(basket.add(one,4)); // true 	
		System.out.println(basket.getTotal()); // 52
		basket.add(two,9);
		System.out.println(basket.getTotal()); // 169
		basket.setDiscount(true);
		System.out.println(basket.getTotal());  // 161
		basket.setDiscount(false);
		System.out.println(basket.getTotal());  // 169
		System.out.println(basket);  // shows all, so output very long
    }
}