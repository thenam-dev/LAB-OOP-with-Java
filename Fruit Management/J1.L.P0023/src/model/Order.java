/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Order {
    private static int COUNT = 1;
    private int orderId;
    private String customerName;
    private List<OrderDetails> items;
    private double totalBills;

    public Order() {
        items = new ArrayList<>();
        orderId = COUNT++;
    }

    public Order(int orderId, String customerName, List<OrderDetails> items, double totalBills) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.totalBills = totalBills;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public static void setCOUNT(int COUNT) {
        Order.COUNT = COUNT;
    }

    public Order(String customerName, ArrayList<OrderDetails> cart, double totalBill) {
        this.orderId = COUNT++;
        this.customerName = customerName;
        this.items = cart;
        this.totalBills = totalBill;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderDetails> getItems() {
        return items;
    }

    public void setItems(List<OrderDetails> items) {
        this.items = items;
    }

    public double getTotalBills() {
        return totalBills;
    }

    public void setTotalBills(double totalBills) {
        this.totalBills = totalBills;
    }
    
    
}
