import java.util.*;

public class Module 
{
  private String code;
  private ArrayList<Student> enrolledStudents = new ArrayList<Student>();

  public Module(){}
  
  public Module(String c)
  {
    code = c;
  }

  public String toString()
  {
    return code;
  }

  public void addThisStudent(Student s)
  {
    enrolledStudents.add(s);  
  }

  //Getters and setters for bean, this might be wrong.
  public String getCode()
  {
    return code;
  }

  public void setCode(String c)
  {
    code = c;
  }
  
  public Student getStudents(int i)
  {
    System.out.println(enrolledStudents.get(i).getfName());
    return enrolledStudents.get(i);
  }

  public int getNumStudents()
  {
    return enrolledStudents.size();
  }

  public void setStudents(ArrayList<Student> s)
  {
    enrolledStudents = s;
  }

}
