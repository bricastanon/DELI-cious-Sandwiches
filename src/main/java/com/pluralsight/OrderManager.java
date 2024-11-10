package com.pluralsight;
import javax.xml.transform.Source;
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
    private Sandwich createSandwhich() {
        System.out.println("What size would you like? (4, 8, 12 inches): ");
        String size = scanner.nextLine();
        System.out.println("What bread would you like? (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();
        System.out.println("Would you like your sandwich toasted? (yes/no): ");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, breadType, new ArrayList<>(), isToasted);
        customizeSandwich(sandwhich);
        return sandwich;
    }
    private void addMeat(Sandwich sandwich) {
        System.out.println("What meat would you like? (steak, ham, salami, roast beef, chicken, bacon): ");
        String meat = scanner.nextLine();
        System.out.println("Would you like to add extra meat? (yes/no): ");
        boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");

        switch (sandwich.getSize()) {
            case "4":
                sandwich.addToppings(new PremiumToppings (meat, 1.00));
                if (extraMeat) {
                    sandwich.addTopping(new ExtraTopping(meat, 0.50));
                }
                break;
            case "8":
                sandwich.addTopping(new PremiumTopping(meat, 2.00));
                if (extraMeat) {
                    sandwich.addTopping(new ExtraTopping(meat, 1.00));
                }
                break;
            case "12":
                sandwich.addTopping(new PremiumTopping(meat, 3.00));
                if (extraMeat) {
                    sandwich.addTopping(new ExtraTopping(meat, 1.50));
                }
                break;
        }




    }
}
