import java.text.NumberFormat;
// W.P. Iverson, class for quiz
// Bellevue College, November 2019
//
// A class to represent employees in general.
public class BCEmployee
{
    private String name;
    private double hourlyPay;
    private static final int secret = 3;
	
    // Constructor
    public BCEmployee()
    {
    	name = "unknown";
    	hourlyPay = 0;
    	verifyPay();
    }

    // Accessors
    public String getName()
    {
    	return name;
    }
    
    public double getHourlyPay()
    {
    	return hourlyPay;
    }
    
    // Use default currency format
    public String toString()
    {
    	NumberFormat nf = NumberFormat.getCurrencyInstance();
    	return "Name: " + name + ", hourly pay=" + nf.format(hourlyPay);
    }
    
    // Mutators
    public void setName(String n)
    {
    	name = n;
    }
    
    public void setHourlyPay(double rate)
    {
    	this.hourlyPay = rate;
    	verifyPay();
    }
    
    private void verifyPay()
    {
    	// be certain the penny and dime digits add to "secret" or zero
    	int dollars = (int)hourlyPay;
    	int pennies = (int)Math.round((hourlyPay-dollars)*100.);
    	int dimes = (int)(pennies/10);
    	pennies -= 10*dimes;
    	if ((dimes+pennies)!=secret && hourlyPay>0) 
    		throw new IllegalArgumentException("secret pay violation");
    }
}
