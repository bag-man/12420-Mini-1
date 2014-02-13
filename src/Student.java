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

//Auto generated getters/setters
public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getSName() {
	return sName;
}

public void setsName(String sName) {
	this.sName = sName;
}

public String getFName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getDegree() {
	return degree;
}

public void setDegree(String degree) {
	this.degree = degree;
}

}