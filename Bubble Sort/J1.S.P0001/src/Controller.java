
import java.util.Arrays;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Controller {
    Random r = new Random();
    
    public void display(int[] arr, String msg) {
        System.out.print(msg + "[");
        for(int i = 0; i<arr.length;i++) {
            System.out.print(arr[i]);
            if(i!=arr.length-1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
        
//        System.out.println(msg + Arrays.toString(arr));
    }
    
    public int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i =0;i<arr.length;i++) {
            arr[i] = r.nextInt(n);
        }
        return arr;
    }
    
    public void bubbleSort(int[] arr, String msg) {
        for(int i = 0; i<arr.length;i++) {
            for(int j = 0; j< arr.length - i - 1; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        display(arr, msg);
    }
}
