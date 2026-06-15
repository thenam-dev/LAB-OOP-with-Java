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
        System.out.print(msg);
        int number = 0;
        boolean isValid = true;
        while (isValid) {
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                isValid = false;
            } catch (NumberFormatException e) {
                System.err.println("Value of matrix must be the number!");
            }
        }
        return number;
    }
}
