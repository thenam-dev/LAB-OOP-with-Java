/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import model.Doctor;

/**
 *
 * @author ACER
 */
public class DoctorHash {

    private Map<String, Doctor> mapDoctor;

    public DoctorHash() {
        mapDoctor = new HashMap<>();
    }

    public void addDoctor() {
        Doctor doctor;
        String code;
        do {
            code = Validation.getString("Enter code: ", "^DOC\\s\\d+$");
            doctor = mapDoctor.get(code);
            if (doctor != null) {
                System.out.println("Doctor have been exist!");
            }
        } while (doctor != null);
        String name = Validation.getString("Enter name: ", "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$");
        String specialization = Validation.getString("Enter Specialization: ", "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$");
        int availability = Validation.getInt("Enter availability: ");
        doctor = new Doctor(code, name, specialization, availability);
        mapDoctor.put(code, doctor);
        System.out.println("Add doctor successfully");
    }

    public void updateDoctor() {
        Doctor updateDoctor;
        if (mapDoctor.isEmpty()) {
            System.err.println("Database does not exist!");
            return;
        } else {
            do {
                String code = Validation.getString("Enter code: ", "^DOC\\s\\d+$");
                updateDoctor = mapDoctor.get(code);
                if (updateDoctor == null) {
                    System.err.println("Doctor code does not exist!");
                } else {
                    String name = Validation.getStringEmpty("Enter name: ", "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$");
                    if (!name.isEmpty()) {
                        updateDoctor.setName(name);
                    }
                    String specialization = Validation.getStringEmpty("Enter Specialization: ", "^[A-Z][a-z]\\s+");
                    if (!specialization.isEmpty()) {
                        updateDoctor.setSpecialization(specialization);
                    }
                    int availability = Validation.getIntEmpty("Enter availability: ");
                    if (availability != -1) {
                        updateDoctor.setAvailability(availability);
                    }
                }
                boolean check = Validation.getYesNo("Do you want to continue updating? (Y/y) or (N/n): ");
                if (!check) {
                    break;
                }
            } while (true);
        }
    }

    public void deleteDoctor() {
        if (mapDoctor.isEmpty()) {
            System.err.println("Database does not exist!");
            return;
        } else {
            String code = Validation.getString("Enter code: ", "^DOC\\s\\d+$");
            Doctor doctorDelete = mapDoctor.get(code);
            if (doctorDelete == null) {
                System.err.println("Doctor does not exist in the database!");
            } else {
                mapDoctor.remove(code);
                System.out.println("Delete doctor successfully!");
            }
        }
    }

    public void searchDoctor() {
        System.out.println("Search option.");
        System.out.println("1. Search by code.");
        System.out.println("2. Search by name.");
        System.out.println("3. Search by specialization.");
        int choice = Validation.getIntInRange("Enter your choice: ", 1, 3);

        switch (choice) {
            case 1:
                searchByCode();
                break;
            case 2:
                searchByName();
                break;
            case 3:
                searchBySpecialization();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void searchByCode() {
        String code = Validation.getString("Enter code: ", "^DOC\\s\\d+$");
        Doctor doctor = mapDoctor.get(code);
        if(doctor == null){
            System.err.println("Doctor not found!");
        } else {
            System.out.println("Doctor information");
            System.out.println(doctor);
        }
    }

    private void searchByName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void searchBySpecialization() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
