package Junit5Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass
{
    @Test
    void firstTestMethod()
    {
        System.out.println("first test method");
    }

    @Test
    @DisplayName("Second method displayed at console")
    void secondMethod()
    {
        System.out.println("Second test method");
    }
}
