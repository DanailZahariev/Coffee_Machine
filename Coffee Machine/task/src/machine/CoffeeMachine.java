package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int totalWater = 400;
    static int totalMilk = 540;
    static int totalBeans = 120;
    static int totalCups = 9;
    static int totalMoney = 550;
    static Boolean exit = false;
    static Scanner scanner = new Scanner(System.in);

    enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING

    }

    static Status curStatus = Status.CHOOSING;

    public static void main(String[] args) {

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    curStatus = Status.BUYING;
                    buy();
                    break;
                case "fill":
                    curStatus = Status.FILLING;
                    fill();
                    break;
                case "take":
                    curStatus = Status.TAKING;
                    take();
                    break;
                case "remaining":
                    curStatus = Status.REMAINING;
                    machineHas();
                    break;
                case "exit":
                    curStatus = Status.EXITING;
                    exit();
                    break;
            }
        } while (curStatus != Status.EXITING);
    }

    private static void machineHas() {
        System.out.println("The coffee machine has:");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalBeans + " g of coffee beans");
        System.out.println(totalCups + " disposable cups");
        System.out.println("$" + totalMoney + " of money");
    }

    public static void buy() {
        System.out.println();
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeChoice = scanner.next();
        switch (coffeeChoice) {
            case "1": {
                if (enoughIngredients(250, 0, 16)) {
                    totalWater -= 250;
                    totalBeans = totalBeans - 16;
                    totalMoney += 4;
                    totalCups -= 1;
                    break;
                }
            }
            case "2": {
                if (enoughIngredients(350, 75, 20)) {
                    totalWater -= 350;
                    totalMilk -= 75;
                    totalBeans -= 20;
                    totalMoney += 7;
                    totalCups -= 1;
                    break;
                }
            }
            case "3": {
                if (enoughIngredients(200, 100, 12)) {
                    totalWater -= 200;
                    totalMilk -= 100;
                    totalBeans -= 12;
                    totalMoney += 6;
                    totalCups -= 1;
                    break;
                }
            }
            case "back": {
                break;
            }
            default:
                break;
        }
        curStatus = Status.CHOOSING;
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        totalWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        totalMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        totalBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        totalCups += scanner.nextInt();
        curStatus = Status.CHOOSING;
    }

    public static void take() {
        System.out.println("I gave you $ " + totalMoney);
        totalMoney = 0;
        curStatus = Status.CHOOSING;
    }

    public static boolean enoughIngredients(int waterNeeded, int beansNeeded, int milkNeeded) {
        if (totalWater >= waterNeeded) {
            if (totalMilk >= milkNeeded) {
                if (totalBeans >= beansNeeded) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }
            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    static void exit() {
        curStatus = Status.EXITING;
    }
}