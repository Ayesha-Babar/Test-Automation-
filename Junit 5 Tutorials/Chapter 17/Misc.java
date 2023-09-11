import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class Misc
{
    @Test
    @Timeout(5)
    void timeout() throws InterruptedException
    {
        System.out.println("test with timeout");
        Thread.sleep(6000);
    }

    // add annotations in a separate interface and include them
    /*@Test
    @Timeout(90)
    @DisplayName("nice method")
    @Tag("tag")*/

    @Test
    @MyAnnotations
    void annotatedMethod2() 
    {
        System.out.println("custom annotation method");
    }


    // create inner class within a class
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTests{
        @BeforeAll
        void beforeall()
        {
            System.out.println("before all in nested test");
        }

        @Test
        void nestedtest()
        {
            System.out.println("nested test method");
        }
    }

}
