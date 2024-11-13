package com.pluralsight;

public class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }
    public String getName() { return name;
    }
    public double getPrice() {
        return 0.0; // no additional cost for toppings included
    }
}
