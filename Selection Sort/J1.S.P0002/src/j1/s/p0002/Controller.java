/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0002;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class Controller {
    Random r = new Random();
    
    public void displayArr(int[] arr, String msg) {
        System.out.println(msg + Arrays.toString(arr));
    }
    
    public int[] generateArr(int n) {
        int[] arr = new int[n];
        for(int i = 0; i< arr.length; i++) {
            arr[i] = r.nextInt(n);
        }
        return arr;
    }
    
    public void selectionSort(int[] arr, String msg) {
        for(int i = 0; i< arr.length; i++) {
            int minIndex = i;
            for(int j = i+1; j<arr.length;j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }                
            }
            if(arr[i]!=arr[minIndex]){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        displayArr(arr, msg);
    }
}
