/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.TaskManager;
import model.Task;
import utils.Validate;

/**
 *
 * @author ACER
 */
public class TaskManagerController {

    Validate v = new Validate();
    TaskManager taskManager;

    public TaskManagerController() {
        taskManager = new TaskManager();
    }

    public void addTask() {
        Task task = new Task();

        //input for task
        String requirementName = v.inputNameFormat("Enter requirement name: ");
        String date = v.inputDate("Enter date: ");
        int taskType = v.inputInt("Enter task type: ", 1, 4);
        double from = v.inputDouble("Enter from time: ", 8.0, 17);
        double to = v.inputDouble("Enter to time: ", from + 0.5, 17.5);
        String assignee = v.inputString("Enter assignee: ", false);
        String reviewer = v.inputString("Enter reviewer: ", false);

        if (taskManager.checkExistTask(task)) {
            System.out.println("This task already added");
        } else {
            int id = taskManager.addTask(taskType, requirementName, date, from, to, assignee, reviewer);

            if (id == -1) {
                System.err.println("Add task failed!");
            } else {
                System.out.println("Add task successfully");
            }
        }

    }

    public void displayTask() {
        if (taskManager.isEmpty()) {
            System.out.println("List task is empty!");
        } else {
            taskManager.displayTask();
        }
    }

    public void deleteTask() {
        if (taskManager.isEmpty()) {
            System.err.println("Task list is empty so can not delete!");
        }

        int taskId = v.inputInt("Enter task id: ", 1, Integer.MAX_VALUE);

        if (taskManager.deleteTaskById(taskId)) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete fail!");
        }
    }
}
