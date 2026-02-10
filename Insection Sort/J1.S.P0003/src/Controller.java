
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
    
    public void displayArr(String msg, int[] arr) {
        System.out.print(msg + "[");
        for(int i = 0; i< arr.length; i++) {
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }
    
    public int[] generateArr(int n) {
        int[] arr = new int[n];
        for(int i = 0; i<arr.length; i++) {
            arr[i] = r.nextInt(n);
        }
        return arr;
    }
    
    public void insectionSort(int[] arr, String msg) {
        for(int i = 1; i<arr.length;i++) {
            int temp = arr[i];
            int j = i -1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        displayArr(msg, arr);
    }
}
