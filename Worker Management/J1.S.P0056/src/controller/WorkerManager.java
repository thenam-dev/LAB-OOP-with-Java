/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.SalaryHistory;
import model.Worker;

/**
 *
 * @author ACER
 */
public class WorkerManager {

    private static final String STATUS_UP = "UP";
    private static final String STATUS_DOWN = "DOWN";
    private static final String STATUS_START = "START";

    private List<Worker> listW;

    public WorkerManager() {
        listW = new ArrayList<>();
    }

    //add worker
    public void createWorker() {
        String code = getUniqueWorkerCode();
        String name = Validation.getString("Enter name worker: ", "[A-Za-z\\s]+");
        int age = Validation.getInt("Enter age worker: ", 18, 50);
        double salary = Validation.getDouble("Enter salary worker: ", 1, Double.MAX_VALUE);
        String workLocation = Validation.getString("Enter work location: ", "[A-Za-z\\s]+");
        Worker worker = new Worker(code, name, age, salary, workLocation);
        listW.add(worker);
        System.out.println("Add worker successfully!");
    }

    //up salary
    public void increaseSalary() {
        Worker worker = findWorkerByCode();
        if (worker == null) {
            return;
        }
        double amount = Validation.getDouble("Enter amount to increase: ", 1, Double.MAX_VALUE);
        double newSalary = worker.getSalary() + amount;
        updateWorkerSalary(worker, newSalary, STATUS_UP);
    }

    //down salary
    public void decreaseSalary() {
        Worker worker = findWorkerByCode();
        if (worker == null) {
            return;
        }
        double amount = Validation.getDouble("Enter amount to decrease: ", 1, Double.MAX_VALUE);
        if (worker.getSalary() <= amount) {
            System.err.println("Cancel update. Cannot decrease below zero!");
        }
        double newSalary = worker.getSalary() - amount;
        updateWorkerSalary(worker, newSalary, STATUS_DOWN);
    }

    //display information of worker
    public void displayInformation() {
        if (listW.isEmpty()) {
            System.err.println("No worker to display!");
            return;
        } else {
            System.out.printf("%-5s%-15s%-10s%-15s%-15s%-15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
            for (Worker worker : listW) {
                for (SalaryHistory history : worker.getSalaryHistory()) {
                    System.out.printf("%-5s%-15s%-10d%-15.2f%-15s%-15s\n", worker.getCode(), worker.getName(), worker.getAge(), history.getAmount(), history.getStatus(), history.getDate());
                }
            }
        }
    }

    private String getUniqueWorkerCode() {
        String code;
        Worker existingWorker;
        do {
            code = Validation.getString("Enter worker code: ", "^W\\s\\d+$");
            existingWorker = getWorker(code);
            if (existingWorker != null) {
                System.err.println("Worker has already existed!");
            }
        } while (existingWorker != null);
        return code;
    }

    private Worker getWorker(String code) {
        for (Worker w : listW) {
            if (w.getCode().equals(code)) {
                return w;
            }
        }
        return null;
    }

    private Worker findWorkerByCode() {
        Worker worker; //phai khoi tao o day
        do {
            String code = Validation.getString("Enter worker code: ", "^W\\s\\d+$");
            worker = getWorker(code);
            if (worker == null) {
                System.err.println("Worker does not exist!");
            }
        } while (worker == null);
        return worker;
    }

    private void updateWorkerSalary(Worker worker, double newSalary, String status) {
        //khi worker chua up chua down
        if (worker.getSalaryHistory().isEmpty()) {
            worker.setSalaryHistory(new SalaryHistory(STATUS_START, worker.getSalary(), LocalDate.now()));
        }
        worker.setSalary(newSalary);
        worker.setSalaryHistory(new SalaryHistory(status, newSalary, LocalDate.now()));
        System.out.println("Update salary successfully!");
    }

}
