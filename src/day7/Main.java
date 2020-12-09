package day7;


import util.Util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static String[] lines;
    public static String myBag = "shiny gold";
    public static String bagRgx = "(\\b.*?) bags? contain (.*).";
    public static String contentsRgx = "(\\d) (.*?) bags?";

    public static Map<String, Map<String, Integer>> children = new HashMap<>();

    static {
        lines = Util.getInput("in/day7.txt");
    }

    public static void partOne() {
        Map<String, Set<String>> parents = new HashMap<>();
        for (String line : lines) {
            Matcher m = Pattern.compile(bagRgx).matcher(line);
            if (m.find()) {
                String bag = m.group(1);
                for (String contents : m.group(2).split(", ")) {
                    m = Pattern.compile(contentsRgx).matcher(contents);
                    if (m.find()) {
                        parents.putIfAbsent(m.group(2), new HashSet<>());
                        parents.get(m.group(2)).add(bag);
                    }
                }
            }
        }

        Set<String> bagSet = new HashSet<>();
        Set<String> validBags = new HashSet<>();
        bagSet.add(myBag);
        while (!bagSet.isEmpty()) {
            List<String> bags = new ArrayList<>(bagSet);
            bagSet.clear();
            for (String bag : bags) {
                if (parents.get(bag) != null) {
                    validBags.addAll(parents.get(bag));
                    bagSet.addAll(parents.get(bag));
                }
            }
        }

        System.out.println(validBags.size());
    }

    public static void partTwo() {
        for (String line : lines) {
            Matcher m = Pattern.compile(bagRgx).matcher(line);
            if (m.find()) {
                String bag = m.group(1);
                for (String contents : m.group(2).split(", ")) {
                    m = Pattern.compile(contentsRgx).matcher(contents);
                    if (m.find()) {
                        children.putIfAbsent(bag, new HashMap<>());
                        children.get(bag).put(m.group(2), Integer.parseInt(m.group(1)));
                    }
                }
            }
        }

        long num = getNumBags(myBag);
        System.out.println(--num);
    }

    public static long getNumBags(String bag) {
        long sum = 0;
        if (children.get(bag) == null) {
            return 1;
        }
        for (String child :children.get(bag).keySet()) {
            sum += getNumBags(child) * children.get(bag).get(child);
        }
        ++sum;
        return sum;
    }



    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
