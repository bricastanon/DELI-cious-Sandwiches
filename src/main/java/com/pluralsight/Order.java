package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Order implements DisplayOrder {
    private Customer customer;
    private List<Sandwich> sandwiches;
    private List<Drink> drink;
    private List<Chip> chip;
    private List<Sauce> sauces;
    private List<Side> sides;
    private double totalPrice;

    public Order(Customer customer, List<Sandwich> sandwiches, List<Drink> drink, List<Chip> chip) {
        this.customer = customer;
        this.sandwiches = sandwiches;
        this.drink = drink;
        this.chip = chip;
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.totalPrice = calculateTotal();
    }
    private double calculateTotal() {
        totalPrice = 0;
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.getPrice();
        } for (Drink d : drink) {
            totalPrice += d.getPrice();
        } for (Chip c : chip) {
            totalPrice += c.getPrice();
        }
        return totalPrice;
    }
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
        totalPrice = calculateTotal(); // had to add all these bc price wouldn't calculate
    }
    public void addDrink(Drink d) {
        drink.add(d);
        totalPrice = calculateTotal();
    }
    public void addChips(Chip c) {
        chip.add(c);
        totalPrice = calculateTotal();
    }
    @Override
    public void displayOrderDetails() {
    }
    public Customer getCustomer() { return customer;
    }
    public void setCustomer(Customer customer) { this.customer = customer;
    }
    public List<Sandwich> getSandwiches() { return sandwiches;
    }
    public void setSandwiches(List<Sandwich> sandwiches) { this.sandwiches = sandwiches;
    }
    public List<Drink> getDrinks() { return drink;
    }
    public void setDrink(List<Drink> drink) { this.drink = drink;
    }
    public List<Chip> getChips() { return chip;
    }
    @Override
    public String toString() { // this is the output on the receipt
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Email: ").append(customer.getEmail()).append("\n");
        sb.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            sb.append(sandwich.toString()).append("\n");
        }
        for (Drink drink : drink) {
            sb.append(drink.toString()).append("\n");
        }
        for (Chip chip : chip) {
            sb.append(chip.toString()).append("\n");
        }
        sb.append("Total Price: $").append(TotalCost.calculateTotal(this)).append("\n");
        return sb.toString();
    }
}