import java.util.*;
import java.io.*;

public class Model implements java.io.Serializable
{
  private ArrayList<Student> Students = new ArrayList<Student>();
  private ArrayList<Module> Modules = new ArrayList<Module>();

  public void deleteStudent()
  {
    Modules.get(0).deleteStudent();
  }

  public Model loadSerial() throws IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream("saveFile.dat");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    Model newModel = (Model) in.readObject();
    in.close();
    fileIn.close();
    return newModel;
  }

  public void saveSerial() throws IOException
  {
    FileOutputStream fileOut = new FileOutputStream("saveFile.dat");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(this);
    out.close();
    fileOut.close();
  }

  public void printReport()
  {
    System.out.println();
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
    for(Student s : Students)
    {
      if(s.toString().equals(u))
      {
	return s;
      }
    }
    return null;
  } 

  public void loadModules(String fileName) throws IOException
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

  public void loadStudents(String fileName) throws IOException
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
