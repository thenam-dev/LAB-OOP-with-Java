/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program;

import Validation.Validate;
import object.Circle;
import object.Rectangle;
import object.Shape;
import object.Triangle;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //rectangle.input();
        Rectangle rectangle = new Rectangle();
        double width = Validate.getDouble("Please input side width of Rectangle: ");
        double length = Validate.getDouble("Please input side length of Rectangle: ");
        rectangle.setLength(length);
        rectangle.setWidth(width);

        //circle.input();
        Circle circle = new Circle();
        double radius = Validate.getDouble("Please input radius of Circle: ");
        circle.setRadius(radius);

        //triangle.input();
        double sideA, sideB, sideC;
        Triangle triangle = new Triangle();
        boolean isTriangle;
        do {
            sideA = Validate.getDouble("Please input side A of Triangle: ");
            sideB = Validate.getDouble("Please input side B of Triangle: ");
            sideC = Validate.getDouble("Please input side C of Triangle: ");
            if (Validate.checkTriangle(sideA, sideB, sideC)) {
                isTriangle = true;
                break;
            } else {
                isTriangle = false;
                System.err.println("Input triangle not valid. Enter again!");
            }
        } while (!isTriangle);
        triangle.setSideA(sideA);
        triangle.setSideB(sideB);
        triangle.setSideC(sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

}
