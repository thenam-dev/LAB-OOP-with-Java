/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TaskManagerController;
import utils.Validate;

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {
        TaskManagerController t = new TaskManagerController();
        while (true) {
            System.out.println("======Task Manager======");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            int choice = Validate.inputInt("Enter your choice: ", 1, 4);

            switch (choice) {
                case 1:
                    t.addTask();
                    break;
                case 2:
                    t.deleteTask();
                    break;
                case 3:
                    t.displayTask();
                    break;
                case 4:
                    System.out.println("Thank for using my system");
                    return;
            }
        }
    }
}
