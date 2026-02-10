
import java.util.Random;
import java.util.Scanner;

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

        int n = Validation.getInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        
        int arr[] = c.generateArray(n);
        
        c.display(arr, "Unsorted array: ");
        c.bubbleSort(arr, "Sorted Array: ");
        
    }
}
