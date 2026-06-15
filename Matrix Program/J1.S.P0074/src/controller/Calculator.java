/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Matrix;

/**
 *
 * @author ACER
 */
public class Calculator {
    private Matrix matrixOne;
    private Matrix matrixTwo;

    public Calculator() {
        matrixOne = new Matrix();
        matrixTwo = new Matrix();
    }
    
    public void addittionMatrix(){
        System.out.println("------ Addition ------");
        matrixOne.inputMatrix("Matrix 1");
        matrixTwo.inputMatrix("Matrix 2");
        System.out.println("------ Result ------");
        if(matrixOne.getRow() == matrixTwo.getRow() && matrixOne.getCol() == matrixTwo.getCol()){
            matrixOne.printMatrix();
            System.out.println("+");
            matrixTwo.printMatrix();
            System.out.println("=");
            matrixOne.addition(matrixTwo);
            matrixOne.printMatrix();
        } else {
            System.err.println("Cannot add matrixes with different dimensions!");
        }
    }
    
    public void subtractionMatrix(){
        System.out.println("------ Subtraction ------");
        matrixOne.inputMatrix("Matrix 1");
        matrixTwo.inputMatrix("Matrix 2");
        System.out.println("------ Result ------");
        if(matrixOne.getRow() == matrixTwo.getRow() && matrixOne.getCol() == matrixTwo.getCol()){
            matrixOne.printMatrix();
            System.out.println("-");
            matrixTwo.printMatrix();
            System.out.println("=");
            matrixOne.subtraction(matrixTwo);
            matrixOne.printMatrix();
        } else {
            System.err.println("Cannot add matrixes with different dimensions!");
        }
    }
    
    public void multiplicationMatrix(){
        System.out.println("------ Multiplication ------");
        matrixOne.inputMatrix("Matrix 1");
        matrixTwo.inputMatrix("Matrix 2");
        System.out.println("------ Result ------");
        if(matrixOne.getCol() == matrixTwo.getRow()){
            matrixOne.printMatrix();
            System.out.println("*");
            matrixTwo.printMatrix();
            System.out.println("=");
            matrixOne.multiplication(matrixTwo);
            matrixOne.printMatrix();
        } else {
            System.err.println("Column of matrix 1 must equal Row of matrix 2!");
        }
    }
}
