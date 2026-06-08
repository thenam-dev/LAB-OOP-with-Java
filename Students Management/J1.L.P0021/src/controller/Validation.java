/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static final String ID_VALID = "^HE\\d{6}$";
    public static final String NAME_VALID = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    public static final String SEMESTER_VALID = "^[A-Z]{2}\\d{2}$";

    public static int getInt(String msg, int min, int max) {
        System.out.println(msg);
        int number = 0;
        boolean isValid = true;
        while (isValid) {
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number < min || number > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]!: ");
                } else {
                    isValid = false;
                }
            } catch (NumberFormatException e) {
                System.err.println("Input must be integer number!: ");
            }
        }
        return number;
    }

    public static String getStringAllowEmpty(String msg) {
        System.out.println(msg);
        String input = sc.nextLine().trim();
        return input;
    }

    public static String getString(String msg, String regex) {
        System.out.println(msg);
        boolean isValid = true;
        String input = null;
        while (isValid) {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please input a non-empty string!: ");
                continue;
            }
            if (!input.matches(regex)) {
                System.err.println("Please input matches regex: " + regex + " !: ");
                continue;
            }
            isValid = false;
        }
        return input;
    }

    public static boolean getYesNo(String msg) {
        System.out.println(msg);
        boolean isValid = true;
        boolean result = true;
        while (isValid) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Please input a non-empty string!");
                continue;
            }
            if (input.equalsIgnoreCase("y")) {
                result = true;
                isValid = false;
            } else if (input.equalsIgnoreCase("n")) {
                result = false;
                isValid = false;
            } else {
                System.err.println("You must be enter (Y/y) or (N/n) !!!:");
            }
        }
        return result;
    }
}
