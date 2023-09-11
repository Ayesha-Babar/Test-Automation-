package Junit5Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestsValueSource
{
    @ParameterizedTest(name= "Run:{index} - value:{arguments}")
    @ValueSource(ints={1,5,6})
    void intValues(int Param)
    {
        System.out.println("Param = " + Param);
    }

    @ParameterizedTest(name="String number:{arguments}")
    @ValueSource(strings={"first string","Second String"})
    void stringValues(String param)
    {
        System.out.println("param = " + param);
    }

    @ParameterizedTest(name="String number:{arguments}")
    @EmptySource
    @ValueSource(strings={"first string","Second String"})
    void stringValuesEmpty(String param)
    {
        System.out.println("param = " + param);
    }

    @ParameterizedTest(name="String number:{arguments}")
    @EmptySource
    @NullSource
    @ValueSource(strings={"first string","Second String"})
    void stringValuesEmptyNull(String param)
    {
        System.out.println("param = " + param);
    }

}
