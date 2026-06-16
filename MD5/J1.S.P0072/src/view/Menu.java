/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.AccountManager;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {
    public void display(){
        AccountManager m = new AccountManager();
        int choice=0;
        while(choice != 3){
            System.out.println("======= Login Program =======");
            System.out.println("1. Add user.");
            System.out.println("2. Login.");
            System.out.println("3. Exit.");
            choice = Validation.getInt("Enter your choice: ", 1, 3);
            switch(choice){
                case 1:
                    m.addUser();
                    break;
                case 2:
                    m.loginFunction();
                    break;
                case 3:
                    System.out.println("See you again!");
                    break;
            }
        }
    }
}
