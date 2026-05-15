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

        // Students
        Student s1 = new Student("HE180111", "Nam Nguyen");
        Student s2 = new Student("HE180112", "John Smith");
        Student s3 = new Student("HE180113", "Anna Lee");

        // Semesters
        Semester sem1 = new Semester("SP26");
        Semester sem2 = new Semester("SU26");
        Semester sem3 = new Semester("FA25");

        // Add enrollments
        enrollments.add(new Enrollment(s1, sem1, Course.JAVA));
        enrollments.add(new Enrollment(s1, sem2, Course.DOT_NET));
        enrollments.add(new Enrollment(s2, sem1, Course.CPP));
        enrollments.add(new Enrollment(s3, sem3, Course.JAVA));
        enrollments.add(new Enrollment(s2, sem2, Course.DOT_NET));
        // Add studentMap
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);
        studentMap.put(s3.getId(), s3);
        //Add semesterList
        semesterList.add(sem1);
        semesterList.add(sem2);
        semesterList.add(sem3);

    }

    public void createStudent() {
        while (true) {
            //input studentId and studentName
            String id = Validation.getString("Student ID: ", "^HE\\d{6}$");
            String name = Validation.getString("Student name: ", "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$");
            //check exist
            Student st = findStudentByIdName(id, name);

            String semesterCode = Validation.getString("Semester code (v.d FA23): ", "^[A-Z]{2}\\d{2}$");
            Semester semester = getOrCreaterSemester(semesterCode);

            Course course = chooseCourse();
            //check duplicate
            if (isDuplicate(st, semester, course)) {
                System.err.println("Duplicate enrollment!!!");
            } else {
                enrollments.add(new Enrollment(st, semester, course));
                System.out.println("Add student information Successfully!");
                break;
            }
            if (enrollments.size() >= 7 && !Validation.getYesNo("Do you want to continue (Yy/Nn)? Choose Y to continue, N to return main screen")) {
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
        System.out.printf("%-15s%-20s%-10s%-8s%n", "ID", "Name", "Semester", "Course");
        for (Enrollment resultEnrollment : resultEnrollments) {
            System.out.println(resultEnrollment);
        }
    }

    public void updateAndDelete() {
        if (enrollments.isEmpty()) {
            System.err.println("Database is empty!!!");
            return;
        }
        String choice = Validation.getString("Do you want to Update or Delete? (Uu/Dd)", "^[UuDd]$").toUpperCase();
        switch (choice) {
            case "U":
                updateStudent();
                break;
            case "D":
                deleteStudent();
                break;
            default:
                System.err.println("Please input (U/u) to Update or (D/d) to Delete!");
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
            if (semester.getCode().equals(semesterCode)) {
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
                return true;
            }
        }
        return false;
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
            System.err.println("Id not found!");
            return;
        }
        showAllEnrollmentList(listById);
        int idRecord = Validation.getInt("Choose record: ", 1, listById.size());
        Enrollment updateStudent = listById.get(idRecord - 1);

        //input update
        String newName = Validation.getString("New student name: ");
        if (newName.length() > 0) {
            updateStudent.getStudent().setStudentName(newName);

            String newSemester = Validation.getString("Semester code: ", "^[A-Z]{2}\\d{2}$");
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
    }

    private void deleteStudent() {
        String id = Validation.getString("Student ID: ", "HE\\d{6}$");
        ArrayList<Enrollment> listById = getEnrollmentById(id);
        if (listById.isEmpty()) {
            System.err.println("Id not found!");
            return;
        }
        showAllEnrollmentList(listById);
        int idRecord = Validation.getInt("Choose record: ", 1, listById.size() - 1);
        Enrollment deleteStudent = listById.get(idRecord);
        enrollments.remove(deleteStudent);
        System.out.println("Delete successfully!");
    }

    public void report() {
        if (enrollments.isEmpty()) {
            System.err.println("Database is empty!");
            return;
        }
        Map<String, Integer> counter = new HashMap<>();
        for (Enrollment e : enrollments) {
            String key = String.format("%-15s|%-10s", e.getStudent().getStudentName(), e.getCourse().getName());
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }
        //duyet map de in ra
        System.out.printf("%-15s|%-10s|%-5s%n", "Student name", "Course", "Total");
        for (Map.Entry<String, Integer> entry : counter.entrySet()) { //entrySet: lay toan bo phan tu trong map
            System.out.printf("%-15s|%-5s%n", entry.getKey(), entry.getValue());
        }
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
