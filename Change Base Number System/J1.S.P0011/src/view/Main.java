/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Validation.Validate;
import model.Binary;
import model.Decimal;
import model.HexaDecimal;

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {
        Binary b = new Binary();
        Decimal d = new Decimal();
        HexaDecimal h = new HexaDecimal();
        do {

            System.out.println("======Change Base System Program======");
            System.out.println("1. Change Binary");
            System.out.println("2. Change Decimal");
            System.out.println("3. Change HexaDecimal");
            System.out.println("4. Exit");
            int choice = Validate.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    b.inputBinary();
                    b.convertFromBinary();
                    break;
                case 2:
                    d.inputDecimal();
                    d.convertFromDecimal(d.getDecimal());
                    break;
                case 3:
                    h.inputHexa();
                    h.convertFromHexa();
                    break;
                case 4:
                    System.out.println("Thank for your using my system!");
                    return;
                default:
                    System.err.println("Please input valid option");
            }
        } while (true);
    }
}
