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
    
    public static double getDouble(String msg, double min, double max) {
        System.out.println(msg);
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]!: ");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Input must be real number!: ");
            }
        }
    }
    
    public static String getString(String msg) {
        System.out.println(msg);
        while(true){
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.err.println("Please input a non-empty string!");
                continue;
            }
            return input;
        }
    }

    public static String getString(String msg, String regex) {
        System.out.println(msg);
        while(true){
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Please input a non-empty string!: ");
                continue;
            }
            if(!input.matches(regex)){
                System.err.println("Please input matches regex: "+ regex + " !: ");
                continue;
            }
            return input;
        }
    }
}
