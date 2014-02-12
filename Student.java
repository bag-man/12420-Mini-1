public class Student implements java.io.Serializable
{
  private String uid, sName, fName, degree;

  public Student(){}

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

  //Getters and setters for bean, might be wrong.
  public void setUid(String u)
  {
    uid = u;
  }

  public void setsName(String s)
  {
    sName = s;
  }

  public void setfName(String f)
  {
    fName = f;
  }

  public void setDegree(String d)
  {
    degree = d;
  }

  public String getUid()
  {
    return uid;
  }

  public String getsName()
  {
    return sName;
  }

  public String getfName()
  {
    return fName;
  }

  public String getDegree()
  {
    return degree;
  }
}
