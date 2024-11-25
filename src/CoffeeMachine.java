import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Request user input for available resources
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int grams = input.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = input.nextInt();

        // Calculate how many cups can be made with the available resources
        int maxCupsByWater = water / 200;
        int maxCupsByMilk = milk / 50;
        int maxCupsByBeans = grams / 15;

        // Find the minimum number of cups that can be made by the limiting resource
        int maxPossibleCups = Math.min(maxCupsByWater, Math.min(maxCupsByMilk, maxCupsByBeans));

        // Determine the output based on the number of cups requested and the available resources
        if (cups <= maxPossibleCups) {
            if (cups == maxPossibleCups) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                int additionalCups = maxPossibleCups - cups;
                System.out.println("Yes, I can make that amount of coffee (and even " + additionalCups + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + maxPossibleCups + " cup(s) of coffee");
        }

        input.close();



    }
}
