/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManagerShop;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {

    public void display() {
        ManagerShop m = new ManagerShop();
        int choice;
        do {
            System.out.println("=======Fruit Management=======");
            System.out.println("1.Create Fruit.");
            System.out.println("2.View Orders.");
            System.out.println("3.Shopping(for buyer).");
            System.out.println("4.Exit.");
            choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    m.createFruit();
                    break;
                case 2:
                    m.viewOrder();
                    break;
                case 3:
                    m.shopping();
                    break;
                case 4:
                    System.out.println("See you again!");
                    break;
            }
        } while (choice != 4);
    }
}
