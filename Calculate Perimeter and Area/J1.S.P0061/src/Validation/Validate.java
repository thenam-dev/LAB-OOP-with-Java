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

    public static double getDouble(String msg) {
        double result;
        do {
            try {
                System.out.println(msg);
                result = Double.parseDouble(sc.nextLine().trim());
                if (result <= 0) {
                    System.err.println("Number must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                result = -1;
                System.err.println("Please input valid double number!");
            }
        } while (result <= 0);
        return result;
    }

    public static boolean checkTriangle(double sideA, double sideB, double sideC) {
        if (sideA + sideB > sideC && sideB + sideC > sideA && sideC + sideA > sideB) {
            return true;
        } else {
            return false;
        }
    }
}
