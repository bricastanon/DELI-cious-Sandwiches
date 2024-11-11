package com.pluralsight;
import java.util.List;

public class Order implements DisplayOrder {
    private Customer customer;
    private List<Sandwich> sandwiches;
    private List<Drink> drink;
    private List<Chip> chip;
    private double totalPrice;

    public Order(Customer customer, List<Sandwich> sandwiches, List<Drink> drink, List<Chip> chip) {
        this.customer = customer;
        this.sandwiches = sandwiches;
        this.drink = drink;
        this.chip = chip;
        this.totalPrice = calculateTotal();
    }

    private double calculateTotal() {
        return totalPrice;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public void addDrink(Drink drink) {
        drink.add(drink);
    }

    public void removeDrink(Drink drink) {
        drink.remove(drink);
    }

    public void addChips(Chip chip) {
        chip.add(chip);
    }

    public void removeChips(Chip chip) {
        chip.remove(chip);
    }

    @Override
    public void displayOrderDetails() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public List<Chip> getChips() {
        return chip;
    }

    public void setChip(List<Chip> chip) {
        this.chip = chip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Email: ").append(customer.getEmail()).append("\n");
        sb.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            sb.append(sandwich.toString()).append("\n");
        }
        sb.append("Drinks:\n");
        for (Drink drink : drink) {
            sb.append(drink.toString()).append("\n");
        }
        sb.append("Chips:\n");
        for (Chip chip : chip) {
            sb.append(chip.toString()).append("\n");
        }
        sb.append("Total Price: $").append(TotalCost.calculateTotal(this)).append("\n");
        return sb.toString();
    }
}