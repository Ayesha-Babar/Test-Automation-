package Junit5Tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedTestCsvSource
{
    @ParameterizedTest
    @CsvSource(value={"steve,rogers" ,"captain,marvel"})
    void csvSource_Stringstring(String param1,String param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource({"steve,32,true","captain,21,false"})
    void csvSource_StringIntBoolean(String param1, String param2, boolean param3)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);

    }

    @ParameterizedTest
    @CsvSource(value={"captain america,'steve,rogers'","winter soldier,'bucky,barnes'"})
    void StringWithComma(String param1,String param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value={"steve?rogers","bucky?barnes"},delimiter = '?')
    void csvSource_StringwithDelimiter(String param1, String param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
