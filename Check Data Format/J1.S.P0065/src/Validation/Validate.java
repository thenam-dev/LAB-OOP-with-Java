/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public static double getDouble(String msg, double min, double max) {
        do {
            try {
                System.out.println(msg + ": ");
                double result = Double.parseDouble(sc.nextLine());
                if (result < min) {
                    System.err.println(msg + " is greater than equal " + (int) min);
                } else if (result > max) {
                    System.err.println(msg + " is less than equal " + (int) max);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println(msg + " is digit");
            }
        } while (true);
    }

    public static String getString(String msg, String regex, String error) {
        do {
            System.out.println(msg);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println(error);
                continue;
            }
            if (!result.matches(regex)) {
                System.err.println("Invalid format! Enter again: ");
                continue;
            }
            return result;
        } while (true);
    }

    public static boolean getYesNo(String msg) {
        do {
            System.out.println(msg);
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid! Please input (Y/N)");
            }
        } while (true);
    }
}
