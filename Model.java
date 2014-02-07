import java.util.*;
import java.io.*;

public class Model
{
  private ArrayList<Student> Students = new ArrayList<Student>();
  private ArrayList<Module> Modules = new ArrayList<Module>()

  public Model()
  {

  }

  public void runTests()
  {
    String students = loadFromTextFiles("students.txt"); 
    parseStudents(students);

    String modules = loadFromTextFiles("modules.txt"); 
    parseModules(modules);
  }

  private void parseModules(String inFile)
  {
    String[] tokens = inFile.split("[\n]");
    int numRecords = Integer.parseInt(tokens[0]);
    int i = 0;

    while(i < numRecords)
    {
      System.out.println("Adding: " + tokens[a] + tokens[b] + tokens[c] + tokens[d]);
      Students.add(new Student(tokens[a], tokens[b], tokens[c], tokens[d]));
      i++;
      a+=4;
      b+=4;
      c+=4;
      d+=4;
    }
  }

  private void parseStudents(String inFile)
  {
    String[] tokens = inFile.split("[\n]");
    int numRecords = Integer.parseInt(tokens[0]);
    int i = 0;
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    while(i < numRecords)
    {
      System.out.println("Adding: " + tokens[a] + tokens[b] + tokens[c] + tokens[d]);
      Students.add(new Student(tokens[a], tokens[b], tokens[c], tokens[d]));
      i++;
      a+=4;
      b+=4;
      c+=4;
      d+=4;
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
