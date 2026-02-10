
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max) {
        while(true) {
            try {
                System.out.println(msg);
                int a = Integer.parseInt(sc.nextLine());
                if (a<min || a>max) {
                    throw new Exception();
                }
                return a; 
            } catch(Exception e) {
                System.err.println("Please input int in range " + min + " to " + max);
            }
        }
    }
    
    public static double getDouble(String msg,double min, double max) {
        while(true) {
            try {
                System.out.println(msg);
                double a = Double.parseDouble(sc.nextLine());
                if (a<min || a>max) {
                    throw new Exception();
                }
                return a; 
            } catch(Exception e) {
                System.err.println("Please input double in range " + min + " to " + max);
            }
        }
    }
    
    public static String getString(String msg) {
        while(true) {
            try {
                System.out.println(msg);
                String str = sc.nextLine().trim();
                if(str.isEmpty()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println("Plese input valid string!");
            }
        }
    }
}
