

import java.util.Scanner;

public class CoffeeMachine {

    int milk;
    int coffeeBeans;
    int cups;
    int money;
    int water;


    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }


    private void fill(Scanner scanner) {
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += scanner.nextInt();
    }


    private enum Coffee {

        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        int waterNeeded;
        int milkNeeded;
        int coffeeBeansNeeded;
        int price;

        Coffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int price) {
            this.waterNeeded = waterNeeded;
            this.milkNeeded = milkNeeded;
            this.coffeeBeansNeeded = coffeeBeansNeeded;
            this.price = price;
        }
    }


    private void allActions() {
        stateCoffeeMachine();
        actionCoffeeMachine();
        stateCoffeeMachine();
    }


    public void stateCoffeeMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.coffeeBeans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.money + " of money\n");
    }


    private void stateChanger(Coffee coffee) {
        this.water -= coffee.waterNeeded;
        this.milk -= coffee.milkNeeded;
        this.coffeeBeans -= coffee.coffeeBeansNeeded;
        this.cups -= 1;
        this.money += coffee.price;
    }


    private void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffeeNumber = scanner.nextInt();
        Coffee selectedCoffee;
        switch (coffeeNumber) {
            case 1:
                selectedCoffee = Coffee.ESPRESSO;
                break;
            case 2:
                selectedCoffee = Coffee.LATTE;
                break;
            case 3:
            default:
                selectedCoffee = Coffee.CAPPUCCINO;
                break;
        }

        stateChanger(selectedCoffee);
    }


    private void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }


    public void actionCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.next();
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
            default:
                break;
        }
    }


    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.stateCoffeeMachine();
        coffeeMachine.actionCoffeeMachine();
        coffeeMachine.stateCoffeeMachine();
    }
}