package com.pluralsight;

public class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }
    public String getName() { return name;
    }
    public void add(Topping toppings) {
    }
    public void remove(Topping topping) {
    }
    public double getPrice() {
        return 0.0; // no additional cost for toppings included
    }
}
