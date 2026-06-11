/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Task;
import model.TaskType;

/**
 *
 * @author ACER
 */
public class TaskManager {

    private List<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<>();
    }

    private void getTaskType(TaskType taskType) {
        String[] task = {"Code", "Test", "Design", "Review"};
        printTask(task);
        int choice = Validation.getInt("Enter task type: ", 1, 4);
        taskType.setTaskId(choice);
        taskType.setDescription(task[choice - 1]);
    }

    private void printTask(String[] task) {
        System.out.println("AVAILABLE TASK");
        for (int i = 0; i < task.length; i++) {
            System.out.println((i + 1) + " = " + task[i]);
        }
    }

    public void addTask() {
        int id;
        if (taskList.isEmpty()) {
            id = 1;
        } else {
            id = taskList.get(taskList.size() - 1).getId() + 1;
        }
        String requirementName = Validation.getString("Enter requirement name: ", Validation.NAME_VALID);
        TaskType taskType = new TaskType(id, requirementName);
        getTaskType(taskType);

        String date = Validation.getDate("Enter date: ");

        double planFrom, planTo;
        do {
            planFrom = Validation.getDouble("Enter planFrom: ", 8, 17.5);
            planTo = Validation.getDouble("Enter planTo: ", planFrom + 0.5, 17.5);

            if (!checkHoursAndOverLab(requirementName, date, planFrom, planTo)) {
                System.err.println("Invalid input for time! Please enter again: ");
            } else {
                break;
            }
        } while (true);
        String assignee = Validation.getString("Enter assignee: ", Validation.NAME_VALID);
        String reviewer = Validation.getString("Enter reviewer: ", Validation.NAME_VALID);
        taskList.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer));
        System.out.println("Add task successfully!");
    }

    public void deleteTask() {
        int id = Validation.getInt("Enter ID you want to delete: ", 1, taskList.size());
        for (Task t : taskList) {
            if(t.getId() == id){
                boolean choice = Validation.getYesNo("Task found! Are you sure to delete task(Y/N)");
                if (choice) {
                    taskList.remove(t);
                    System.out.println("Delete task successfully!");
                    return;
                } else {
                    System.err.println("Cancel delete!");
                }
            }
        }
        System.err.println("ID not found in database!");
    }

    public void displayTask() {
        if(taskList.isEmpty()){
            System.err.println("No task for display!");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID","Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task t : taskList) {
            double time = t.getPlanTo() - t.getPlanFrom();
            System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", t.getId(), t.getRequirementName(), t.getTaskType().getDescription(), t.getDate(), time, t.getAssignee(), t.getReviewer());
        }
    }

    private boolean checkHoursAndOverLab(String requirementName, String date, double planFrom, double planTo) {
        double totalHours = 0;
        for (Task t : taskList) {
            //check cung nguoi cung ngay 
            if (t.getRequirementName().equals(requirementName) && t.getDate().equals(date)) {
                if (planFrom < t.getPlanTo() && planTo > t.getPlanFrom()) {
                    System.err.println("The new task must not overlap with the existing task time!");
                    return false;
                }
                totalHours += t.getPlanTo() - t.getPlanFrom();
            }
        }
        totalHours += planTo - planFrom;
        if (totalHours >= 8) {
            System.err.println("The total working hours for this requirement in 1 day cannot exceed 8 hours!");
            return false;
        }
        return true;
    }
}
