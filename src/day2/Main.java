package day2;


import util.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static String[] lines;

    static {
        lines = Util.getInput("in/day2.txt");
    }

    public static void partOne() {
        int validCount = 0;
        String regex = "(\\d+)-(\\d+)\\s+(\\w):\\s+(\\w+)";
        for (String line : lines) {
            Matcher m = Pattern.compile(regex).matcher(line);
            if (m.find()) {
                int min = Integer.parseInt(m.group(1));
                int max = Integer.parseInt(m.group(2));
                String req = m.group(3);
                String pw = m.group(4);
                Matcher findOccurrences = Pattern.compile(req).matcher(pw);
                int count = 0;
                while (findOccurrences.find()) {
                    ++count;
                }
                if (count >= min && count <= max) {
                    ++validCount;
                }
            }
        }
        System.out.println(validCount);
    }

    public static void partTwo() {
        int validCount = 0;
        String regex = "(\\d+)-(\\d+)\\s+(\\w):\\s+(\\w+)";
        for (String line : lines) {
            Matcher m = Pattern.compile(regex).matcher(line);
            if (m.find()) {
                int pos1 = Integer.parseInt(m.group(1)) - 1;
                int pos2 = Integer.parseInt(m.group(2)) - 1;
                char req = m.group(3).charAt(0);
                String pw = m.group(4);
                if (pw.charAt(pos1) == req && pw.charAt(pos2) != req ||
                        pw.charAt(pos2) == req && pw.charAt(pos1) != req) {
                    ++validCount;
                }
            }
        }
        System.out.println(validCount);
    }

    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
