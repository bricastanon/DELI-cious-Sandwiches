package com.pluralsight;

public class Sauce {
    private String name;
    private double price;

    public Sauce(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name;
    }
    public double getPrice() { return price;
    }
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}