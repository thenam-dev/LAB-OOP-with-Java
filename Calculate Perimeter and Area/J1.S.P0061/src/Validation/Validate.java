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
                System.out.println(msg);
                double result = Double.parseDouble(sc.nextLine());
                if (result <= min || result > max) {
                    throw new NumberFormatException();
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input valid double number!");
            }
        }while(true);
    }
}
