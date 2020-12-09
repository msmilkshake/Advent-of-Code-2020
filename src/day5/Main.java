package day5;


import util.Util;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static String[] lines;

    static {
        lines = Util.getInput("in/day5.txt");
    }

    public static Map<Long, Byte> map = new HashMap<>(lines.length);

    public static void partOne() {
        long max = Long.MIN_VALUE;
        for (String line : lines) {
            int f = 0;
            int b = 127;
            for (int i = 0; i < 6; ++i) {
                int m = (b + f) / 2;
                if (line.charAt(i) == 'F') {
                    b = m;
                } else {
                    f = m + 1;
                }
            }
            int row = line.charAt(6) == 'F' ? f : b;
            int l = 0;
            int r = 7;
            for (int i = 7; i < 9; ++i) {
                int m = (l + r) / 2;
                if (line.charAt(i) == 'L') {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            int col = line.charAt(9) == 'L' ? l : r;
            long id = row * 8 + col;
            map.put(id, null);
            max = Math.max(id, max);
        }
        System.out.println(max);
    }

    public static void partTwo() {
        long[] list = map.keySet().stream()
                .mapToLong(n -> n)
                .sorted()
                .toArray();
        long id = 0;
        for (long number : list) {
            if (id == 0 || number == id + 1) {
                id = number;
            } else {
                ++id;
                break;
            }
        }
        System.out.println(id);
    }

    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
