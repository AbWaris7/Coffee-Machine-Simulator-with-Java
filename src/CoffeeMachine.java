import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        Scanner input = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = input.nextInt();
        int waterAmount = cups * 200;
        int milkAmount = cups * 50;
        int coffeeBeansAmount = cups * 15;

        System.out.println("For "+cups +" cups of coffee you will need: ");
        System.out.println(waterAmount+" ml of water");
        System.out.println(milkAmount+" ml of milk");
        System.out.println(coffeeBeansAmount+" g coffee beans");
    }
}
