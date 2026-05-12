/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.Function;
import controller.Validation;
import model.Person;

/**
 *
 * @author ACER
 */
public class J1SP0060_official {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("======Shopping Program======");
        int number = Validation.getInt("input number of bill: ", 1, Integer.MAX_VALUE);
        
        int[] numberOfBill = Validation.inputBill(number);
        
        Function f = new Function();
        int total = f.calcTotal(numberOfBill);
        
        int amount = Validation.getInt("input value of wallet: ", 1, Integer.MAX_VALUE);
        
        Person p = new Person(amount);
        p.printResultCompare(total);
        
    }

}
