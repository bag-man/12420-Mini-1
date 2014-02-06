import java.util.*;
import java.io.*;

public class Model
{
  private ArrayList<Student> Students;
  private ArrayList<Module> Modules;

  public Model()
  {

  }

  public void runTests()
  {
    String students = loadFromTextFiles("students.txt"); //Load Students
  }

  public String loadFromTextFiles(String fileName)
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
