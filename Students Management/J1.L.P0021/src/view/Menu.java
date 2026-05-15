/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManagerStudent;
import controller.Validation;

/**
 *
 * @author ACER
 */
public class Menu {
    public void display(){
        ManagerStudent managerStudent = new ManagerStudent();
        int choice;
        do{
            System.out.println("======WELCOME TO STUDENT MANAGEMENT======");
            System.out.println("1. Create Student");
            System.out.println("2. Find and Sort Student");
            System.out.println("3. Update or Delete Student");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            choice = Validation.getInt("Enter your choice: ", 1, 5);
            switch(choice){
                case 1:
                    managerStudent.createStudent();
                    break;
                case 2:
                    managerStudent.findAndSort();
                    break;
                case 3:
                    managerStudent.updateAndDelete();
                    break;
                case 4:
                    managerStudent.report();
                    break;
                case 5:
                    System.out.println("See you again!");
                    return;
                default:
                    System.err.println("Please choose again!");
                    break;
            }
        }while(true);
    }
}
