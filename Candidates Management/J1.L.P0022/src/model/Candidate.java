/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Validation;
import java.time.Year;

/**
 *
 * @author ACER
 */
public abstract class Candidate {

    public static final int EXPERIENCE = 0;
    public static final int FRESHER = 1;
    public static final int INTERN = 2;

    private static int count = 1;

    private int id;
    protected String firstName;
    protected String lastName;
    protected int birthYear;
    protected String address;
    protected String phone;
    protected String email;
    protected int type;

    protected Candidate(int type) {
        id = count++;
        this.type = type;
    }

    public void inputCommon() {
        firstName = Validation.getString("First name: ", Validation.NAME_VALID);
        lastName = Validation.getString("Last name: ", Validation.NAME_VALID);
        birthYear = Validation.getInt("Birth year (1900-" + Year.now().getValue() + "): ", 1900, Year.now().getValue());
        address = Validation.getString("Address: ", Validation.ADDRESS_VALID);
        phone = Validation.getString("Phone: ", Validation.PHONE_VALID);
        email = Validation.getString("Email: ", Validation.EMAIL_VALID);
    }

    public abstract void inputExtra();

    public static String typeName(int t) {
        switch (t) {
            case EXPERIENCE:
                return "Experience";
            case FRESHER:
                return "Fresher";
            default:
                return "Intern";
        }
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Candidate.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-6s | %-15s | %-12s | %-25s | %d",getFullName(),birthYear,address,phone,email,getType() );
    }
    
    
}
