package com.pluralsight;
import java.util.List;

public class Sandwich implements Customize {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private boolean isToasted;
    private double basePrice;

    public Sandwich(String size, String breadType, List<Topping> toppings, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.isToasted = isToasted;
        this.basePrice = calculateBasePrice();
    }
    @Override
    public void addToppings(Topping topping) {
        topping.add(topping);
    }
    @Override
    public void removeToppings(Topping topping) {
        topping.remove(topping);
    }
    @Override
    public void setToasted(boolean isToasted) {
        this.isToasted = isToasted;
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
    public double getPrice() {
        double price = basePrice;
        for (Topping topping : toppings) {
            if (topping instanceof PremiumTopping) {
                price += ((PremiumTopping) topping).getAdditionalCost();
            } else if (topping instanceof ExtraTopping) {
                price += ((ExtraTopping) topping).getAdditionalCost();
            }
        }
        return price;
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
}
