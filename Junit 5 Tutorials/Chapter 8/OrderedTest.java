import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
// explicit order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest
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
        @Order(1)
        void firstTestMethod()
        {
            System.out.println("first test method");
        }


        @Test
        @Order(2)
        @DisplayName("Second method displayed at console")
        void secondMethod()
        {
            System.out.println("Second test method");
        }


        @Test
        @Order(3)
        @DisplayName("Third method")
        void thirdMethod()
        {
            System.out.println("Third method");
        }

    }



