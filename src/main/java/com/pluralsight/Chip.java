package com.pluralsight;

public class Chip {
    private String name;
    private double price;

    public Chip(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name;
    }
    public double getPrice() { return price;
    }
    public void add(Chip chip) {
    }
    public void remove(Chip chip) {
    }
    @Override
    public String toString() { // this is the output on the receipt
        return "Chips: " + name + ", Price: $" + price;
    }
}
