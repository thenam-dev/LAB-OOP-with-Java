/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Person {
    private Wallet wallet;

    public Person(int walletPerson) {
        wallet = new Wallet(walletPerson);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    
    public void printResultCompare(int total){
        System.out.println("this is total of bill: " + total);
        if(wallet.payMoney(total)){
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it");
        }
    }
}
