/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Employee {

    private int id;
    private String name;
    private String phone;
    private String dob;
    private boolean sex;

    public Employee() {
    }

    public Employee(int id, String name, String phone, String dob, boolean sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", dob=" + dob + ", sex=" + sex + '}';
    }

}
