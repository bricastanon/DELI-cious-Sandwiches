package com.pluralsight;

public class Drink {
    private String name;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name;
    }
    public double getPrice() { return price;
    }
    public void add(Drink drink) {
    }
    public void remove(Drink drink) {
    }
    @Override
    public String toString() {
        return "Drink: " + name + ", Price: $" + price;
    }

}
