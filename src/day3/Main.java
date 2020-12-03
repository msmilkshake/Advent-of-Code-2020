package day3;


import util.Util;


public class Main {
    public static String[] lines;

    static {
        lines = Util.getInput("in/day3.txt");
    }

    public static void partOne() {
        int x = 0;
        int w = lines[0].length();
        char tree = '#';
        int count = 0;
        for (int i = 1; i < lines.length; ++i) {
            x += 3;
            if (x >= w) {
                x -= w;
            }
            if (lines[i].charAt(x) == tree) {
                ++count;
            }
        }
        System.out.println(count);
    }

    public static void partTwo() {
        long a = getTrees(1, 1);
        long b = getTrees(3, 1);
        long c = getTrees(5, 1);
        long d = getTrees(7, 1);
        long e = getTrees(1, 2);

        System.out.println(a * b * c * d * e);
    }

    public static long getTrees(int right, int down) {
        int x = 0;
        int y = 0;
        int w = lines[0].length();
        int h = lines.length;
        char tree = '#';
        long count = 0;
        while (true) {
            x += right;
            y += down;
            if (x >= w) {
                x -= w;
            }
            if (y >= h) {
                break;
            }
            if (lines[y].charAt(x) == tree) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
