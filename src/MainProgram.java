import java.io.*;

public class MainProgram
{
  public static void main(String[] args)
  {
    Model newModel = new Model();

    System.out.println("Loading Students...");
    try {
      newModel.loadStudents("students.txt"); 
    } catch(FileNotFoundException e) {
      System.out.println("students.txt not found!");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Loading Modules...");
    try {
      newModel.loadModules("modules.txt"); 
    } catch(FileNotFoundException e) {
      System.out.println("modules.txt not found!");
    } catch(IOException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Printing report...");
    newModel.printReport();
 
    System.out.println("Saving data to Serial File...");
    try {
      newModel.saveSerial();
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
 
    System.out.println("Deleting student from first module...");
    newModel.deleteStudent();

    System.out.println("Printing report...");
    newModel.printReport();
    
    System.out.println("Loading data from Serial File...");
    try {
      newModel = newModel.loadSerial();
    } catch(IOException e) {
      throw new RuntimeException(e);
    } catch(ClassNotFoundException c) {
      throw new RuntimeException(c);
    }

    System.out.println("Printing report...");
    newModel.printReport();

    System.out.println("Saving data to XML File...");
    try {
      newModel.writeXML();
    } catch(IOException e) {
      throw new RuntimeException(e);
    } 

    System.out.println("Deleting student from first module...");
    newModel.deleteStudent();

    System.out.println("Printing report...");
    newModel.printReport();

    System.out.println("Loading data from XML File...");
    try {
      newModel = newModel.readXML();
    } catch(IOException e) {
      throw new RuntimeException(e);
    } 

    System.out.println("Printing report...");
    newModel.printReport();
  }

} 
