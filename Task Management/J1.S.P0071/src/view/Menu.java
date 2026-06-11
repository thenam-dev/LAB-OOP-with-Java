/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskManager;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {

    public void display() {
        TaskManager m = new TaskManager();
        int choice;
        do {
            System.out.println("=======TASK MANAGEMENT=======");
            System.out.println("1. Add Task.");
            System.out.println("2. Delete Task.");
            System.out.println("3. Show Task.");
            System.out.println("4. Exit.");
            choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    m.addTask();
                    break;
                case 2:
                    m.deleteTask();
                    break;
                case 3:
                    m.displayTask();
                    break;
                case 4:
                    System.out.println("See you again!");
                    return;
            }
        } while (choice != 4);
    }
}
