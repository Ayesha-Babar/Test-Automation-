import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest
{
    @Test
    @Disabled(value="Disabled for demo")
    void firstTestMethod()
    {
        System.out.println("first test method");
    }

    @Test
    @DisabledOnOs(value= OS.LINUX,disabledReason = "disabled on linux")
    @DisplayName("Second method displayed at console")
    void secondMethod()
    {
        System.out.println("Second test method");
    }

    @Test
    @EnabledOnOs(value=OS.WINDOWS)
    @DisplayName("Third method")
    void thirdMethod()
    {
        System.out.println("Third method");
    }

    @Test
    @DisabledIf(value="provider",disabledReason = "Disabled for demo")
    void fourthTest()
    {
        System.out.println("This is the fourth method");
    }

    boolean provider()
    {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }

}
