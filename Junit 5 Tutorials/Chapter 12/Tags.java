import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Tags
{
    @Test
    @Tag("sanity test tag")
    void firsttestMethod()
    {
        System.out.println("first method");
    }

    @Test
    @Tag("acceptance tag")
    @DisplayName("second method displaying")
    void secondtestMethod()
    {
        System.out.println("second method");
    }

    @Test

    void thirdtestMethod()
    {
        System.out.println("third method");
    }


    @Tag("acceptance tag")
    @ParameterizedTest(name = "Run:{index} - value:{argument}")
    @ValueSource(ints={1,5,6})
    void intvalues(int param)
    {
        System.out.println("param = " + param);
    }




}
