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

    //Validate Int
    public static int inputInt(String msg, int min, int max) {
        int result;
        do {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.err.println("Please input int in range " + min + " to " + max);
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number");
            }
        } while (true);
    }

    //Validate double
    public static double inputDouble(String msg, double min, double max) {
        double result;
        do {
            try {
                System.out.println(msg);
                result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.err.println("Please input double in range " + min + " to " + max);
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number");
            }
        } while (true);
    }

    //Validate Str
    public static String inputString(String msg, boolean isEmpty) {
        String result;
        do {
            System.out.println(msg);
            result = sc.nextLine();
            if (result.trim().isEmpty() && !isEmpty) {
                System.err.println("Please input string");
            } else {
                return result;
            }
        } while (true);
    }

    //Validate Str
    public static String inputString(String msg, boolean isEmpty, String regex, String Format) {
        String result;
        do {
            System.out.println(msg);
            result = sc.nextLine();
            if (result.trim().isEmpty() && !isEmpty) {
                System.err.println("Please input string");
            } else if (!result.matches(regex)) {
                System.err.println(Format);
            } else {
                return result;
            }
        } while (true);
    }

    //Validate name format
    public static String inputNameFormat(String msg) {
        //validate name just contain alphabet and space and length < 50
        return inputString(msg, false, "^[a-zA-Z\\s]{1,50}$", "Please input name just contain alphabet and space");
    }

    //Validate date format
    public static String inputDate(String msg) {
        while (true) {
            try {
                String date = inputString(msg, false);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); //Format date
                Date result = sdf.parse(date);

                if (date.equalsIgnoreCase(sdf.format(result))) {
                    return date;
                } else {
                    System.out.println("Please input date follow format dd-MM-yyyy");
                }
            } catch (Exception e) {
                System.err.println("Date must be dd-MM-yyyy!");
            }
        }
    }
}
