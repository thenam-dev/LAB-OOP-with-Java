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
public class Fresher extends Candidate{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        super(FRESHER);
    }

    @Override
    public void inputExtra() {
        graduationDate = Validation.getDate("Graduation date: ");
        graduationRank = Validation.checkInputGraduationRank("Rank (Excellent/Good/Fair/Poor): ");
        education = Validation.getString("University: ");
    }
    
}
