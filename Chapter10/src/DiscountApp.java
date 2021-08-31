/* Egor Kolyshkin, CS 211, 1/18/2021
 * Chapter 10 Assignment
 * Based on Programming Project #1 */

public class DiscountApp extends GroceryBill
{
    // FIELDS
    private boolean discount;


    // CONSTRUCTORS
    public DiscountApp(boolean discount)    // single-parameter
    {
        this.discount = discount;
    }

    public DiscountApp()    // zero-parameter
    {
        this.discount = false;
    }


    // ACCESSORS
    public double getTotal()    // returns total amount, checks for discounts
    {                           
        double total = 0;
        double discAmount = 0;

        for (int i = 0; i < receipt.size(); i++)    // iterates over receipt list
        {                                           // to adjust total and discount amounts
            total += receipt.get(i).getPrice();
            discAmount += receipt.get(i).getDiscount();
        }
        
        if (discount)
            total -= discAmount;
        
        return total;
    }

    public String toString()    // string output for all items in cart
    {
        return receiptToString() + "\ngetTotal(): " + getTotal();
    }


    // MUTATORS
    public boolean add(Item item, int count)    // add item to list, return true upon success
    {
        while (receipt.contains(item))  // removes previous instances of item
            receipt.remove(item);

        for (int i = 0; i < count; i++) // adds item count times
            receipt.add(item);

        return true;
    }
    
    public void setDiscount(boolean discount) // sets discount status
    {
        this.discount = discount;
    }
}