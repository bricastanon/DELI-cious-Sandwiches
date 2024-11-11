package com.pluralsight;

public class ExtraTopping extends Topping {
    private double additionalCost;

    public ExtraTopping(String name, double additionalCost) {
        super(name);
        this.additionalCost = additionalCost;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }
}

