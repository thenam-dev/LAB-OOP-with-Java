
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
public class Utility {

    public int getIntInRange(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        do {
            try {
                System.out.println(msg);
                String input = sc.nextLine();
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.println("Invalid number. Number must be between " + min + " and " + max);
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.err.println("Invalid number format. Please try agian!");
            }
        } while (true);
    }

    public int[] generateArray(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(n);
        }
        return arr;
    }

    public void displayArr(String msg, int[] arr) {
        System.out.print(msg + "[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }

    // Search a value in array by linear search
    public int linearSearch(int[] arr, int value) {
        int indexOfSearch = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                indexOfSearch = i;
                break; //bo break thi tim o index cuoi cung trong mang
            }
        }
        return indexOfSearch;
    }

    public void displayLinearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println(i);
            }
        }
    }
}
