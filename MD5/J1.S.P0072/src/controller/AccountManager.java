/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.User;
import utils.MD5Hash;

/**
 *
 * @author ACER
 */
public class AccountManager {

    private List<User> userList;

    public AccountManager() {
        userList = new ArrayList<>();
        userList.add(new User("thenam", "123", "Nam", "1234567890", "a@gmail.com", "Hanoi", "28-01-2004"));
    }

    public void addUser() {
        String username;
        User user;
        while (true) {
            username = Validation.getString("Account: ", ".+");
            user = findUserByUsername(username);
            if (user != null) {
                System.err.println("User has already exist!");
            } else {
                break;
            }
        }
        String password = MD5Hash.MD5Encryption(Validation.getString("Password: ", ".+"));
        String name = Validation.getString("Name: ", Validation.NAME_VALID);
        String phone = Validation.getString("Phone: ", Validation.PHONE_VALID);
        String email = Validation.getString("Email: ", Validation.EMAIL_VALID);
        String address = Validation.getString("Address: ", Validation.ADDRESS_VALID);
        String date = Validation.getDate("Date od birth: ");
        user = new User(username, password, name, phone, email, address, date);
        userList.add(user);
        System.out.println("Add user successfully!");
    }

    public void loginFunction() {
        if (userList.isEmpty()) {
            System.err.println("No data for implement!");
            return;
        }
        while (true) {
            String username = Validation.getString("Account: ", ".+");
            String password = Validation.getString("Password: ", ".+");
            User loggerUser = findUserByUserNameAndPassword(username, password);
            if (loggerUser != null) {
                System.out.println("------- WELCOME -------");
                System.out.println("Hi " + loggerUser.getName());
                boolean choice = Validation.getYesNo("Do you want to change your password?(Y/N): ");
                if (choice) {
                    changePassword(loggerUser);
                } else {
                    break;
                }
            } else {
                System.err.println("Login failed. Incorrect username or password!");
            }
        }
    }

    private User findUserByUsername(String username) {
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    private User findUserByUserNameAndPassword(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null) {
            String encryptedInputPass = MD5Hash.MD5Encryption(password);
            if (encryptedInputPass.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    private void changePassword(User loggerUser) {
        while (true) {
            String oldPassword = Validation.getString("Enter old password: ", ".+");
            String encryptedOldPassword = MD5Hash.MD5Encryption(oldPassword);
            if (!encryptedOldPassword.equals(loggerUser.getPassword())) {
                System.err.println("Incorrected old password. Please try again!");
            }
            String newPassword = Validation.getString("Enter new password: ", ".+");
            String renewPassword = Validation.getString("Enter new password again: ", ".+");
            if(!newPassword.equals(renewPassword)){
                System.err.println("New password do not match. Please try again: ");
                continue;
            }
            String encryptedNewPassword = MD5Hash.MD5Encryption(newPassword);
            loggerUser.setPassword(encryptedNewPassword);
            System.out.println("Change password successfully!");
            break;
        }
    }
}
