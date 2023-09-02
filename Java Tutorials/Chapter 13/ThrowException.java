import java.io.File;
import java.io.IOException;

public class ThrowException {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void throwException() {
        try {
            File file = new File("nonexistent.txt");
            if (!file.exists()) {
                throw new IllegalArgumentException("File does not exist");
            }
        } catch(Exception e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}