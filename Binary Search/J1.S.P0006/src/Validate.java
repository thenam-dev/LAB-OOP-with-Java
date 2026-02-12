
import java.util.Arrays;
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
public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    public int getInt(String msg, int min, int max) {
        do {
            try {
                System.out.println(msg);
                String input = sc.nextLine().trim();
                int result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.err.println("Please input number in range [" + min + ", " + max + "]!");
                    continue;
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println("Please input valid number!");
            }
        } while (true);
    }

    public int[] generateArr(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(n);
        }
        return arr;
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public void display(String msg, int[] arr) {
        System.out.println(msg);
        System.out.println(Arrays.toString(arr));
    }

    public int binarySearch(int[] arr, int findNumber) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == findNumber) {
                return mid;
            }

            if (arr[mid] < findNumber) {
                left = mid + 1;
            }

            if (arr[mid] > findNumber) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
