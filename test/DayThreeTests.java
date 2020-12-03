import day3.Main;
import org.junit.Assert;
import org.junit.Test;


public class DayThreeTests extends BaseTest {
    {
        Main.lines = new String[]{
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        };
    }

    @Test
    public void testPartOne() {
        Main.partOne();
        Assert.assertEquals(mockOut.toString().trim(), "7");
    }

    @Test
    public void testPartTwo() {
        Main.partTwo();
        Assert.assertEquals(mockOut.toString().trim(), "336");
    }
}
