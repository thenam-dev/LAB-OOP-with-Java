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
public class HexaDecimal {

    private String hexa;

    public HexaDecimal() {
    }

    public HexaDecimal(String hexa) {
        this.hexa = hexa;
    }

    public String getHexa() {
        return hexa;
    }

    public void setHexa(String hexa) {
        this.hexa = hexa;
    }

    private String convertHexaToDecimal() {
        int decimal = 0;
        hexa = hexa.toUpperCase();

        for (int i = 0; i < hexa.length(); i++) {
            char ch = hexa.charAt(i);
            int value;

            if (ch >= '0' && ch <= '9') {
                value = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                value = ch - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Invalid hex character: " + ch);
            }

            decimal = decimal * 16 + value;
        }

        return String.valueOf(decimal);
    }

    private String convertHexaToBinary() {
        Decimal deci = new Decimal();
        String decimal = convertHexaToDecimal();
        String binary = deci.convertDecimalToBinary(decimal);
        return binary;
    }

    public void inputHexa() {
        hexa = Validate.checkInputFormat("Enter hexadecimal: ", "[0-9A-F]*", "Hexa must be 0-9 A-F");
    }

    public void convertFromHexa() {
        int choice = Validate.getChoice("HexaDecimal", "Binary", "Decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertHexaToBinary());
                break;
            case 2:
                System.out.println("Decimal: " + convertHexaToDecimal());
                break;
        }
    }
}
