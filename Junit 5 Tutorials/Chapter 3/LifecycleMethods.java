package Junit5Tests;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifecycleMethods
{
    @BeforeAll
    void beforeAll()
    {
        System.out.println("--This is before all method");
    }

    @BeforeEach
    void beforeEach()
    {
        System.out.println("----This is before each method");
    }

    @AfterAll
    void afterall()
    {
        System.out.println("--This is the after all method");
    }

    @AfterEach()
    void aftereach()
    {
        System.out.println("----This is the after each method");
    }

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
