package day8;


import util.Util;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static String[] lines;

    static {
        lines = Util.getInput("in/day8.txt");
    }

    public static void partOne() {
        int index = 0;
        long accumulator = 0;
        Set<Integer> history = new HashSet<>();
        while (!history.contains(index)) {
            history.add(index);
            String[] line = lines[index].split(" ");
            int val = Integer.parseInt(line[1]);
            switch(line[0]) {
                case "acc":
                    accumulator += val;
                case "nop":
                    ++index;
                    break;
                case "jmp":
                    index += val;
            }
        }
        System.out.println(accumulator);
    }

    public static void partTwo() {
        boolean bugFound = false;
        // replace jmps
        for (int i = 0; i < lines.length; ++i) {
            String line = lines[i];
            if (!line.contains("jmp")) {
                continue;
            }
            lines[i] =line.replaceAll("jmp", "nop");
            bugFound = exec();
            if (bugFound) {
                return;
            }
            lines[i] =line.replaceAll("nop", "jmp");
        }
        // replace nops
        for (int i = 0; i < lines.length; ++i) {
            String line = lines[i];
            if (!line.contains("nop")) {
                continue;
            }
            lines[i] =line.replaceAll("nop", "jmp");
            bugFound = exec();
            if (bugFound) {
                return;
            }
            lines[i] =line.replaceAll("jmp", "nop");
        }

    }

    public static boolean exec() {
        int index = 0;
        long accumulator = 0;
        Set<Integer> history = new HashSet<>();
        while (!history.contains(index) && index != lines.length) {
            history.add(index);
            String[] splitLine = lines[index].split(" ");
            int val = Integer.parseInt(splitLine[1]);
            switch(splitLine[0]) {
                case "acc":
                    accumulator += val;
                case "nop":
                    ++index;
                    break;
                case "jmp":
                    index += val;
            }
        }
        if (index == lines.length) {
            System.out.println(accumulator);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
