/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author ACER
 */
public class Enrollment implements Comparator<Enrollment>{
    private Student student;
    private Semester semester;
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Student student, Semester semester, Course course) {
        this.student = student;
        this.semester = semester;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int compare(Enrollment o1, Enrollment o2) {
        return o1.getStudent().getStudentName().compareTo(o2.getStudent().getStudentName());
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s-%-10s-%-8s%", student.getId(), student.getStudentName(),semester.getCode(),course.getName());
    }

    
}
