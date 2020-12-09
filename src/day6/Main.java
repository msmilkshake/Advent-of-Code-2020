package day6;


import util.Util;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static String[] lines;

    static {
        lines = Util.getInput("in/day6.txt");
    }

    public static void join() {
        lines = String.join("\n", lines)
                .replaceAll("\\b\\n\\b", " ")
                .split("\\n\\n");

    }

    public static void partOne() {
        join();
        int sum = 0;
        for (String line : lines) {
            Set<Character> set = new HashSet<>();
            for (char c : line.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                set.add(c);
            }
            sum += set.size();
        }
        System.out.println(sum);
    }

    public static void partTwo() {
        int sum = 0;
        for (String line : lines) {
            String[] answers = line.split(" ");
            List<Character> list = new ArrayList<>() {
                {
                    for (char c : answers[0].toCharArray()) {
                        add(c);
                    }
                }
            };
            Set<Character> set = new HashSet<>(list);
            for (int i = 1; i < answers.length; ++i) {
                List<Character> chars = new String(answers[i].toCharArray())
                        .chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.toList());
                set.retainAll(chars);
            }
            sum += set.size();
        }
        System.out.println(sum);
    }

    public static void mockIn() {
        lines = new String[] {
                "abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b"
        };
    }
}
