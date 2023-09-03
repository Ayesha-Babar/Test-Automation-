import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)

public class TestRunOrder
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

        @Test
        @DisplayName("Third method")
        void thirdMethod()
        {
            System.out.println("Third method");
        }

    }

