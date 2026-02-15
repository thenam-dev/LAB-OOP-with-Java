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

    public static int getInt(String msg, int min, int max) {
        do {
            try {
                System.out.println(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
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

    public static int getChoice(String from, String to1, String to2) {
        System.out.println("1. Convert from " + from + " to " + to1);
        System.out.println("2. Convert from " + from + " to " + to2);
        int choice = getInt("Enter your choice: ", 1, 2);
        return choice;
    }

    public static String checkInputFormat(String msg, String regex, String Format) {
        System.out.println(msg);
        String result;
        do {
            try {
                result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    throw new Exception();
                }
                if (!result.matches(regex)) {
                    System.out.println(Format);
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number!");
            }
        } while (true);
    }

//    regex:
//    +binary: [0-1]*
//    +decimal: [0-9]*
//    +hexa: [0-9A-F]*
}
