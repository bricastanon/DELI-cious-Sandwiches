package com.pluralsight;

public class ExtraTopping extends Topping {
   // private double additionalCost;
    private double extraPrice;

    public ExtraTopping(String name, double extraPrice) {
        super(name);
       // this.additionalCost = additionalCost;
        this.extraPrice = extraPrice;
   // }

   // public double getAdditionalCost() {
    //    return additionalCost;
    }
    @Override
    public double getPrice() {
        return extraPrice;
    }
}

