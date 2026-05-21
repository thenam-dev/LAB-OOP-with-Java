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
        double width = Validate.getDouble("Please input side width of Rectangle: ");
        double length = Validate.getDouble("Please input side length of Rectangle: ");
        Shape rectangle = new Rectangle(length, width);

        //circle.input();
        double radius = Validate.getDouble("Please input radius of Circle: ");
        Shape circle = new Circle(radius);

        //triangle.input();
        double sideA, sideB, sideC;
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
        Shape triangle = new Triangle(sideA, sideB, sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

}
