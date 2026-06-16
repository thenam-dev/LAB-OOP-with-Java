/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);
    public static final String PHONE_VALID = "^\\d{10,}$";
    public static final String EMAIL_VALID = "^[A-Za-z0-9.+_%-]+@[A-Za-z-]+\\.[A-Za-z]{2,}$";
    public static final String NAME_VALID = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    public static final String ADDRESS_VALID = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";

    public static int getInt(String msg, int min, int max) {
        System.out.println(msg);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]!: ");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Input must be integer number!: ");
            }
        }
    }

    public static String getString(String msg, String regex) {
        System.out.println(msg);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please input a non-empty string!: ");
                continue;
            }
            if (!input.matches(regex)) {
                System.err.println("Please input matches regex: " + regex + " !: ");
                continue;
            }
            return input;
        }
    }

    public static boolean getYesNo(String msg) {
        System.out.println(msg);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Please input a non-empty string!");
                continue;
            }
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.err.println("You must be enter (Y/y) or (N/n) !!!:");
            }
        }
    }

    public static String getDate(String msg) {
        System.out.println(msg);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.err.println("Input can't be empty. Please input again: ");
                    continue;
                }
                Date date = dateFormat.parse(result);
                return dateFormat.format(date);
            } catch (ParseException e) {
                System.err.println("Invalid Date!. Please enter again(dd-MM-yyy): ");
            }
        }
    }
}
