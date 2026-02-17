/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Student {
    
    private static int count = 1;
    private int id;
    private String studentName;
    private String className;
    private String type;
    private double math;
    private double physical;
    private double chemistry;
    private double average;
    
    public Student() {
    }
    
    public Student(String studentName, String className, double math, double physical, double chemistry) {
        id = count++;
        this.studentName = studentName;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        averageStudent();
        getTypeByAverage();
        
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public double getMaths() {
        return math;
    }
    
    public void setMaths(double math) {
        this.math = math;
    }
    
    public double getPhysical() {
        return physical;
    }
    
    public void setPhysical(double physical) {
        this.physical = physical;
    }
    
    public double getChemistry() {
        return chemistry;
    }
    
    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }
    
    public double getAverage() {
        return average;
    }
    
    public void setAverage(double average) {
        this.average = average;
    }
    
    private void averageStudent() {
        average = (math + physical + chemistry) / 3;
    }
    
    private void getTypeByAverage() {
        if (average > 7.5) {
            type = "A";
        } else if (average <= 7.5 && average >= 6) {
            type = "B";
        } else if (average < 6 && average >= 4) {
            type = "C";
        } else {
            type = "D";
        }
    }
    
    @Override
    public String toString() {
        return "------Student" + id + " Info------\n"
                + "Name: " + studentName + "\n"
                + "Classes: " + className + "\n"
                + "AVG: " + String.format("%.2f", average) + "\n"
                + "Type: " + type;
    }
    
}
