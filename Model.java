import java.util.*;
import java.io.*;

public class Model implements java.io.Serializable
{
  private ArrayList<Student> students = new ArrayList<Student>();
  private ArrayList<Module> modules = new ArrayList<Module>();

  public void deleteStudent()
  {
    modules.get(0).deleteStudent();
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
    for(int i=0; i < modules.size();i++)
    {
      System.out.println(modules.get(i));
      for(int y=0; y < modules.get(i).getNumStudents(); y++)
      {
        Student currStudent = modules.get(i).getStudents(y);
	System.out.println(" -- " + currStudent.toString()); 
      }
    }
  }

  private Student findStudent(String u)
  {
    for(Student s : students)
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
      modules.add(new Module(code));

      int numParticipant = Integer.parseInt(file.readLine());
      for(int y=0; y < numParticipant; y++)
      {
	String uid = file.readLine();
	modules.get(modules.size()-1).addThisStudent(findStudent(uid)); 
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
      students.add(new Student(uid, sName, fName, degree));
    }

    file.close();
  } 
}
