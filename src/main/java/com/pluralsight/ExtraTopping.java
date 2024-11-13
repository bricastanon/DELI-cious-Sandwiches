package com.pluralsight;

public class ExtraTopping extends Topping {
    private double extraPrice;

    public ExtraTopping(String name, double extraPrice) {
        super(name);
        this.extraPrice = extraPrice;
    }
    @Override
    public double getPrice() { // so price calculates and shows up on receipt
        return extraPrice;
    }
}

