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

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    System.out.println("Please input valid number in range "+min+" to "+max);
                }
                return result;
            } catch (Exception e) {
                System.out.println("Please input valid number!");
            }
        }
    }
    
    public static int[] inputBill(int size){
        int[] bills = new int[size];
        for(int i = 0; i<bills.length;i++){
            bills[i] = getInt(String.format("input value of bill %d: ", i+1), 1, Integer.MAX_VALUE);
        }
        return bills;
    }
}
