import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hamcrest
{
   // assertions on collections
    @Test
    void assertForMaptest()
    {
        Map<String,Integer>map= new HashMap<>();
        map.put("firstkey",1);
        map.put("secondkey",2);
        map.put("thirdkey",3);

        assertThat(map, Matchers.hasKey("secondkey"));
        assertThat(map, Matchers.hasValue(2));
    }

    @Test
    void assertForList()
    {
        List<String> list= Arrays.asList("First String","Second String");
        assertThat(list,Matchers.hasItem("Second String"));
    }

    @Test
    void assertForAnyOf()
    {
        List<String> list= Arrays.asList("First String","Second String");

        assertThat(list,Matchers.anyOf(Matchers.hasItem("Third String"),Matchers.hasItem("First String")));
    }

    @Test
    void assertContainsAnyOrder() {
        List<String> list = Arrays.asList("First String", "Second String");

        assertThat(list, Matchers.containsInAnyOrder("First String", "Second String"));

    }
    //Matchers has many functions.
}
