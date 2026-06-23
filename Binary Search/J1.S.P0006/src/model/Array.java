/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Validation;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class Array {

    private int[] array;
    private int resultSearch;

    public Array() {

    }

    public Array(int[] array) {
        this.array = array;
    }

    public int getResultSearch() {
        return resultSearch;
    }

    //input size of array
    public void inputSizeOfArray(){
        int size = Validation.getInt("Enter size of array: ", 1, 100);
        array = new int[size];
    }
    //input value of array
    public void inputValueOfArray() {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = Validation.getInt("Enter array[" + i + "]: ", 1, 100);
        }
    }
    
    public void randomValueOfArray(){
        Random r = new Random();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i] = r.nextInt(n);
        }
    }

    //display array
    public void displayArray(String msg) {
        System.out.println(msg);
        System.out.println(Arrays.toString(array));
    }

    public void bubbleSort() {
        int n = array.length;
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    swap(j, j + 1);
                    flag = true;
                }
            }
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[b] = array[a];
        array[a] = temp;
    }

    public void binarySearch(int value) {
        int left = 0;
        int right = array.length - 1;
        int result = -99;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == value) {
                result = mid;
                break;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        this.resultSearch = result;
    }
}
