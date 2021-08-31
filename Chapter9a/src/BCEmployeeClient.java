
public class BCEmployeeClient
{
    public static void main(String[] args)
    {
	BCEmployee first = new BCEmployee();
	System.out.println(first); // Name: unknown, hourly pay=$0.00
	//first.setHourlyPay(99); // throws IllegalArgument Exception
	StudentEmployee bob = new StudentEmployee("Bob", 12.21);
	bob.setHourlyPay(25.30);
	System.out.println(bob); // Student Name: Bob, hourly pay=$25.30
	bob.volunteer();
	System.out.println(bob); // Student Name: Bob, hourly pay=$0.00
	StudentEmployee sally = new StudentEmployee();
	System.out.println(sally); // Student Name: unknown, hourly pay=$0.00
    }
}
