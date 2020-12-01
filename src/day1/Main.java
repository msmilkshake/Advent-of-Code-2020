package day1;


import util.Util;

import java.util.Arrays;


public class Main {
    public static int[] numbers;

    static {
        numbers = Arrays.stream(Util.getInput("in/day1.txt"))
                .mapToInt(Integer::parseInt).toArray();
    }

    public static void partOne() {
        for (int i = 0; i < numbers.length - 1; ++i) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 2020) {
                    System.out.println(numbers[i] * numbers[j]);
                }
            }
        }
    }

    public static void partTwo() {
        for (int i = 0; i < numbers.length - 2; ++i) {
            for (int j = i + 1; j < numbers.length - 1; ++j) {
                for (int k = j + 1; k < numbers.length; ++k) {
                    if (numbers[i] + numbers[j] + numbers[k] == 2020) {
                        System.out.println(numbers[i] * numbers[j] * numbers[k]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        partOne();
        partTwo();
    }
}
