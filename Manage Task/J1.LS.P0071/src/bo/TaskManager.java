/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author ACER
 */
public class TaskManager {

    private List<Task> listTask;
    private int lastId;

    public TaskManager() {
        listTask = new ArrayList<>();
        lastId = 0;
    }

    public boolean isEmpty() {
        if (listTask.size() == 0) {
            return true;
        }
        return false;
    }
    
    public boolean checkExistTask(Task t) {
        for(Task task : listTask){
            if(t.equals(task)) {
                return true;
            }
        }
        return false;
    }
    

    public int addTask(int TaskTypeID, String RequirementName, String Date, double planFrom, double planTo, String Assignee, String Reviwer) {
        try {
            Task task = new Task();
            task.setId(++lastId);
            task.setRequirementName(RequirementName);
            task.setDate(Date);
            task.setPlanFrom(planFrom);
            task.setPlanTo(planTo);
            task.setAssignee(Assignee);
            task.setReviewer(Reviwer);
            if (listTask.add(task)) { //add task to list
                return task.getId();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public void displayTask() {
        for (Task t : listTask) {
            System.out.println(t);
        }
    }
    
    public boolean deleteTaskById(int id){
        for(Task t:listTask) {
            if(t.getId() == id){
                listTask.remove(t);
                return true;
            }
        }
        return false;
    }
}
