import java.io.*;
import java.util.*;

public class MainProgram
{
  public static void main(String[] args)
  {
    Model newModel = new Model();

    try {
      newModel.loadStudents("students.txt"); 
    } catch(FileNotFoundException e) {
      System.out.println("students.txt not found!");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }

    try {
      newModel.loadModules("modules.txt"); 
    } catch(FileNotFoundException e) {
      System.out.println("modules.txt not found!");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }

    newModel.printReport();
 
    try {
      newModel.saveSerial();
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
 
    newModel.deleteStudent();

    newModel.printReport();
    
    try {
      newModel = newModel.loadSerial();
    } catch(IOException e) {
      throw new RuntimeException(e);
    } catch(ClassNotFoundException c) {
      throw new RuntimeException(c);
    }

    newModel.printReport();

    try {
      newModel.writeXML();
    } catch(IOException e) {
      throw new RuntimeException(e);
    } 

    try {
      newModel = newModel.readXML();
    } catch(IOException e) {
      throw new RuntimeException(e);
    } 
  }

} 
