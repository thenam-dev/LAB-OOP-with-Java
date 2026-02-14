/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.HashMap;
import java.util.Map;
import model.Employee;

/**
 *
 * @author ACER
 */
public class EmployeeManager {

    Map<Integer, Employee> listEmployee;

    public EmployeeManager() {
        listEmployee = new HashMap<Integer, Employee>();
    }

    public Employee addEmployee(Employee e) {
        return listEmployee.put(e.getId(), e);
    }

    public boolean checkExistId(int idCheck) {
        if (listEmployee.get(idCheck) != null) {
            return true;
        }
        return false;
    }
    
    public boolean updateEmployee(Employee e){
        try{
            this.removeEmployeeById(e.getId());
            listEmployee.put(e.getId(), e);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public Employee getEmployeeById(int id) {
        return listEmployee.get(id);
    }

    public boolean removeEmployeeById(int id) {
        return listEmployee.remove(id, listEmployee.get(id));
    }

    public void showListEmployee() {
        System.out.println(listEmployee);
    }
    
//    public void sortEmployeeBySalary(){
//        List<Employee> empList = new 
//    }

    public Employee findEmployeeByName(String name) {
        for(Map.Entry<Integer,Employee> item : listEmployee.entrySet()) { //duyet map
            String nameOfEmployee = item.getValue().getName();
            if(nameOfEmployee.toLowerCase().contains(name.toLowerCase())) {
                return item.getValue();
            }
        }
        return null;
    }
}
