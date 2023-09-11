import java.io.File;
import java.io.IOException;

public class ExceptionHandling
{
    public static void main(String args[])
    {
        createNewFile();
    }
    public static void createNewFile()
    {
        File file = new File("resources/nonexistent.txt");
        File.createNewFile();
        try
        {
            file.createNewFile();
        }catch(IOException e)
        {
            System.out.println("directory doesnt exist");
            e.printStackTrace();
        }
    }
}
