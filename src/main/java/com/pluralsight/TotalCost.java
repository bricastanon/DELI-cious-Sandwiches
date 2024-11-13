package com.pluralsight;

public class TotalCost {
    public static double calculateTotal(Order order) {
        double total = 0.0;

        for (Sandwich sandwich : order.getSandwiches()) {
            total += sandwich.getPrice(); // Sandwich has a getPrice() method
        }
        for (Drink drink : order.getDrinks()) {
            total += drink.getPrice();
        }
        for (Chip chip : order.getChips()) {
            total += chip.getPrice();
        }
        return total;
    }
}

