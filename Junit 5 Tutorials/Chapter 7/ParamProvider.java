import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider
{
    static Stream<Arguments> sourcestream_StringDouble()
    {
        // processing done here
        return Stream.of(arguments("tomato",2.0),arguments("cabbage",3.5));
    }
}
