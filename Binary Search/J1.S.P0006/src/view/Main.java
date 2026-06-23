package view;

import controller.Validation;
import model.Array;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array();
        array.inputSizeOfArray();
        array.randomValueOfArray();
        array.displayArray("Sorted array: ");
        int value = Validation.getInt("Enter search value: ", 1, 100);
        array.binarySearch(value);
        if(array.getResultSearch() == -99){
            System.err.println("Not found!");
        } else {
            System.out.println("Found "+value+" at index: "+ array.getResultSearch());
        }
    }
}
