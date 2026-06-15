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
public class Matrix {

    private int[][] matrix;

    public Matrix() {
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRow() {
        return matrix.length;
    }

    public int getCol() {
        return matrix[0].length;
    }

    public int getIndex(int i, int j) {
        return matrix[i][j];
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void inputMatrix(String msg) {
        int row = Validation.getInt("Enter Row " + msg + ": ");
        int column = Validation.getInt("Enter Column " + msg + ": ");
        matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Validation.getInt("Enter " + msg + " [" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
    }

    public void addition(Matrix matrix) {
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCol(); j++) {
                this.matrix[i][j] += matrix.getIndex(i, j);
            }
        }
    }

    public void subtraction(Matrix matrix) {
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCol(); j++) {
                this.matrix[i][j] -= matrix.getIndex(i, j);
            }
        }
    }

    public void multiplication(Matrix matrix) {
        int[][] result = new int[this.matrix.length][matrix.getCol()];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < this.matrix[0].length; k++) {
                    result[i][j] += this.matrix[i][k] * matrix.getIndex(k, j);
                }
            }
        }
        this.matrix = result;
    }
}
