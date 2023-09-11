import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleExceptionHandling
{
    static Scanner fileReader=null;
    public static void main(String args[])
    {
        MultipleExceptions();
    }

    public  static void MultipleExceptions()
    {
        File file = new File("nonexistent.txt");

        try{
            fileReader=new Scanner(file);
            while(fileReader.hasNext())
            {
                double num = fileReader.nextDouble();
                System.out.println(num);
            }

        }catch(FileNotFoundException | InputMismatchException e)
        {
             e.printStackTrace();
        }
        finally
        {
            fileReader.close();
        }
    }
}
