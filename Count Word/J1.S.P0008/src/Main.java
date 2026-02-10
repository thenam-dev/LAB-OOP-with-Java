
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ACER
 */
//Word Count (Demo Hashmap)
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, Integer> countWord = new HashMap<String, Integer>();
    private static final Map<Character, Integer> countChar = new HashMap<Character, Integer>();

    public static void main(String[] args) {

        String input = getString("Enter your content: ");
        handleCountInput(input);
        display();
    }

    public static String getString(String msg) {
        while (true) {
            try {
                System.out.println(msg);
                String str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.err.println("Plese input valid string!");
            }
        }
    }

    public static void handleCountInput(String text) {
        //count character
        for (int i = 0; i < text.length(); i++) { // duyet tung chu trong chuoi
            char c = text.charAt(i);
            if (!countChar.containsKey(c)) { 
                countChar.put(c, 1);
            } else {
                countChar.put(c, countChar.get(c) + 1);
            }
        }
        countChar.remove(' ');

        //count string
        String[] words = text.split(" "); //tach chuoi thanh cac tu
        for (String w : words) {
            if (!countWord.containsKey(w)) {
                countWord.put(w, 1);
            } else {
                countWord.put(w, countWord.get(w) + 1);
            }
        }
    }

    public static void display() {
        System.out.println(countWord);
        System.out.println(countChar);
    }
}
