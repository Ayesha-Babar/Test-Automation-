import org.testng.annotations.Test;

public class PriorityAttribute
{
    @Test(priority=1)
    void firstMethod()
    {
        System.out.println("first method");
    }

    @Test(priority=2)
    void secondMethod()
    {
        System.out.println("second method");
    }
}
