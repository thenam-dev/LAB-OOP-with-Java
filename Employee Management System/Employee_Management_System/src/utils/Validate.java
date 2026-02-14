/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputInt(String msg, int min, int max) {
        int result;
        do {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number!");
            }
        } while (true);
    }

    public static double inputDouble(String msg, double min, double max) {
        double result;
        do {
            try {
                System.out.println(msg);
                result = Double.parseDouble(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number!");
            }
        } while (true);
    }

    public static String inputString(String msg, boolean isEmpty) {
        String result;
        do {
            try {
                System.out.println(msg);
                result = sc.nextLine().trim();
                if (result.isEmpty() && isEmpty) {
                    System.err.println("Please input string");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input string");
            }
        } while (true);
    }

    public static String inputDate(String msg) {

        do {
            try {
                String date = inputString(msg, false);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date result = sdf.parse(date);
                if (date.equalsIgnoreCase(sdf.format(result))) {
                    return date;
                } else {
                    System.out.println("Please input date follow format dd-MM-yyyy");
                }
            } catch (Exception e) {
                System.err.println("Date must be dd-MM-yyyy");
            }
        } while (true);
    }
}
