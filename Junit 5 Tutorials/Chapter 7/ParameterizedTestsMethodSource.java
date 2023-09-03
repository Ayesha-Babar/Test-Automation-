import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTestsMethodSource
{
    @ParameterizedTest
    @MethodSource(value="sourcestring")
    void Methodsource_String(String param1)
    {
        System.out.println("param1 = " + param1);
    }
    List<String> sourcestring()
    {
        // processing done here
        return Arrays.asList("tomato","carrot");
    }

    @ParameterizedTest
    @MethodSource(value="sourcestringstream")
    void Methodsourcestream_String(String param1)
    {
        System.out.println("param1 = " + param1);
    }
    Stream<String> sourcestringstream()
    {
        // processing done here
        return Stream.of("Beetroot","apple");
    }

    @ParameterizedTest
    @MethodSource(value="sourceList_StringDouble")
    void Methodsourcelist_String(String param1,double param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    List<Arguments> sourceList_StringDouble()
    {
        // processing done here
        return Arrays.asList(arguments("tomato",2.0),arguments("cabbage",3.5));
    }

    @ParameterizedTest
    @MethodSource(value="java.Junit5Tests.ParamProvider#sourcestream_StringDouble")
    void Methodsourcestream_String(String param1,double param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


    






}
