/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
// Fibonacci
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 45; i++) {
//            System.out.print(fibonacci(i) + ", ");
        }
        
        System.out.println("The 45 sequence fibonacci");
        fibonacciHelper(45, 1, 0);
        
//        System.out.println(fibonacci2(-3));
//        int f0 = 0, f1 = 1; // 0 1 1 2 3 5 here
//        System.out.print("0, 1, ");
//        for(int i = 0; i < 43; i++) {
//            int f2 = f0 + f1;
//            System.out.print(f2 + ", ");
//            f0 = f1;
//            f1 = f2;
//        }
//        show(5);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static int fibonacciHelper(int term, int left, int right) {
        if (term<2) {
            return right;
        }
        System.out.print(right);
        if(term != 2) {
            System.out.print(", ");
        } else {
            System.out.print(".");
        }
        return fibonacciHelper(term-1, right, right + left);
    }

//    public static int fibonacci2(int n) { // tra ve so fibo thu n
//        if (n <= 1) {
//            return n;
//        } else {
//            return fibonacci2(n - 1) + fibonacci2(n - 2);
//        }
//      // n == -3 -> print -3 --> False
//    }

    // Recursion: ham goi chinh no
    public static void show(int n) {
        if (n != 0) { // dk dung de quy
            show(n - 1);
            System.out.println("hello");
        }
        if (n == 5) {
            System.out.println("het de quy");
        }
    }

}
