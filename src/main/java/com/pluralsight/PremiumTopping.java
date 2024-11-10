package com.pluralsight;

public class PremiumTopping extends Topping {
        private double additionalCost;

        public PremiumTopping(String name, double additionalCost) {
            super(name);
            this.additionalCost = additionalCost;
        }
    public double getAdditionalCost() { return additionalCost;
    }
}
