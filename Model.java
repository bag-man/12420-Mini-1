import java.util.*;
import java.io.*;

public class Model
{
  private ArrayList<Student> Students = new ArrayList<Student>();
  private ArrayList<Module> Modules = new ArrayList<Module>();

  public Model()
  {

  }

  public void runTests()
  {

    try {
      loadStudents("students.txt"); 
    } catch(FileNotFoundException e) {
      System.out.println("students.txt not found!");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }

    try {
      loadModules("modules.txt"); 
    } catch(FileNotFoundException e) {
      System.out.println("modules.txt not found!");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }

  }

  private Student findStudent(String u)
  {
    String uid = u;
    Student found = null;

    for(int i=0; i < Students.size();i++)
    {
      if(Students.get(i).toString() == uid)
      {
	found = Students.get(i);
      }
    }
    return found;
  }

  private void loadModules(String fileName) throws IOException
  {
    BufferedReader file = new BufferedReader(new FileReader(fileName));
    int numRecords = Integer.parseInt(file.readLine());

    for(int i=0; i < numRecords; i++)
    {
      String code = file.readLine();
      Modules.add(new Module(code));

      int numParticipant = Integer.parseInt(file.readLine());
      for(int y=0; y < numParticipant; y++)
      {
	String uid = file.readLine();
	Modules.get(Modules.size()-1).addThisStudent(findStudent(uid));
      }
    }

    file.close();
  } 


  private void loadStudents(String fileName) throws IOException
  {
    BufferedReader file = new BufferedReader(new FileReader(fileName));
    int numRecords = Integer.parseInt(file.readLine());

    for(int i=0; i < numRecords; i++)
    {
      String uid = file.readLine();
      String sName = file.readLine();
      String fName = file.readLine();
      String degree = file.readLine();
      Students.add(new Student(uid, sName, fName, degree));
      System.out.println("Adding: " + uid + sName + fName + degree);
    }

    file.close();
  } 

  public void printReport()
  {

  }

  public void findAStudent(String uid) //Will return a Student object
  {

  }
}
