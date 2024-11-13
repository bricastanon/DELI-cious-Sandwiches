package com.pluralsight;

public class Drink {
    private String name;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() { return price;
    }
    @Override
    public String toString() { // this is output on receipt
        return "Drink: " + name + ", Price: $" + price;
    }

}
