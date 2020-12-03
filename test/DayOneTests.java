import day1.Main;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class DayOneTests extends BaseTest {
    {
        Main.numbers = new int[]{1721, 979, 366, 299, 675, 1456};
    }

    @Test
    public void testPartOne() {
        Main.partOne();
        Assert.assertEquals(mockOut.toString().trim(), "514579");
    }

    @Test
    public void testPartTwo() {
        Main.partTwo();
        Assert.assertEquals(mockOut.toString().trim(), "241861950");
    }
}
