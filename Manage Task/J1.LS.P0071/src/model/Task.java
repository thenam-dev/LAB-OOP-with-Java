/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Task {

    private int id;
    private int taskType;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int taskType, String requirementName, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public String convertTaskTypeIntToStr(int taskType) {
        switch (taskType) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                throw new IndexOutOfBoundsException("Invalid task type value!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskType() {
        return this.convertTaskTypeIntToStr(this.taskType);
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    @Override
    public boolean equals(Object obj) {
        Task task = (Task) obj;
        if (this.requirementName.equals(task.requirementName) && this.date.equals(task.date) && this.getTaskType().equals(task.getTaskType()) && this.planFrom == task.planFrom && this.planTo == task.planTo && this.assignee.equals(task.assignee) && this.reviewer.equals(task.reviewer)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("|   %-5s|       %-13s|      %-7s|   %-11s|   %-10s|\n", id, requirementName, planFrom - planTo, assignee, reviewer);
    }

}
