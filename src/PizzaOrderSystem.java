import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

enum PizzaSelection {
    ;

    double getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }
    // ... 保持原有枚举定义不变 ...
}

enum PizzaToppings {
    ;

    double getToppingPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getToppingPrice'");
    }
    // ... 保持原有枚举定义不变 ...
    
        Object getTopping() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getTopping'");
        }
    }
    
    enum PizzaSize {
            ;
    
            double getAddToPizzaPrice() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getAddToPizzaPrice'");
            }
            // ... 保持原有枚举定义不变 ...
        }
        
        enum SideDish {
                    ;
        
                    double getAddToPizzaPrice() {
                        // TODO Auto-generated method stub
                        throw new UnsupportedOperationException("Unimplemented method 'getAddToPizzaPrice'");
                    }
                    // ... 保持原有枚举定义不变 ...
                }
                
                enum Drinks {
                                    ;
                
                                    double getAddToPizzaPrice() {
                                        // TODO Auto-generated method stub
                                        throw new UnsupportedOperationException("Unimplemented method 'getAddToPizzaPrice'");
                                    }
                                    // ... 保持原有枚举定义不变 ...
                                }
                                
                                public class PizzaOrderSystem {
                                    private static final double PIZZA_BASE_PRICE = 10.0;
                                    private static List<String> pizzasOrdered = new ArrayList<>();
                                    private static List<String> pizzaSizesOrdered = new ArrayList<>();
                                    private static List<String> sideDishesOrdered = new ArrayList<>();
                                    private static List<String> drinksOrdered = new ArrayList<>();
                                    private static double totalOrderPrice = 0;
                                
                                    private static Scanner scanner = new Scanner(System.in);
                                
                                    public static void main(String[] args) {
                                        takeOrder();
                                        System.out.println(generateOrderSummary());
                                    }
                                
                                    private static void takeOrder() {
                                        boolean ordering = true;
                                        
                                        while (ordering) {
                                            displayPizzaMenu();
                                            
                                            int choice = getValidIntInput("Please enter your choice (1-6): ", 1, 6);
                                
                                            if (choice <= 5) {
                                                handlePredefinedPizza(choice);
                                            } else {
                                                buildCustomPizza();
                                            }
                                
                                            selectSize();
                                            selectSideDish();
                                            selectDrink();
                                
                                            System.out.print("Would you like to order more? (y/n): ");
                                            ordering = scanner.next().equalsIgnoreCase("y");
                                            scanner.nextLine(); // 清除缓冲区
                                        }
                                    }
                                
                                    private static void displayPizzaMenu() {
                                        System.out.println("\nWelcome to Slice-o-Heaven Pizzeria. Here's what we serve:");
                                        int index = 1;
                                        for (PizzaSelection pizza : PizzaSelection.values()) {
                                            if (index <= 5) {
                                                System.out.println(index + ". " + pizza);
                                            }
                                            index++;
                                        }
                                        System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose");
                                    }
                                
                                    private static void handlePredefinedPizza(int choice) {
                                        PizzaSelection selected = PizzaSelection.values()[choice-1];
                                        totalOrderPrice += selected.getPrice();
                                        pizzasOrdered.add(selected.toString());
                                    }
                                
                                    private static void buildCustomPizza() {
                                        System.out.println("\nAvailable toppings:");
                                        int toppingIndex = 1;
                                        for (PizzaToppings topping : PizzaToppings.values()) {
                                            System.out.println(toppingIndex + ". " + topping);
                                            toppingIndex++;
                                        }
                                
                                        double customPrice = PIZZA_BASE_PRICE;
                                        StringBuilder toppings = new StringBuilder();
                                        
                                        System.out.println("\nEnter up to 10 toppings (enter 0 to finish):");
                                        for (int i = 0; i < 10; i++) {
                                            int choice = getValidIntInput("Choose topping (" + (i+1) + "/10): ", 0, PizzaToppings.values().length);
                                            if (choice == 0) break;
                                            
                                            PizzaToppings topping = PizzaToppings.values()[choice-1];
                                            customPrice += topping.getToppingPrice();
                                            toppings.append(topping.getTopping()).append(", ");
                                    }
                            
                                    String description = String.format("Custom Pizza with %sfor €%.1f", 
                                        toppings.length() > 0 ? toppings.substring(0, toppings.length()-2) : "no toppings", 
                                        customPrice);
                                    
                                    pizzasOrdered.add(description);
                                    totalOrderPrice += customPrice;
                                }
                            
                                private static void selectSize() {
                                    System.out.println("\nAvailable sizes:");
                                    int index = 1;
                                    for (PizzaSize size : PizzaSize.values()) {
                                        System.out.println(index + ". " + size);
                                        index++;
                                    }
                                    int choice = getValidIntInput("Choose size (1-3): ", 1, 3);
                                    PizzaSize size = PizzaSize.values()[choice-1];
                                    totalOrderPrice += size.getAddToPizzaPrice();
                                pizzaSizesOrdered.add(size.toString());
                            }
                        
                            private static void selectSideDish() {
                                System.out.println("\nAvailable side dishes:");
                                int index = 1;
                                for (SideDish side : SideDish.values()) {
                                    System.out.println(index + ". " + side);
                                    index++;
                                }
                                int choice = getValidIntInput("Choose side dish (1-4): ", 1, 4);
                                SideDish side = SideDish.values()[choice-1];
                                totalOrderPrice += side.getAddToPizzaPrice();
                        sideDishesOrdered.add(side.toString());
                    }
                
                    private static void selectDrink() {
                        System.out.println("\nAvailable drinks:");
                        int index = 1;
                        for (Drinks drink : Drinks.values()) {
                            System.out.println(index + ". " + drink);
                            index++;
                        }
                        int choice = getValidIntInput("Choose drink (1-3): ", 1, 3);
                        Drinks drink = Drinks.values()[choice-1];
                        totalOrderPrice += drink.getAddToPizzaPrice();
        drinksOrdered.add(drink.toString());
    }

    private static int getValidIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Invalid input, please enter a number between " + min + " and " + max);
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number");
                scanner.nextLine(); // 清除无效输入
            }
        }
    }

    private static String generateOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nThank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:\n");
        
        for (int i = 0; i < pizzasOrdered.size(); i++) {
            sb.append(i+1).append(". ").append(pizzasOrdered.get(i)).append("\n");
            sb.append(pizzaSizesOrdered.get(i)).append("\n");
            sb.append(sideDishesOrdered.get(i)).append("\n");
            sb.append(drinksOrdered.get(i)).append("\n\n");
        }
        
        sb.append("ORDER TOTAL: €").append(String.format("%.1f", totalOrderPrice));
        return sb.toString();
    }
}