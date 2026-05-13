/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Course;
import model.Enrollment;
import model.Semester;
import model.Student;

/**
 *
 * @author ACER
 */
public class ManagerStudent {

    private Map<String, Student> studentMap;
    private List<Semester> semesterList;
    private List<Enrollment> enrollments;

    public ManagerStudent() {
        studentMap = new HashMap<>();
        semesterList = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    public void createStudent() {
        while (true) {
            //input studentId and studentName
            String id = Validation.getString("Student ID: ", "^HE\\d{6}$");
            String name = Validation.getString("Student name: ", "^[A-Z][a-z]*(\\\\s[A-Z][a-z]*)*$");

            Student st = findStudentByIdName(id, name); //check exist

            String semesterCode = Validation.getString("Semester code (v.d FA23): ", "^[A-Z]{2}\\\\d{2}$");
            Semester semester = getOrCreaterSemester(semesterCode);

            Course course = chooseCourse();

            if (isDuplicate(st, semester, course)) {
                System.out.println("Duplicate enrollment!!!");
            } else {
                enrollments.add(new Enrollment(st, semester, course));
                System.out.println("Add student information Successfully!");
            }
            if (enrollments.size() >= 3 && !Validation.getYesNo("Do you want to adding (Y/y) or (N/n)")) {
                break;
            }
        }
    }

    public void findAndSort() {
        //check enrollment exist
        if (enrollments.isEmpty()) {
            System.err.println("Database is empty!!!");
            return;
        }
        //enter keyName
        String keySearch = Validation.getString("Enter key name you want to search: ");
        //find by keyName
        ArrayList<Enrollment> resultEnrollments = findEnrollmentByKeyName(keySearch);
        //check exist
        if (resultEnrollments.isEmpty()) {
            System.out.println("No student found!");
            return;
        }
        //sort by name
        Collections.sort(resultEnrollments, new Enrollment());
        //print
        System.out.printf("%-15s%-20s-%-10s-%-8s%n", "ID", "Name", "Semester", "Course");
        for (Enrollment resultEnrollment : resultEnrollments) {
            System.out.println(resultEnrollment);
        }
    }

    public void updateAndDelete() {
        if (enrollments.isEmpty()) {
            System.err.println("Database is empty!!!");
            return;
        }

        int choice = Validation.getInt("Do you want to (1.Update | 2.Delete) ", 1, 2);
        switch (choice) {
            case 1:
                updateStudent();
                break;
            case 2:
                deleteStudent();
                break;
        }
    }

    private Student findStudentByIdName(String id, String name) {
        Student st = studentMap.get(id);
        if (st == null) {
            st = new Student(id, name);
            studentMap.put(id, st);
        } else {
            st.setStudentName(name);
        }
        return st;
    }

    private Semester getOrCreaterSemester(String semesterCode) {
        for (Semester semester : semesterList) {
            if (semester.getCode().equals(enrollments)) {
                return semester;
            }
        }
        Semester newSemester = new Semester(semesterCode);
        semesterList.add(newSemester);
        return newSemester;
    }

    private Course chooseCourse() {
        System.out.println("Course: 1.Java 2..Net 3.C/C++");
        int option = Validation.getInt("Enter your choice: ", 1, 3);
        switch (option) {
            case 1:
                return Course.JAVA;
            case 2:
                return Course.DOT_NET;
            default:
                return Course.CPP;
        }
    }

    private boolean isDuplicate(Student st, Semester semester, Course course) {
        for (Enrollment e : enrollments) {
            if (e.getStudent() == st && e.getSemester() == semester && e.getCourse() == course) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Enrollment> findEnrollmentByKeyName(String keySearch) {
        //return 1 list
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentName().toLowerCase().contains(keySearch.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    private void updateStudent() {
        //show list
        String id = Validation.getString("Student ID: ", "HE\\d{6}$");
        ArrayList<Enrollment> listById = getEnrollmentById(id);
        if (listById.isEmpty()) {
            System.out.println("Id not found!");
            return;
        }
        showAllEnrollmentList(listById);
        int idRecord = Validation.getInt("Choose record: ", 1, listById.size() - 1);
        Enrollment updateStudent = listById.get(idRecord);
        
        //input update
        String newName = Validation.getString("New name(blank to keep): ", ".*");
        if (newName.length() > 0) {
            updateStudent.getStudent().setStudentName(newName);
        }
        String newSemester = Validation.getString("Semester code: ", "^[A-Z]\\\\d{2}$");
        Semester newSem = getOrCreaterSemester(newSemester);
        Course newCourse = chooseCourse();
        
        //check exist
        if (isDuplicate(updateStudent.getStudent(), newSem, newCourse)) {
            System.err.println("Duplicate enrollment update cancelled!!!");
            return;
        }
        if (!sameSemester(updateStudent, newSem) && isSemesterFull(updateStudent.getStudent(), newSem)) {
            System.err.println("This student already has 3 courses in " + newSem.getCode() + "!");
            return;
        }
        updateStudent.setSemester(newSem);
        updateStudent.setCourse(newCourse);
        System.out.println("Updated successfully!");
    }

    private void deleteStudent() {
        String id = Validation.getString("Student ID: ", "HE\\d{6}$");
        ArrayList<Enrollment> listById = getEnrollmentById(id);
        if (listById.isEmpty()) {
            System.out.println("Id not found!");
            return;
        }
        showAllEnrollmentList(listById);
        int idRecord = Validation.getInt("Choose record: ", 1, listById.size() - 1);
        Enrollment deleteStudent = listById.get(idRecord);
        enrollments.remove(deleteStudent);
        System.out.println("Delete successfully!");
    }

    private ArrayList<Enrollment> getEnrollmentById(String id) {
        ArrayList<Enrollment> list = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getId().equals(id)) {
                list.add(enrollment);
            }
        }
        return list;
    }

    private void showAllEnrollmentList(ArrayList<Enrollment> listById) {
        int id = 1;
        for (Enrollment enrollment : listById) {
            System.out.printf("%2d) %-5s | %-6s | %s%n", id++, enrollment.getStudent().getStudentName(), enrollment.getSemester().getCode(), enrollment.getCourse().getName());
        }
    }

    private boolean sameSemester(Enrollment updateStudent, Semester newSem) {
        return updateStudent.getSemester().getCode().equals(newSem.getCode());
    }

    private boolean isSemesterFull(Student student, Semester newSem) {
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getStudent() == student && e.getSemester().getCode().equals(newSem.getCode())) {
                count++;
            }
        }
        return count >= 3;
    }
}
