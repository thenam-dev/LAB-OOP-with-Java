/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class OrderDetails {

    private Fruit fruit;
    private int quantityOrder;

    public OrderDetails(Fruit selected, int quantity) {
        fruit = selected;
        quantityOrder = quantity;
    }

    public OrderDetails(String name, double price, int quantityOrder) {
        fruit = new Fruit();
        fruit.setFruitName(name);
        fruit.setPrice(price);
        this.quantityOrder = quantityOrder;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    @Override
    public String toString() {
        return String.format("%-14s| %-9d| %-9.2f| %-10.2f\n", fruit.getFruitName(), quantityOrder, fruit.getPrice(), quantityOrder * fruit.getPrice());
    }

}
