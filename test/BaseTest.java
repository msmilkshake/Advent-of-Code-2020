import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public abstract class BaseTest {
    protected final PrintStream originalOut = System.out;
    protected final ByteArrayOutputStream mockOut = new ByteArrayOutputStream();

    @Before
    public void setOut() {
        System.setOut(new PrintStream(mockOut));
    }

    @After
    public void restoreOut() {
        System.setOut(originalOut);
    }
}
