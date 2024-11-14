package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Customize {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private List<Topping> extraToppings;
    private List<Sauce> sauces;
    private List<Side> sides;
    private boolean isToasted;
    private double basePrice;

    public Sandwich(String size, String breadType, List<Topping> toppings, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.extraToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.isToasted = isToasted;
        this.basePrice = calculateBasePrice();
    }
    @Override
    public void addToppings(Topping topping) {
        toppings.add(topping);
    }
    public void addExtraToppings(Topping topping) {
        extraToppings.add(topping); // This should work without errors now
    }
    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }
    public void addSide(Side side) {
        sides.add(side);
    }
    @Override
    public void setToasted(boolean isToasted) {
        this.isToasted = isToasted;
    }
    public double getPrice() {
        double totalPrice = basePrice;
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        // this is adding the total of the extra toppings to the total price
        for (Topping extraTopping : extraToppings) {
            totalPrice += extraTopping.getPrice();
        }
        for (Sauce sauce : sauces) {
            totalPrice += sauce.getPrice();
        }
        for (Side side : sides) {
            totalPrice += side.getPrice();
        }
        return totalPrice;
    }
    private double calculateBasePrice() {
        switch (size) {
            case "4":
                return 5.50;
            case "8":
                return 7.00;
            case "12":
                return 8.50;
            default:
                throw new IllegalArgumentException("Invalid size"); // causes an error in the code if wrong size
        }
    }
    public String getSize() { return size;
    }
    public void setSize(String size) { this.size = size;
    }
    public List<Topping> getToppings() { return toppings;
    }
    public void setToppings(List<Topping> topping) { this.toppings = toppings;
    }
    public boolean isToasted() { return isToasted;
    }
    // this is what is displaying in the receipt
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // adding the price after size so it's easier to keep track of purchase
        sb.append("Size: ").append(size).append(" ($").append(basePrice).append(")").append("\nBread: ").append(breadType).append("\nToasted: ").append(isToasted).append("\nToppings: ");
        // this is to stop the comma after a topping even if im not including the other toppings
        for (int i = 0; i < toppings.size(); i++) {
            // to show the price of the toppings so it's easier to keep track
            Topping topping = toppings.get(i);
            sb.append(topping.getName()).append(" ($").append(topping.getPrice()).append(")");
            if (i < toppings.size() - 1) {
                sb.append(", ");
            }
        }
        // this is adding the extra toppings without it saying "steak, steak"
        sb.append("\nExtra Toppings: ");
        for (int i = 0; i < extraToppings.size(); i++) {
            Topping extraTopping = extraToppings.get(i);
            sb.append(extraTopping.getName()).append(" (extra, $").append(extraTopping.getPrice()).append(")");
            if (i < extraToppings.size() - 1) {
                sb.append(", ");
            }
        } // adding to receipt
        sb.append("\nSauces: ");
        for (int i = 0; i < sauces.size(); i++) {
            Sauce sauce = sauces.get(i);
            sb.append(sauce.getName()).append(" ($").append(sauce.getPrice()).append(")");
            if (i < sauces.size() - 1) {
                sb.append(", ");
            }
        } // adding to receipt
        sb.append("\nSides: ");
        for (int i = 0; i < sides.size(); i++) {
            Side side = sides.get(i);
            sb.append(side.getName()).append(" ($").append(side.getPrice()).append(")");
            if (i < sides.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
