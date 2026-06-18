/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ExpenseManager;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {
    public void display(){
        ExpenseManager m = new ExpenseManager();
        int choice;
        do {
            System.out.println("=======Handy Expense Program=======");
            System.out.println("1.Add an expense.");
            System.out.println("2.Display all expenses.");
            System.out.println("3.Delete an expense.");
            System.out.println("4.Exit.");
            choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    m.addExpense();
                    break;
                case 2:
                    m.displayAllInformationOfExpense();
                    break;
                case 3:
                    m.deleteExpense();
                    break;
                case 4:
                    System.out.println("See you again!");
                    break;
            }
        } while (choice != 4);
    }
}
