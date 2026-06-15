/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Calculator;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {

    public void display() {
        Calculator c = new Calculator();
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n======Calculator======");
            System.out.println("1. Addition Matrix.");
            System.out.println("2. Subtraction Matrix.");
            System.out.println("3. Multiplication Matrix.");
            System.out.println("4. Quit.");
            choice = Validation.getInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    c.addittionMatrix();
                    break;
                case 2:
                    c.subtractionMatrix();
                    break;
                case 3:
                    c.multiplicationMatrix();
                    break;
                case 4:
                    System.out.println("See you again!");
                    break;
            }
        }
    }
}
