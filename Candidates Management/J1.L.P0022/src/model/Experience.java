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
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience() {
        super(EXPERIENCE);
    }

    @Override
    public void inputExtra() {
        expInYear = Validation.checkInputExperience(birthYear,"Year experience(1-100): ");
        proSkill = Validation.getString("Professional skill: ");
    }
    
    
    
}
