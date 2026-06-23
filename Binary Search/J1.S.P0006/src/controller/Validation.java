/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        do {
            try {
                System.out.println(msg);
                String input = sc.nextLine().trim();
                int result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]!");
                    continue;
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number!");
            }
        } while (true);
    }
}
