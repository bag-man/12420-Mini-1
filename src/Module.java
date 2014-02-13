import java.util.*;

public class Module implements java.io.Serializable
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

  public void deleteStudent()
  {
    int lastStudent = enrolledStudents.size()-1;
    enrolledStudents.remove(lastStudent);
  }

  public int getNumStudents()
  {
    return enrolledStudents.size();
  }
  
  public Student getStudents(int i)
  {
    return enrolledStudents.get(i);
  }


//Auto generated getters/setters
public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public ArrayList<Student> getEnrolledStudents() {
	return enrolledStudents;
}

public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
	this.enrolledStudents = enrolledStudents;
}

}