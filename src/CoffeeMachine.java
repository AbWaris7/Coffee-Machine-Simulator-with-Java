import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;
    private int money = 550;
    private int cupsMade = 0;

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "buy":
                    buy(scanner);
                    break;
                case "fill":
                    fill(scanner);
                    break;
                case "take":
                    take();
                    break;
                case "clean":
                    clean();
                    break;
                case "remaining":
                    displayState();
                    break;
                case "exit":
                    return; // Exit the loop and terminate the program
                default:
                    System.out.println("Invalid action. Try again.");
            }
        }
    }

    private void clean() {
        if (cupsMade >= 10) {
            System.out.println("I have been cleaned!");
            cupsMade = 0;  // Reset the counter after cleaning
        } else {
            System.out.println("The machine does not need cleaning yet.");
        }
    }

    private void buy(Scanner scanner) {
        if (cupsMade >= 10) {
            System.out.println("I need cleaning!");
            return;
        }

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.nextLine().trim();

        if (choice.equals("back")) {
            return; // Go back to the main menu
        }

        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= beansNeeded;
            cups--;
            money += price;
            cupsMade++;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addedCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int addedCups = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character

        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        cups += addedCups;
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void displayState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
