package com.pluralsight;

public class PremiumTopping extends Topping {
       // private double additionalCost;
        private double price;

        public PremiumTopping(String name, double price) {
            super(name);
          //  this.additionalCost = additionalCost;
            this.price = price;
       // }
  //  public double getAdditionalCost() { return additionalCost;
    }
    @Override
    public double getPrice() {
            return price;
    }
}
