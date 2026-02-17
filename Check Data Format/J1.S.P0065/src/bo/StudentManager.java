/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import Validation.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;

/**
 *
 * @author ACER
 */
public class StudentManager {

    List<Student> studentList;
    private Map<String, Double> percentMap;

    public StudentManager() {
        this.studentList = new ArrayList<Student>();
        percentMap = new HashMap<>();
    }

    public void createStudent() {
        while (true) {
            String studentName = Validate.getString("Enter student name: ", "^[A-Z]+(?:[A-Za-z]+)*$", "Name student not empty!");
            String className = Validate.getString("Enter class: ", "^FU.*\\d{2}$", "Class code not empty!");
            double math = Validate.getDouble("Maths", 0, 10);
            double chemistry = Validate.getDouble("Chemistry", 0, 10);
            double physics = Validate.getDouble("Physics", 0, 10);
            studentList.add(new Student(studentName, className, math, physics, chemistry));
            boolean check = Validate.getYesNo("Do you want to enter more student information?(Y/N)");
            if (!check) {
                break;
            }
        }
    }

    public void getPercentTypeStudent() {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;

        for (Student s : studentList) {
            if (s.getType().equals("A")) {
                countA++;
            } else if (s.getType().equals("B")) {
                countB++;
            } else if (s.getType().equals("C")) {
                countC++;
            } else if (s.getType().equals("D")) {
                countD++;
            }
        }

        int totalStudent = studentList.size();
        percentMap.put("A", 100.0 * countA / totalStudent);
        percentMap.put("B", 100.0 * countB / totalStudent);
        percentMap.put("C", 100.0 * countC / totalStudent);
        percentMap.put("D", 100.0 * countD / totalStudent);

    }

    public void displayInformation() {
        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println("------Classification Info------");
        for (Map.Entry<String, Double> entry : percentMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ": " + String.format("%.2f", value));
        }

    }
}
