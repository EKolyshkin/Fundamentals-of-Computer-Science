
public class HarvardLawyer extends Employee
{
    public double getSalary()
    {
	return super.getSalary() * 1.2;
    }
    
    public int getVacation()
    {
	return super.getVacation() + 3;
    }
    
    public String getVacationForm()
    {
	return super.getVacationForm().repeat(4);
    }
}
