/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.EmployeeController;
import java.util.HashMap;
import java.util.Map;
import model.Employee;
import utils.Validate;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Map<Integer, Employee> listE = new HashMap<Integer, Employee>();
//        Employee e1 = new Employee();
//        e1.setId(1);
//        e1.setName("nam");
//        Employee e2 = new Employee();
//        e2.setId(2);
//        e2.setName("mit");
//        
//        listE.put(e1.getId(), e1);
//        listE.put(e2.getId(), e2);
//        
//        System.out.println(listE.get(1)); //get key de lay obj
Validate v = new Validate();
        EmployeeController c = new EmployeeController();
        while(true) {
            System.out.println("1. Add employee");
            System.out.println("2. Display employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Search employee");
            System.out.println("5. Sort employee by salary");
            System.out.println("6. Exit");
            int choice = v.inputInt("Enter choice: ", 1, 6);
            switch(choice) {
                case 1:
                    c.addEmployee();
                    break;
                case 2:
                    c.displayEmployee();
                case 3:
//                    c.deleteEmployee();
                case 4:
//                    c.searchEmployee();
                case 5:
//                    c.sortEmployeeBySalary();
                case 6:
                    System.out.println("Thank for using my system");
                    return;
                default:
                    System.out.println("Please choose your option!");
                            
            }
        }
    }

}
