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

    public static int getInt(String msg) {
        int number;
        do {
            try {
                System.out.println(msg);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.err.println("Input can't be empty!");
                }
                number = Integer.parseInt(result);
                if (number <= 0) {
                    System.err.println("Number must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                number = -1;
                System.err.println("Please input valid number!");
            }
        } while (number <= 0);
        return number;
    }
    
    public static int getIntInRange(String msg,int min,int max) {
        int number;
        do {
            try {
                System.out.println(msg);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.err.println("Input can't be empty!");
                }
                number = Integer.parseInt(result);
                if (number < min || number > max) {
                    System.err.println("Number must be in range["+min+", "+max+"] !");
                }
            } catch (NumberFormatException e) {
                number = -1;
                System.err.println("Please input valid number!");
            }
        } while (number <= 0);
        return number;
    }

    public static int getIntEmpty(String msg) {
        int number;
        do {
            try {
                System.out.println(msg);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    return -1;
                }
                number = Integer.parseInt(result);
                if (number <= 0) {
                    System.err.println("Number must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                number = -1;
                System.err.println("Please input valid number!");
            }
        } while (number <= 0);
        return number;
    }

    public static String getString(String msg, String regex) {
        System.out.println(msg);
        do {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Please input non-empty string!");
                continue;
            }
            if (!input.matches(regex)) {
                System.err.println("Please input matches regex : " + regex);
                continue;
            }
            return input;
        } while (true);
    }

    public static String getStringEmpty(String msg, String regex) {
        System.out.println(msg);
        do {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return input;
            }
            if (!input.matches(regex)) {
                System.err.println("Please input matches regex : " + regex);
                continue;
            }
            return input;
        } while (true);
    }

    public static boolean getYesNo(String msg) {
        System.out.println(msg);
        while(true){
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                System.err.println("Please input a non-empty string!");
                continue;
            }
            if(input.equalsIgnoreCase("y")){
                return true;
            } else if (input.equalsIgnoreCase("n")){
                return false;
            } else {
                System.err.println("You must be enter (Y/y) or (N/n) !!!:");
            }
        }
    }
}
