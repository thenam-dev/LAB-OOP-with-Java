/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class TaskType {

    private int taskType;
    private String taskTypeName;

    public TaskType() {
    }

    public TaskType(int taskType) {
        this.taskType = taskType;
        convertTaskTypeIntToStr(taskType);
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
        convertTaskTypeIntToStr(taskType);
    }
    
    public void setTaskType(String taskTypeName) {
        this.taskTypeName = taskTypeName;
        convertTaskTypeStrToInt(taskTypeName);
    }

    public String getTaskType() {
        return taskTypeName;
    }
    
    public int getTaskTypeInt() {
        return taskType;
    }

    public void convertTaskTypeIntToStr(int taskType) {
        this.taskType = taskType;
        switch (taskType) {
            case 1:
                this.taskTypeName = "Code";
                break;
            case 2:
                this.taskTypeName = "Test";
                break;
            case 3:
                this.taskTypeName = "Design";
                break;
            case 4:
                this.taskTypeName = "Review";
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid task type value!");
        }
    }
    
    public void convertTaskTypeStrToInt(String taskTypeName) {
        this.taskTypeName = taskTypeName;
        switch (taskTypeName) {
            case "Code":
                this.taskType = 1;
                break;
            case "Test":
                this.taskType = 2;
                break;
            case "Design":
                this.taskType = 3;
                break;
            case "Review":
                this.taskType = 4;
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid task type value!");
        }
    }
}
