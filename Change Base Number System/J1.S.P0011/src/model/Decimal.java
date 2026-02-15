/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import Validation.Validate;
/**
 *
 * @author ACER
 */
public class Decimal {

    private String decimal;

    private final char[] HEXA_DIGIT = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public Decimal() {
    }

    public Decimal(String decimal) {
        this.decimal = decimal;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public String convertDecimalToBinary(String decimal) {
        String result = "";
        int deci = Integer.parseInt(decimal);
        while (deci != 0) {
            result = (deci % 2) + result;
            deci /= 2;
        }
        return result;
    }

    public String convertDecimalToHexa(String decimal) {
        String result = "";
        int deci = Integer.parseInt(decimal);
        while (deci != 0) {
            result = HEXA_DIGIT[deci % 16] + result;
            deci /= 16;
        }
        return result;
    }
    
    public void inputDecimal() {
        decimal = Validate.checkInputFormat("Enter decimal: ", "[0-9]*", "Decimal must be 0-9");
    }
    
    public void convertFromDecimal(String decimal) {
        int choice = Validate.getChoice("Decimal", "Binary", "HexaDecimal");
        switch(choice) {
            case 1:
                System.out.println("Binary: " + convertDecimalToBinary(decimal));
                break;
            case 2:
                System.out.println("HexaDecimal: "+convertDecimalToHexa(decimal));
                break;
        }
        
    }
}
