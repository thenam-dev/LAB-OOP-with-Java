/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

/**
 *
 * @author ACER
 */
public class ManagerCandidate {

    List<Candidate> listC;

    public ManagerCandidate() {
        listC = new ArrayList<>();
    }

    public void createCandidate(int type) {
        Candidate c;
        switch (type) {
            case Candidate.EXPERIENCE:
                c = new Experience();
                break;
            case Candidate.FRESHER:
                c = new Fresher();
                break;
            case Candidate.INTERN:
                c = new Intern();
                break;
            default:
                System.err.println("Type must be 0-2!");
                return;
        }
        c.inputCommon();
        c.inputExtra();
        listC.add(c);
        System.out.println("Create Successfully!");
        if (Validation.getYesNo("Do you want to continue function (Y/y) or (N/n): ")) {
            createCandidate(type);
        }
    }

    public void search() {
        showAllCandidate();
        String key = Validation.getString("Input name (first/last): ").toLowerCase();
        int type = Validation.getInt("Input type of candidate (0-2): ", 0, 2);
        System.out.println("\nThe candidates found:");
        boolean found = false;
        for (Candidate c : listC) {
            boolean matchType = c.getType() == type;
            boolean matchName = c.getFullName().toLowerCase().contains(key);
            if (matchType && matchName) {
                System.out.println(c.toString());
                found = true;
            }
        }
        if (!found) {
            System.err.println("No candidate matched!");
        }

    }

    private void showAllCandidate() {
        System.out.println("List of candidate: ");
        for (int i = 0; i <= 2; i++) {
            System.out.println("===== " + Candidate.typeName(i).toUpperCase() + " CANDIDATE =====");
            for (Candidate c : listC) {
                if (c.getType() == i) {
                    System.out.println(c.getFullName());
                }
            }
        }
        System.out.println("--------------------------------------");
    }
}
