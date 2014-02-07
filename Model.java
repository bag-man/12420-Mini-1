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
    String students = loadFromTextFiles("students.txt"); 
    parseStudents(students);
  }

  private void parseStudents(String inFile)
  {
    String uid, sName, fName, degree;
    String[] tokens = inFile.split("[\n]");
    int numRecords = Integer.parseInt(tokens[0]);
    int recordCount = 1;
    int i = 0;

    while(i < numRecords)
    {

      //There must be a nicer way to do this.
      uid = tokens[recordCount];
      recordCount++;
      fName = tokens[recordCount]; 
      recordCount++;
      sName = tokens[recordCount]; 
      recordCount++;
      degree = tokens[recordCount]; 
      recordCount++;

      System.out.println("Adding: " + uid + sName + fName + degree);
      Students.add(new Student(uid, sName, fName, degree));

      i++;
    }
  }

  private String loadFromTextFiles(String fileName)
  {
    String returnValue = "";
    FileReader file = null;
    
    try {
      file = new FileReader(fileName);
      BufferedReader reader = new BufferedReader(file);
      String line = "";
      while ((line = reader.readLine()) != null) {
	returnValue += line + "\n";
      }
    } catch (Exception e) {
	throw new RuntimeException(e);
    } finally {
      if (file != null) {
	try {
	  file.close();
	} catch (IOException e) {
	  // Ignore issues during closing 
	}
      }
    }
    return returnValue;
  } 

  public void writeTextFile(String fileName, String s) {
    FileWriter output = null;
    try {
      output = new FileWriter(fileName);
      BufferedWriter writer = new BufferedWriter(output);
      writer.write(s);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      if (output != null) {
        try {
          output.close();
        } catch (IOException e) {
          // Ignore issues during closing
        }
      }
    }
  } 

  public void printReport()
  {

  }

  public void findAStudent(String uid) //Will return a Student object
  {

  }
}
