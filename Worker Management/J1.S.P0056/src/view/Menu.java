/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Validation;
import controller.WorkerManager;

/**
 *
 * @author ACER
 */
public class Menu {

    public void display() {
        WorkerManager workerManager = new WorkerManager();
        int choice;
        do {
            System.out.println();
            System.out.println("======WELCOME TO WORKER MANAGEMENT======");
            System.out.println("1. Add worker.");
            System.out.println("2. Up salary");
            System.out.println("3. Down Salary");
            System.out.println("4. Display information of salary");
            System.out.println("5. Exit");
            choice = Validation.getInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    workerManager.createWorker();
                    break;
                case 2:
                    workerManager.increaseSalary();
                    break;
                case 3:
                    workerManager.decreaseSalary();
                    break;
                case 4:
                    workerManager.displayInformation();
                    break;
                case 5:
                    System.out.println("See you again!");
                    return;
            }

        } while (true);
    }
}
