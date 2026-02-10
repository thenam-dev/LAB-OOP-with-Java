/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0002;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {
    public static final Scanner sc = new Scanner(System.in);
    
    public int getInt(String msg, int min, int max) {
        while(true) {
            try{
                System.out.println(msg);
                int a = Integer.parseInt(sc.nextLine());
                if(a<min || a>max) {
                    throw new Exception();
                }
                return a;
            }catch(Exception e) {
                System.err.println("Please input valid int!");
            }
        }
    }
}
