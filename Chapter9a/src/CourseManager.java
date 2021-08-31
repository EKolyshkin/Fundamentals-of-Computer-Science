
public class CourseManager
{
    public static void main(String[] args)
    {
	CSCourse first = new CSCourse("CS210", 32);
	first.setAverageGPA(3.1);
	
	CSCourse second = new CSCourse("CS211", 31);
	second.setAverageGPA(3.4);
	
	int sum = first.getNumStudents() + second.getNumStudents();
	
	System.out.println("Sum of students: " + sum);
    }

}
