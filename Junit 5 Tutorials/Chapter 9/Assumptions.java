import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class Assumptions
{
    @ParameterizedTest(name="Run: {index} - value: {arguments}")
    @ValueSource(ints={1,2,3})
    void intValues(int param)
    {
        assumeTrue(param<3);
        System.out.println("param = " + param);
    }

    @ParameterizedTest
    @CsvSource(value={"steve,rogers","captain,america"})
    void csvSource(String param1, String param2)
    {
        assumeFalse(param1.equals("steve"),"The assumption failed");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


    @ParameterizedTest(name="Run: {index} - value: {arguments}")
    @ValueSource(ints={1,2,3})
    void intValues2(int param)
    {
       assumingThat(param>0,()-> System.out.println("This system ran"));
        System.out.println("param = " + param);
    }



}
