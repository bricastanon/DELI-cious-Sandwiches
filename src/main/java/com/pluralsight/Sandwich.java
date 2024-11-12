package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Customize {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private List<Topping> extraToppings;
    private boolean isToasted;
    private double basePrice;

    public Sandwich(String size, String breadType, List<Topping> toppings, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.extraToppings = new ArrayList<>();
        this.isToasted = isToasted;
        this.basePrice = calculateBasePrice();
    }
    @Override
    public void addToppings(Topping topping) {
        toppings.add(topping);
       // System.out.println("Toppings added: " + topping.getName());
    }
    public void addExtraToppings(Topping topping) {
        extraToppings.add(topping); // This should work without errors now
    }
    @Override
    public void removeToppings(Topping topping) {
        topping.remove(topping);
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
                throw new IllegalArgumentException("Invalid size");
        }

    }
    public String getSize() { return size;
    }
    public void setSize(String size) { this.size = size;
    }
    public String getBreadType() { return breadType;
    }
    public void setBreadType(String breadType) { this.breadType = breadType;
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
        // adding the price after size so it's easier to keep track
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

       // for (Topping topping : toppings) {
          //  sb.append(topping.getName()).append(", ");
        }
        return sb.toString();
    }

}
