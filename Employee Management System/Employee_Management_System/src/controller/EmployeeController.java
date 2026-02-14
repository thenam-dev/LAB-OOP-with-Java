/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.EmployeeManager;
import model.Employee;
import utils.Validate;

/**
 *
 * @author ACER
 */
public class EmployeeController {

    EmployeeManager employeeManager = new EmployeeManager();
    Validate v = new Validate();

    public void addEmployee() {
        Employee e = new Employee();
        do {
            e.setId(Validate.inputInt("Enter employee ID: ", 1, Integer.MAX_VALUE));
        } while (employeeManager.checkExistId(e.getId())); //check id duplicate here

        e.setName(Validate.inputString("Enter employee name: ", false));
        e.setDob(Validate.inputDate("Enter date of birth: "));
        int sex = Validate.inputInt("Input sex, 0 is male and 1 is female", 0, 1);
        e.setSex(sex == 1 ? true : false);
        e.setPhone(Validate.inputString("Enter phone number: ", false));
        employeeManager.addEmployee(e);
        System.out.println("Add employee successfully!");
    }

    public void deleteEmployee() {
        int idRemove = v.inputInt("Enter ID you want delete: ", 1, Integer.MAX_VALUE);
        //check id xem co ton tai hay ko
        if (!employeeManager.checkExistId(idRemove)) {
            System.err.println("Id not found!");
            return;
        }
        if (employeeManager.removeEmployee(idRemove) == true) {
            System.out.println("Delete employee successfully");
        } else {
            System.err.println("Delete failed!");
        }
    }

    public void displayEmployee() {
        employeeManager.showListEmployee();
    }
}
