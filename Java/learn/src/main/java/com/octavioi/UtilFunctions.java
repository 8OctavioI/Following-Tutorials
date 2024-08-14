package com.octavioi;

import java.util.Scanner;

public class UtilFunctions {

    private static Scanner scanner = new Scanner(System.in);

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String getInput() {
        return scanner.nextLine();
    }

    public static Integer getValidIntegerInputBetween(String fieldName, int MIN_VALUE, int MAX_VALUE) {
        String temp;
        while(true) {
            System.out.print(fieldName + ": ");
            temp = scanner.next();
            if (isNumeric(temp) && Integer.parseInt(temp) >= MIN_VALUE && Integer.parseInt(temp) <= MAX_VALUE) break;
            System.out.println(String.format("Invalid Input. Type a number between %d and %d for %s", MIN_VALUE, MAX_VALUE, fieldName));
        }
        return Integer.parseInt(temp);
    }

    public static Double getValidDoubleInputBetween(String fieldName, int MIN_VALUE, int MAX_VALUE) {
        String temp;
        while(true) {
            System.out.print(fieldName + ": ");
            temp = scanner.next();
            if (isDouble(temp) && Double.parseDouble(temp) >= MIN_VALUE && Double.parseDouble(temp) <= MAX_VALUE) break;
            System.out.println(String.format("Invalid Input. Type a number between %d and %d for %s", MIN_VALUE, MAX_VALUE, fieldName));
        }
        return Double.parseDouble(temp);
    }

}
