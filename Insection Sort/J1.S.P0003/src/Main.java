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
        Controller c = new Controller();
        Validation v = new Validation();
        
        int n = v.getInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        
        int[] arr = c.generateArr(n);
        
        c.displayArr("Unsorted array: ", arr);
        
        c.insectionSort(arr, "Sorted array: ");
    }
}
