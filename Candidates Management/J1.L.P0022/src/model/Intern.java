/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Validation;

/**
 *
 * @author ACER
 */
public class Intern extends Candidate{
    private String majors;
    private String semester;
    private String university;

    public Intern() {
        super(INTERN);
    }

    @Override
    public void inputExtra() {
        majors = Validation.getString("Majors: ");
        semester = Validation.getString("Semester: ");
        university = Validation.getString("University: ");
    }
    
}
