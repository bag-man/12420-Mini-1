import java.util.*;
import java.io.*;

public class Model implements java.io.Serializable
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

    printReport();
 
    try {
      saveSerial();
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  /*
  //http://www.tutorialspoint.com/java/java_serialization.htm
  private void loadSerial() throws IOException
  {
    FileInputStream fileIn = new FileInputStream("saveFile");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    e = (Employee) in.readObject();
    in.close();
    fileIn.close();
  }
  */

  private void saveSerial() throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream("saveFile.dat");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(this);
    out.close();
    fileOut.close();
  }

  private void printReport()
  {
    for(int i=0; i < Modules.size();i++)
    {
      System.out.println(Modules.get(i));
      for(int y=0; y < Modules.get(i).getNumStudents(); y++)
      {
        Student currStudent = Modules.get(i).getStudents(y);
	System.out.println(" -- " + currStudent.toString()); 
      }
    }
  }

  private Student findStudent(String u)
  {
    Student found = null;
    for(Student s : Students)
    {
      if(s.toString().equals(u))
      {
        found = s;
	return found;
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
    }

    file.close();
  } 
}
