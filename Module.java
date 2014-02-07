import java.util.*;

public class Module 
{
  private String code;
  private ArrayList<Student> enrolledStudents = new ArrayList<Student>();

  public Module(String c)
  {
    code = c;
  }

  public String toString()
  {
    return code;
  }

  public void addThisStudent(Student S)
  {
    enrolledStudents.add(s);  
  }
}
