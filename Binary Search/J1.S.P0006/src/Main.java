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
        Validate v = new Validate();
        int size = v.getInt("Enter number of array: ", 1, 10);
        int[] arr = v.generateArr(size);
        v.display("Unsorted array: ", arr);
        v.bubbleSort(arr);
        v.display("Sorted array: ", arr);
        int findNumber = v.getInt("Enter search number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = v.binarySearch(arr, findNumber);
        if (index == -1) {
            System.out.println("Not found!");
        } else {
            System.out.println("Find " + findNumber + " at index " + index);
        }
    }
}
