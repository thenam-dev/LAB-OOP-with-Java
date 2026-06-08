/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public enum Course {
    JAVA("Java"),
    DOT_NET(".Net"),
//    PYTHON("Python"),
    CPP("C/C++");
    
    private final String name;

    private Course(String name) { //phai co constructor ko la bao loi
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
