package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static int waterInMachine = 400;
    public static int milkInMachine = 540;
    public static int coffeeBeansInMachine = 120;
    public static int disposableCuspInMachine = 9;
    public static int moneyInMachine = 550;

    static int espressoWater = 250;
    static int espressoMilk = 0;
    static int espressoCoffeeBeans = 16;
    static int espressoPrice = 4;

    static int latteWater = 350;
    static int latteMilk = 75;
    static int latteCoffeeBeans = 20;
    static int lattePrice = 7;

    static int cappuccinoWater = 200;
    static int cappuccinoMilk = 100;
    static int cappuccinoCoffeeBeans = 12;
    static int cappuccinoPrice = 6;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            if (writeAction(sc)) {
                break;
            }
        }
        sc.close();
    }

    public static boolean writeAction(Scanner sc) {

        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        if (!sc.hasNextLine()) {
            return true;
        }
        String input = sc.nextLine();

        boolean shouldExit = false;

        switch (input) {
            case "buy":
                buy(sc);
                break;
            case "fill":
                fill(sc);
                break;
            case "take":
                take();
                break;
            case "remaining":
                coffeeMachineRemaining();
                break;
            case "exit":
                shouldExit = true;
            //default:
                System.out.println("That is not a valid input");
        }
        if (shouldExit) {
            sc.close();
            return true;
        }
        return false;
    }

    public static boolean enoughCoffeeResources(String typeOfCoffee) {

        boolean temp = true;
        switch (typeOfCoffee) {
            case "1":
                if (waterInMachine < espressoWater) {
                    temp = false;
                    System.out.println("Sorry, not enough water!\n");
                }
                if (milkInMachine < espressoMilk) {
                    temp = false;
                    System.out.println("Sorry, not enough milk!\n");
                }
                if (coffeeBeansInMachine < espressoCoffeeBeans) {
                    temp = false;
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
                break;
            case "2":
                if (waterInMachine < latteWater) {
                    temp = false;
                    System.out.println("Sorry, not enough water!\n");
                }
                if (milkInMachine < latteMilk) {
                    temp = false;
                    System.out.println("Sorry, not enough milk!\n");
                }
                if (coffeeBeansInMachine < latteCoffeeBeans) {
                    temp = false;
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
                break;
            case "3":
                if (waterInMachine < cappuccinoWater) {
                    temp = false;
                    System.out.println("Sorry, not enough water!\n");
                }
                if (milkInMachine < cappuccinoMilk) {
                    temp = false;
                    System.out.println("Sorry, not enough milk!\n");
                }
                if (coffeeBeansInMachine < cappuccinoCoffeeBeans) {
                    temp = false;
                    System.out.println("Sorry, not enough coffee beans!\n");
                }
                break;
            default:
                break;
        }
        return temp;
    }

    public static void buy(Scanner sc) {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu");
        String input = sc.next();

        if (input.equals("back")) {
            return;
        }
        if (enoughCoffeeResources(input)) {
            switch (input) {
                case "1":
                    System.out.println("I have enough resources, making you a coffee!\n");
                    waterInMachine -= espressoWater;
                    milkInMachine -= espressoMilk;
                    coffeeBeansInMachine -= espressoCoffeeBeans;
                    moneyInMachine += espressoPrice;
                    disposableCuspInMachine -= 1;
                    break;
                case "2":
                    System.out.println("I have enough resources, making you a coffee!\n");
                    waterInMachine -= latteWater;
                    milkInMachine -= latteMilk;
                    coffeeBeansInMachine -= latteCoffeeBeans;
                    moneyInMachine += lattePrice;
                    disposableCuspInMachine -= 1;
                    break;
                case "3":
                    System.out.println("I have enough resources, making you a coffee!\n");
                    waterInMachine -= cappuccinoWater;
                    milkInMachine -= cappuccinoMilk;
                    coffeeBeansInMachine -= cappuccinoCoffeeBeans;
                    moneyInMachine += cappuccinoPrice;
                    disposableCuspInMachine -= 1;
                    break;
                default:
                    System.out.println("That is not a valid input");
                    break;
            }
        }
    }

    public static void fill(Scanner sc) {

        System.out.println("Write how many ml of water you want to add: ");
        waterInMachine += sc.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        milkInMachine += sc.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeansInMachine += sc.nextInt();

        System.out.println("Write how many disposable cups you want to add: ");
        disposableCuspInMachine += sc.nextInt();
    }

    public static void take() {
        System.out.printf("I gave you $%d\n", moneyInMachine);
        moneyInMachine = 0;
    }

    public static void coffeeMachineRemaining() {

        System.out.println();
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, waterInMachine, milkInMachine, coffeeBeansInMachine, disposableCuspInMachine, moneyInMachine);
        System.out.println();
    }
}

    /*
        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP = 50;
        final int COFFEE_PER_CUP = 15;



        System.out.println("Write how many ml of water the coffee machine has:");
        int waterLeft = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkLeft = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeLeft = sc.nextInt();

        //System.out.println("How many cups of coffee would you like?");
        int numCups = sc.nextInt();

        /*
        System.out.printf("For %d coffee, you will need:", numCups);
        System.out.println();
        System.out.println(numCups * WATER_PER_CUP + "ml of water");
        System.out.println(numCups * MILK_PER_CUP + "ml of milk");
        System.out.println(numCups * COFFEE_PER_CUP + "g of coffee beans");
        */
/*
        int waterNeeded = waterLeft / WATER_PER_CUP;
        int milkNeeded = milkLeft / MILK_PER_CUP;
        int coffeeBeansNeeded = coffeeLeft / COFFEE_PER_CUP;

        int maxNumCups = Math.min(Math.min(waterNeeded, milkNeeded), coffeeBeansNeeded);

        if (maxNumCups >= numCups) {
            if (maxNumCups == numCups) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", maxNumCups - numCups);
            }
        }else {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxNumCups);
        }

    }*/

