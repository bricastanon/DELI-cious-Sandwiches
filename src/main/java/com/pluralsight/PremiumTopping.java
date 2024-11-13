package com.pluralsight;

public class PremiumTopping extends Topping {
        private double price;

        public PremiumTopping(String name, double price) {
            super(name);
            this.price = price;
    }
    @Override
    public double getPrice() {
            return price;
    }
}
