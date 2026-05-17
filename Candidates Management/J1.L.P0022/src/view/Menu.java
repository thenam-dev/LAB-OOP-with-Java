/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManagerCandidate;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {

    public void display() {
        ManagerCandidate m = new ManagerCandidate();
        int choice;
        do {
            System.out.println("=====CANDIDATE MANAGEMENT SYSTEM=====");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            choice = Validation.getInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    m.createCandidate(0);
                    break;
                case 2:
                    m.createCandidate(1);
                    break;
                case 3:
                    m.createCandidate(2);
                    break;
                case 4:
                    m.search();
                    break;
                case 5:
                    return;
            }
        } while (choice != 5);
    }
}
