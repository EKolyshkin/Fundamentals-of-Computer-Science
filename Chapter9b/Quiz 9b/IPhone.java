/* Egor Kolyshkin, CS 211, 1/13/2021
 * Quiz 9b Assignment
 * Class IPhone implementing Asset interface
 * from Chapter 9 BJP Textbook */

public class IPhone implements Asset
{
    // FIELDS
    public static final double annualDepreciation = 0.2; // fraction decline each year
    private double originalCost; // in US dollars, fixed for each object
    private int currentAge;  // in years


    // CONSTRUCTORS
    public IPhone() // zero-parameter constructor
    {
        this(0, 0);
    }

    public IPhone(double cost, int age) // defined constructor
    {
        this.originalCost = cost;
        this.currentAge = age;
    }


    // ACCESSORS
    public double getMarketValue()  // how much the asset is worth
    {
        return originalCost * Math.pow((1 - annualDepreciation), currentAge);
    }
    
    public double getProfit()   // how much money has been made on this asset
    {
        return getMarketValue() - originalCost;
    }

    public String toString()
    {
        return "IPhone ( " + currentAge + " years old )";
    }
}
