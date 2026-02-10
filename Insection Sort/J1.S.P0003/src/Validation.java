
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
    public static final Scanner sc = new Scanner(System.in);
    
    public int getInt(String msg, int min, int max) {
        while(true) {
            try{
                System.out.println(msg);
                int n = Integer.parseInt(sc.nextLine());
                if(n<min || n>max) {
                    throw new Exception();
                }
                return n;
            }catch (Exception e) {
                System.out.println("Please input valid int!");
            }
        }
    }
}
