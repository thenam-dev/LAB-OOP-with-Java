/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Expense;

/**
 *
 * @author ACER
 */
public class ExpenseManager {
    List<Expense> expenseList;

    public ExpenseManager() {
        expenseList = new ArrayList<>();
    }
    
    public void addExpense(){
        String date = Validation.getDate("Enter Date: ");
        double amount = Validation.getDouble("Enter amount: ", 0, Double.MAX_VALUE);
        String content = Validation.getString("Enter Content: ",".*");
        expenseList.add(new Expense(date, amount, content));
        System.out.println("Add Expense successfully!");
    }
    
    public void displayAllInformationOfExpense(){
        if(expenseList.isEmpty()){
            System.err.println("List expense is empty!");
            return;
        } else {
            double total = 0;
            System.out.println("----- All Expense -----");
            System.out.printf("%-7s%-15s%-10s%-20s\n","ID","Date","Amount","Content");
            for (Expense e : expenseList) {
                System.out.println(e);
                total += e.getAmount();
            }
            System.out.printf("Total: %-10.0f\n",total);
        }
    }
    
    public void deleteExpense(){
        displayAllInformationOfExpense();
        if(expenseList.isEmpty()){
            System.err.println("No data to delete!");
            return;
        }
        int id = Validation.getInt("Enter id to delete: ", 1, 100);
        int index = findExpenseById(id);
        if(index != -1){
            expenseList.remove(index);
            System.out.println("Delete successfully!");
        } else {
            System.err.println("Delete failed!");
        }
    }

    private int findExpenseById(int id) {
        for (int i = 0; i < expenseList.size(); i++) {
            if(expenseList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
