import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class RepeatingTests
{
    @RepeatedTest(5)
    void firstRepeatedMethod()
    {
        System.out.println("repeating test 5 times");
    }

    @RepeatedTest(value=3, name="running repetition: {currentRepetition}."+
    "Total is:{totalRepetetions}")
    @DisplayName("This is a repeatedTestMethod")
    void Secondmethod()
    {
        System.out.println("running it three times");
    }

    @RepeatedTest(3)
    void thirdTestmethod(RepetitionInfo repetitioninfo)
    {
        System.out.println("This will run for three times and repetitioninfo is " + repetitioninfo);
        assumingThat(repetitioninfo.getCurrentRepetition()==3,
                ()-> System.out.println("This code only runs for repetition 3"));
    }
}
