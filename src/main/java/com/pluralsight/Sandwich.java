package com.pluralsight;
import java.util.List;

public class Sandwich implements Customize {
    private String size;
    private String breadType;
    private List<Topping> topping;
    private boolean isToasted;

    public Sandwich(String size, String breadType, List<Topping> topping, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.topping = topping;
        this.isToasted = isToasted;
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
    public String getSize() { return size;
    }
    public void setSize(String size) { this.size = size;
    }
    public String getBreadType() { return breadType;
    }
    public void setBreadType(String breadType) { this.breadType = breadType;
    }
    public List<Topping> getTopping() { return topping;
    }
    public void setTopping(List<Topping> topping) { this.topping = topping;
    }
    public boolean isToasted() { return isToasted;
    }
}
