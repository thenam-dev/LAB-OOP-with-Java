/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
public class Function {
    public int calcTotal(int[] bills){
        int total = 0;
        for(int i=0; i< bills.length;i++){
            total+= bills[i];
        }
        return total;
    }
}
