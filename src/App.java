import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class App {
    private String ing1, ing2, ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String drinks;
    private static final long BLACKLISTED_NUMBER = 12345678901234L;

    public static void main(String[] args) {
        App order = new App();
        order.takeOrder();
        System.out.println(order);
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please pick any three of the following ingredients:");
        System.out.println("1. Mushroom");
        System.out.println("2. Paprika");
        System.out.println("3. Sun-dried tomatoes");
        System.out.println("4. Chicken");
        System.out.println("5. Pineapple");
        System.out.println("Enter any three choices (1, 2, 3, ...) separated by spaces:");

        boolean validIngredients = false;
        while (!validIngredients) {
            String[] inputs = scanner.nextLine().split(" ");
            if (inputs.length == 3) {
                try {
                    int ingChoice1 = Integer.parseInt(inputs[0]);
                    int ingChoice2 = Integer.parseInt(inputs[1]);
                    int ingChoice3 = Integer.parseInt(inputs[2]);

                    if (isValidChoice(ingChoice1) && isValidChoice(ingChoice2) && isValidChoice(ingChoice3)) {
                        switch (ingChoice1) {
                            case 1: ing1 = "Mushroom"; break;
                            case 2: ing1 = "Paprika"; break;
                            case 3: ing1 = "Sun-dried tomatoes"; break;
                            case 4: ing1 = "Chicken"; break;
                            case 5: ing1 = "Pineapple"; break;
                        }
                        switch (ingChoice2) {
                            case 1: ing2 = "Mushroom"; break;
                            case 2: ing2 = "Paprika"; break;
                            case 3: ing2 = "Sun-dried tomatoes"; break;
                            case 4: ing2 = "Chicken"; break;
                            case 5: ing2 = "Pineapple"; break;
                        }
                        switch (ingChoice3) {
                            case 1: ing3 = "Mushroom"; break;
                            case 2: ing3 = "Paprika"; break;
                            case 3: ing3 = "Sun-dried tomatoes"; break;
                            case 4: ing3 = "Chicken"; break;
                            case 5: ing3 = "Pineapple"; break;
                        }
                        validIngredients = true;
                    } else {
                        System.out.println("Invalid choice(s). Please pick only from the given list:");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice(s). Please enter numbers only.");
                }
            } else {
                System.out.println("Please enter exactly three choices.");
            }
        }

        System.out.println("What size should your pizza be?");
        System.out.println("1. Large");
        System.out.println("2. Medium");
        System.out.println("3. Small");
        System.out.println("Enter only one choice (1, 2, or 3):");

        int sizeChoice = 0;
        while (true) {
            try {
                sizeChoice = Integer.parseInt(scanner.nextLine());
                if (isValidSizeChoice(sizeChoice)) {
                    switch (sizeChoice) {
                        case 1: pizzaSize = "Large"; break;
                        case 2: pizzaSize = "Medium"; break;
                        case 3: pizzaSize = "Small"; break;
                    }
                    break;
                } else {
                    System.out.println("Invalid choice. Please pick only from the given list:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }

        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.nextLine().toUpperCase();

        System.out.println("Following are the side dishes that go well with your pizza:");
        System.out.println("1. Calzone");
        System.out.println("2. Garlic bread");
        System.out.println("3. Chicken puff");
        System.out.println("4. Muffin");
        System.out.println("5. Nothing for me");
        System.out.println("What would you like? Pick one (1, 2, 3, ...):");

        int sideDishChoice = 0;
        while (true) {
            try {
                sideDishChoice = Integer.parseInt(scanner.nextLine());
                if (isValidSideDishChoice(sideDishChoice)) {
                    switch (sideDishChoice) {
                        case 1: sideDish = "Calzone"; break;
                        case 2: sideDish = "Garlic bread"; break;
                        case 3: sideDish = "Chicken puff"; break;
                        case 4: sideDish = "Muffin"; break;
                        case 5: sideDish = "Nothing for me"; break;
                    }
                    break;
                } else {
                    System.out.println("Invalid choice. Please pick only from the given list:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }

        System.out.println("What drink would you like?");
        System.out.println("1. Soda");
        System.out.println("2. Water");
        System.out.println("3. Juice");
        System.out.println("Enter only one choice (1, 2, or 3):");

        int drinkChoice = 0;
        while (true) {
            try {
                drinkChoice = Integer.parseInt(scanner.nextLine());
                if (isValidDrinkChoice(drinkChoice)) {
                    switch (drinkChoice) {
                        case 1: drinks = "Soda"; break;
                        case 2: drinks = "Water"; break;
                        case 3: drinks = "Juice"; break;
                    }
                    break;
                } else {
                    System.out.println("Invalid choice. Please pick only from the given list:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }
    }

    private boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }

    private boolean isValidSizeChoice(int choice) {
        return choice >= 1 && choice <= 3;
    }

    private boolean isValidSideDishChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }

    private boolean isValidDrinkChoice(int choice) {
        return choice >= 1 && choice <= 3;
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Pizza Order:\n");
        receipt.append("Ingredients: ").append(ing1).append(", ").append(ing2).append(", ").append(ing3).append("\n");
        receipt.append("Size: ").append(pizzaSize).append("\n");
        receipt.append("Extra Cheese: ").append(extraCheese.equals("Y") ? "Yes" : "No").append("\n");
        receipt.append("Side Dish: ").append(sideDish).append("\n");
        receipt.append("Drink: ").append(drinks).append("\n");
        return receipt.toString();
    }
}
