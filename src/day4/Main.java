package day4;


import util.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static String[] lines;

    static {
        lines = Util.getInput("in/day4.txt");
        join();
    }

    public static void join() {
        lines = String.join("\n", lines)
                .replaceAll("\\b\\n\\b", " ")
                .split("\\n\\n");

    }

    public static void partOne() {
        String[] regexes = {
                ".*\\bbyr:.*",
                ".*\\biyr:.*",
                ".*\\beyr:.*",
                ".*\\bhgt:.*",
                ".*\\bhcl:.*",
                ".*\\becl:.*",
                ".*\\bpid:.*"
        };

        int count = 0;
        for (String line : lines) {
            boolean valid = true;
            for (String rgx : regexes) {
                valid &= line.matches(rgx);
            }
            if (valid) {
                ++count;
            }
        }
        System.out.println(count);
    }

    public static void partTwo() {
        String[] regexes = {
                ".*\\bbyr:(\\d{4})\\b.*",
                ".*\\biyr:(\\d{4})\\b.*",
                ".*\\beyr:(\\d{4})\\b.*",
                ".*\\bhgt:(\\d+)(cm|in)\\b.*",
                ".*\\bhcl:#[0-9a-f]{6}\\b.*",
                ".*\\becl:(?:amb|blu|brn|gry|grn|hzl|oth)\\b.*",
                ".*\\bpid:\\d{9}\\b.*"
        };

        int count = 0;
        for (String line : lines) {
            boolean valid = true;
            for (int i = 0; i < regexes.length; ++i) {
                Matcher m = Pattern.compile(regexes[i]).matcher(line);
                valid &= m.find();
                if (valid) {
                    switch (i) {
                        case 0:
                            int val = Integer.parseInt(m.group(1));
                            valid = val >= 1920 && val <= 2002;
                            break;
                        case 1:
                            val = Integer.parseInt(m.group(1));
                            valid = val >= 2010 && val <= 2020;
                            break;
                        case 2:
                            val = Integer.parseInt(m.group(1));
                            valid = val >= 2020 && val <= 2030;
                            break;
                        case 3:
                            val = Integer.parseInt(m.group(1));
                            switch (m.group(2)) {
                                case "cm":
                                    valid = val >= 150 && val <= 193;
                                    break;
                                case "in":
                                    valid = val >= 59 && val <= 76;
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            if (valid) {
                ++count;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
