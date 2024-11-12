package com.pluralsight;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OrderManager {
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    public void displayHomeScreen() {
        while (true) {
            System.out.println("Welcome to DELI-cious Sandwich Shop!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // new line

                switch (choice) {
                    case 1:
                        startNewOrder();
                        break;
                    case 0:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0); // Exit the application completely (it wouldn't exit at first)
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

    private void startNewOrder() {
        System.out.println("Starting a new order ");
        System.out.println("--------------------");
        Customer customer = createCustomer(); // will ask for name and email
        currentOrder = new Order(customer, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()); // Use the created customer
        displayOrderScreen();
    }

    private void displayOrderScreen() {
        while (true) {
            System.out.println("What would you like to order? ");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    return;
                case 0:
                    cancelOrder();
                    displayHomeScreen(); // had to put this instead of return bc it wouldn't go back to homescreen
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private Customer createCustomer() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        Customer customer = new Customer(name, email);
        System.out.println("Customer created: " + customer.getName() + ", " + customer.getEmail()); // Debugging print
        return customer;
    }

    private Sandwich addSandwich() {
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
            currentOrder.addSandwich(sandwich);
            System.out.println("Sandwich added to the order.");

    }


    private void addDrink() {
        System.out.println("Add Drink");
        System.out.println("Enter drink size (small, medium, large): ");
        String size = scanner.nextLine();
        double price;
        switch (size.toLowerCase()) {
            case "small":
                price = 2.00;
                break;
            case "medium":
                price = 2.50;
                break;
            case "large":
                price = 3.00;
                break;
            default:
                System.out.println("Invalid drink size. Please try again.");
                return;
        }

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size + " " + flavor, price);
        currentOrder.addDrink(drink);
        System.out.println("Drink added to the order.");
    }

    private void addChips() {
        System.out.println("Add Chips");
        System.out.println("What chips would you like? (original lays, lay bbq, sour cream and onion, sun chips): ");
        String type = scanner.nextLine();
        double price = 1.50;

        Chip chip = new Chip(type, price);
        currentOrder.addChips(chip); // adding to current order
        System.out.println("Chips added to the order.");
    }

    private void checkout() {
        System.out.println("Checkout");
        currentOrder.displayOrderDetails();
        double totalPrice = TotalCost.calculateTotal(currentOrder);
        System.out.println("Your total cost comes out to: $ " + totalPrice);
        System.out.println("1) Confirm");
        System.out.println("0) Cancel Order");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            saveOrderToFile(currentOrder);
            System.out.println("Order confirmed and receipt saved.");
        } else {
            System.out.println("Order cancelled.");
        }
    }

    private void cancelOrder() {
        System.out.println("Order cancelled. Returning to home screen.");
    }

    private void saveOrderToFile(Order order) {
        String folderName = "receipts";
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String fileName = folderName + "/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(order.toString()); // Assuming your Order class has a meaningful toString() method
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

