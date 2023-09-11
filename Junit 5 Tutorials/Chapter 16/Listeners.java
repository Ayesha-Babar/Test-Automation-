import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listeners implements TestWatcher{
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("-----------------------------------------");
        System.out.println("This test is disabled. "+"context = " + context + ", reason = " + reason);
       // TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("-----------------------------------------");
        System.out.println("This test is successful: "+context.getTestMethod());
        //TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("-----------------------------------------");
        System.out.println("This test is aborted: "+cause.getMessage());
        //TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("-----------------------------------------");
        System.out.println("This test failed: "+cause.getMessage());
        //TestWatcher.super.testFailed(context, cause);
    }
}
