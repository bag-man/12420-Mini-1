public class Student
{
  private String uid, sName, fName, degree;

  public Student(String u, String s, String f, String d)
  {
    uid = u;
    fName = f;
    sName = s;
    degree = d;
  }

  public String toString()
  {
    return uid;
  }
}
