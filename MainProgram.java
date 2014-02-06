public class MainProgram
{
  public static void main(String[] args)
  {
    System.out.println("Hello World!");
    Model newModel = new Model();
    newModel.loadFromTextFiles("/root/test.txt");
  }
}
