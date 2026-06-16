/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.Order;
import model.OrderDetails;

/**
 *
 * @author ACER
 */
public class ManagerShop {

    private List<Fruit> listFruit;
    private Hashtable<Integer, Order> orderTable;

    public ManagerShop() {
        listFruit = new ArrayList<>();
        orderTable = new Hashtable<>();
        listFruit.add(new Fruit("Apple", 2.5, 20, "USA"));
        listFruit.add(new Fruit("Banana", 1.2, 50, "Vietnam"));
        listFruit.add(new Fruit("Orange", 3.0, 30, "France"));
        listFruit.add(new Fruit("Mango", 4.5, 25, "Thailand"));
        listFruit.add(new Fruit("Pineapple", 2.8, 15, "Mexico"));
    }

    public void createFruit() {
        boolean check = true;
        while (check) {
            boolean isValid = false;
            String name = null;
            Fruit fruit;
            while (!isValid) {
                name = Validation.getString("Enter fruit name: ", ".*");
                fruit = findFruitByName(name);
                if (fruit != null) {
                    System.err.println("Fruit has already existed in database!");
                } else {
                    isValid = true;
                }
            }
            double price = Validation.getDouble("Enter price: ", 0.01, Double.MAX_VALUE);
            int quantity = Validation.getInt("Enter quantity: ", 1, Integer.MAX_VALUE);
            String origin = Validation.getString("Enter origin: ", ".*");
            fruit = new Fruit(name, price, quantity, origin);
            listFruit.add(fruit);
            System.out.println("Add successfully!");

            check = Validation.getYesNo("Do you want to add more fruit? (Y/y) or (N/n): ");
        }
    }

    public void viewOrder() {
        if (orderTable.isEmpty()) {
            System.out.println("No order in database!");
            return;
        }
        for (Map.Entry<Integer, Order> entry : orderTable.entrySet()) {
            int key = entry.getKey();
            printOrder(orderTable.get(key));
        }
    }

    private void printOrder(Order o) {
        System.out.println("------------------------------------------");
        System.out.printf("Customer: %-15sOrder Id: %d\n", o.getCustomerName(), o.getOrderId());
        System.out.printf("%-10s| %-10s| %-9s| %-10s\n", "Product", "Quantity", "Price", "Amount");
        for (OrderDetails item : o.getItems()) {
            System.out.println(item.toString());
        }
        System.out.println("Total: " + o.getTotalBills() + "$");
    }

    public void shopping() {
        List<OrderDetails> cart = new ArrayList<>();
        boolean check = true;
        while (check) {
            //check exist
            if (listFruit.isEmpty()) {
                System.err.println("Out of stock!");
                return;
            }
            //display list fruit
            printFruitMenu();
            //select fruit
            Fruit selected = null;
            while (selected == null) {
                String key = Validation.getString("Your selected: ", ".*");
                selected = findFruitByName(key);
                if (selected == null) {
                    System.err.println("Fruit not found! Input again: ");
                }
            }
            //input quantity
            int quantity = Validation.getInt("Please input quantity: ", 1, selected.getQuantity());
            if (!deducQuantity(selected, quantity)) {
                System.err.println("Not enough quantity!");
                continue;
            }
            //add to cart
            addToCart(cart, selected, quantity);
            check = Validation.getYesNo("Continue shopping? (Y/N): ");
        }
        //display cart
        printCart(cart);
        String customerName = Validation.getString("Input customer name: ", ".*");
        double totalBill = calTotalBill(cart);
        Order order = new Order(customerName, cart, totalBill);
        orderTable.put(order.getOrderId(), order);
        System.out.println("Order successfully!");
    }

    private Fruit findFruitByName(String name) {
        for (Fruit f : listFruit) {
            if (f.getFruitName().equalsIgnoreCase(name)) {
                return f;
            }
        }
        return null;
    }

    private void printFruitMenu() {
        System.out.printf("|++ %-4s ++|++ %-10s ++|++ %-6s ++|++ %-5s ++|\n", "Item", "Fruit Name", "Origin", "Price");
        System.out.println("------------------------------------------------------");
        for (Fruit f : listFruit) {
            System.out.println(f);
        }
    }

    private boolean deducQuantity(Fruit fruit, int quantity) {
        if (quantity > fruit.getQuantity()) {
            return false;
        }
        fruit.setQuantity(fruit.getQuantity() - quantity);
        if (fruit.getQuantity() == 0) {
            listFruit.remove(fruit);
        }
        return true;
    }

    private void addToCart(List<OrderDetails> cart, Fruit selected, int quantity) {
        for (OrderDetails od : cart) {
            if (od.getFruit().getFruitId() == selected.getFruitId()) {
                od.setQuantityOrder(od.getQuantityOrder() + quantity);
                return;
            }
        }
        cart.add(new OrderDetails(selected, quantity));
    }

    private void printCart(List<OrderDetails> cart) {
        System.out.printf("%-10s| %-10s| %-9s| %-10s\n", "Product", "Quantity", "Price", "Amount");
        System.out.println("----------------------------------------------");
        for (OrderDetails od : cart) {
            System.out.println(od);
        }
    }

    private double calTotalBill(List<OrderDetails> cart) {
        double result = 0;
        for (OrderDetails orderDetails : cart) {
            result += orderDetails.getFruit().getPrice() * orderDetails.getQuantityOrder();
        }
        return result;
    }
}
