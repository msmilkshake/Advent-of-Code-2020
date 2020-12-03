import day2.Main;
import org.junit.Assert;
import org.junit.Test;


public class DayTwoTests extends BaseTest {
    {
        Main.lines = new String[]{
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        };
    }

    @Test
    public void testPartOne() {
        Main.partOne();
        Assert.assertEquals(mockOut.toString().trim(),"2");
    }

    @Test
    public void testPartTwo() {
        Main.partTwo();
        Assert.assertEquals(mockOut.toString().trim(), "1");
    }
}
