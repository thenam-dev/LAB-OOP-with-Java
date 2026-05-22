/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DoctorHash;
import controller.Validation;
import model.Doctor;

/**
 *
 * @author ACER
 */
public class Menu {

    public void display() {
        DoctorHash doctorHash = new DoctorHash();
        int choice;
        do {
            System.out.println("=====Doctor Management=====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            choice = Validation.getIntInRange("Enter your choice: ", 1, 5);
            switch(choice){
                case 1:
                    doctorHash.addDoctor();
                    break;
                case 2:
                    doctorHash.updateDoctor();
                    break;
                case 3:
                    doctorHash.deleteDoctor();
                    break;
                case 4:
                    doctorHash.searchDoctor();
                    break;
                case 5:
                    System.out.println("See you again!");
                    break;
            }
        } while (choice != 5);
    }
}
