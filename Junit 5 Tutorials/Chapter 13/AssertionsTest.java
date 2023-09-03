import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(Listeners.class)
public class AssertionsTest
{
    @Test
    void assertEquals()
    {
        Assertions.assertEquals("first string","second string","the string values are not equals");

    }

    @Test
    void assertEqualList()
    {
        List<String> list1= Arrays.asList("string1","string 2");
        List<String>list2=Arrays.asList("string1","string2","string3");
        Assertions.assertEquals(list1,list2,"These lists are not equals");
    }

    @Test
    void assertArrayEqualsTest()
    {
        int[] actualvalues={1,3};
        int[] expectedvalues={1,3};
        assertArrayEquals(actualvalues,expectedvalues);

    }

    @Test
    void assertArraysEqualsTest()
    {
        //assertTrue(false,"this condition didnt evaluate to true");
        assertTrue(true, "this condition evaluated to true");
        assertFalse(false);
    }

    @Test
    void assertThrowsTest()
    {
        assertThrows(NullPointerException.class,null);
    }

    @Test
    void assertall()
    {
        assertAll(
                () -> Assertions.assertEquals("first string", "second string", "The string values are not equal"),
                () -> assertTrue(true, "This condition evaluated to true"),
                () -> assertThrows(NullPointerException.class, () -> {
                    throw new NullPointerException("A custom exception message");
                })
        );

    }


}

