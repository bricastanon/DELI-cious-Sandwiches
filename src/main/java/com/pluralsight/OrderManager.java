package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {
    private Scanner scanner = new Scanner(System.in);

    public void startOrder() {
        System.out.println("Welcome to DELI-cious Sandwich Shop! ");
        Customer customer = createCustomer();
        Order order = new Order(customer, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        boolean continueOrdering = true;
        while (continueOrdering) {
            System.out.println("What would you like to order? ");
            System.out.println("----------------------------- ");
            System.out.println("1. Sandwich ");
            System.out.println("2. Drink ");
            System.out.println("3. Chips ");
            System.out.println("4. Complete Order ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    order.addSandwich(createSandwich());
                    break;
                case 2:
                    order.addDrink(createDrink());
                    break;
                case 3:
                    order.addChips(createChips());
                    break;
                case 4:
                    continueOrdering = false;
                    break;
                default:
                    System.out.println("Invalid - Please try again ");
            }
        }
        order.displayOrderDetails();
        double totalPrice = TotalCost.calculateTotal(order);
        System.out.println("Your total cost comes out to: $ " + totalPrice);
    }

    private Customer createCustomer() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        return new Customer(name, email);
    }

    private Sandwich createSandwich() {
        System.out.println("What size would you like? (4, 8, 12 inches): ");
        String size = scanner.nextLine();
        System.out.println("What bread would you like? (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();
        System.out.println("Would you like your sandwich toasted? (yes/no): ");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, breadType, new ArrayList<>(), isToasted);
        customizeSandwich(sandwich);
        return sandwich;
    }

    private void customizeSandwich(Sandwich sandwich) {
        addMeat(sandwich);
        addCheese(sandwich);
        addRegularToppings(sandwich);
    }

    private void addMeat(Sandwich sandwich) {
        System.out.println("What meat would you like? (steak, ham, salami, roast beef, chicken, bacon): ");
        String meat = scanner.nextLine();
        sandwich.addToppings(new PremiumTopping(meat, calculateMeatCost(sandwich.getSize())));
        System.out.println("Would you like to add extra meat? (yes/no): ");
        boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");
        if (extraMeat) {
            sandwich.addToppings(new ExtraTopping(meat, calculateExtraMeatCost(sandwich.getSize())));
        }
    }

    private double calculateMeatCost(String size) {
        switch (size) {
            case "4":
                return 1.00;
            case "8":
                return 2.00;
            case "12":
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size");
        }
    }

    private double calculateExtraMeatCost(String size) {
        switch (size) {
            case "4":
                return 0.50;
            case "8":
                return 1.00;
            case "12":
                return 1.50;
            default:
                throw new IllegalArgumentException("Invalid size");
        }
    }

    private void addCheese(Sandwich sandwich) {
        System.out.println("What cheese would you like? (american, provolone, chedder, swiss) ");
        String cheese = scanner.nextLine();
        if (!cheese.equalsIgnoreCase("none")) {
            sandwich.addToppings(new PremiumTopping(cheese, calculateCheeseCost(sandwich.getSize())));
            System.out.println("Would you like to add extra cheese? (yes/no) ");
            boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");
            if (extraCheese) {
                sandwich.addToppings(new ExtraTopping(cheese, calculateExtraCheeseCost(sandwich.getSize())));
            }
        }
    }

    private double calculateCheeseCost(String size) {
        switch (size) {
            case "4":
                return 0.75;
            case "8":
                return 1.50;
            case "12":
                return 2.25;
            default:
                throw new IllegalArgumentException("Invalid size");
        }
    }

    private double calculateExtraCheeseCost(String size) {
        switch (size) {
            case "4":
                return 0.30;
            case "8":
                return 0.60;
            case "12":
                return 0.90;
            default:
                throw new IllegalArgumentException("Invalid size");
        }
    }

    private void addRegularToppings(Sandwich sandwich) {
        System.out.println("Add regular toppings to your sandwich (all included):");
        String[] regularToppings = {"lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
        for (String topping : regularToppings) {
            System.out.print("Would you like to remove " + topping + " from your sandwich (yes/no)? ");
            boolean removeTopping = scanner.nextLine().equalsIgnoreCase("yes");
            if (!removeTopping) {
                sandwich.addToppings(new RegularTopping(topping));
            }
        }
    }

    private Drink createDrink() {
        String size;
        double price;
        while (true) {
            System.out.print("Enter drink size (small, medium, large): ");
            size = scanner.nextLine().toLowerCase();
            if (size.equals("small")) {
                price = 2.00;
                break;
            } else if (size.equals("medium")) {
                price = 2.50;
                break;
            } else if (size.equals("large")) {
                price = 3.00;
                break;
            } else {
                System.out.println("Invalid drink size. Please try again.");
            }
        }

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        return new Drink(size + " " + flavor, price);
    }

    private Chip createChips() {
        System.out.println("What chips would you like? (original lays, lay bbq, sour cream and onion, sun chips): ");
        String type = scanner.nextLine();
        double price = 1.50;
        return new Chip(type, price);
    }
}

