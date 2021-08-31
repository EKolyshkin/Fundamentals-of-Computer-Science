/* Egor Kolyshkin, CS 210, 12/9/2020
 * Chapter 9a Quiz
 * StudentEmployee Class */

public class StudentEmployee extends BCEmployee
{
    // CONSTRUCTORS
    
    // default constructor
    public StudentEmployee()
    {
	super();
    }
    
    // constructor with name and pay rate
    public StudentEmployee(String n, double p)
    {
	super();
	setName(n);
	setHourlyPay(p);
    }
    
    // MUTATORS
    
    // mutator sets pay to 0
    public void volunteer()
    {
	setHourlyPay(0);
    }
    
    // ACCESSORS
    
    // accessor toString modified to add "Student"
    public String toString()
    {
	return "Student " + super.toString();
    }
    
}
