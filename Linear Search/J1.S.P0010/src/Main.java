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
        Utility u = new Utility();
        
        int n = u.getIntInRange("Enter number of array: ", 1, Integer.MAX_VALUE);
        int value = u.getIntInRange("Enter search value: ", 1, Integer.MAX_VALUE);
        
        int[] arr = u.generateArray(n);

        u.displayArr("The array: ", arr);

        int found = u.linearSearch(arr, value);
        if (found == -1) {
            System.out.println("Can not found value " + value + " in array");
        } else {
            System.out.println("Found value " + value + " at index " + found);
        }
        
        //Extend
        u.displayLinearSearch(arr,value);
    }
}
