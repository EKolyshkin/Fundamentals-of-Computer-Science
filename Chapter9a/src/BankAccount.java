
public class BankAccount
{
    private int bal;
    
    // constructs a bankaccount object using info in s
    public BankAccount(Startup s)
    {
	this.bal = s.bal;
    }
    
    public void debit(Debit d)
    {
	this.bal += d;
    }
    
    public void credit(Credit c)
    {
	this.bal -= d;
    }
    
    // returns current balance
    public int getBalance()
    {
	return bal;
    }
}
