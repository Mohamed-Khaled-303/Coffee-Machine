package coffee;

import java.util.Scanner;

public class CoffeeMachine {
    private static class Espresso{
        public static final int price = 4;
        public static final int AMOUNT_OF_WATER_PER_CUP = 250;
        public static final int AMOUNT_OF_COFFEE_BEANS_PER_CUP = 16;
        public static final int DISPOSABLE_CUPS_NEEDED = 1;
    }

    private static class Latte{
        public static final int price = 7;
        public static final int AMOUNT_OF_WATER_PER_CUP = 350;
        public static final int AMOUNT_OF_MILK_PER_CUP = 75;
        public static final int AMOUNT_OF_COFFEE_BEANS_PER_CUP = 20;
        public static final int DISPOSABLE_CUPS_NEEDED = 1;

    }

    private static class Cappuccino{
        public static final int AMOUNT_OF_WATER_PER_CUP = 200;
        public static final int AMOUNT_OF_MILK_PER_CUP = 100;
        public static final int AMOUNT_OF_COFFEE_BEANS_PER_CUP = 12;
        public final static int price = 6;
        public static final int DISPOSABLE_CUPS_NEEDED = 1;

    }

    private Scanner scanner = new Scanner(System.in);
    private int amountOfWaterMachineHas;
    private int amountOfMilkMachineHas;
    private int amountOfCoffeeBeansMachineHas;
    private int amountOfDisposableCupsMachineHas;
    private int amountOfMoneyMachineHas;

    public CoffeeMachine() {
        initializeResources();
    }

    private void initializeResources() {
        amountOfWaterMachineHas = 400;
        amountOfMilkMachineHas = 540;
        amountOfCoffeeBeansMachineHas = 120;
        amountOfDisposableCupsMachineHas = 9;
        amountOfMoneyMachineHas = 550;
    }

    private void showRemainingResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", amountOfWaterMachineHas);
        System.out.printf("%d ml of milk\n", amountOfMilkMachineHas);
        System.out.printf("%d g of coffee beans\n", amountOfCoffeeBeansMachineHas);
        System.out.printf("%d disposable cups\n", amountOfDisposableCupsMachineHas);
        System.out.printf("$%d of money\n", amountOfMoneyMachineHas);
    }

    public void start() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();

            if (action.equals("exit"))
                break;
            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,  back - to main menu: ");
                String chooise = scanner.next();
                if (chooise.equals("back"))
                    continue;
                buy(chooise);
            }
            if (action.equals("take"))
                takeMoney();
            if (action.equals("fill"))
                fill();
            if (action.equals("remaining"))
                showRemainingResources();
        }
    }
    private void takeMoney() {
        System.out.println("I gave you" + amountOfMoneyMachineHas);
        amountOfMoneyMachineHas = 0;
    }

    private void fill() {
        fillWater();
        fillMilk();
        fillCoffeeBeans();
        fillDisposableCups();
    }

    private void fillWater() {
        System.out.println("Write how many ml of water you want to add: ");
        int water = scanner.nextInt();
        amountOfWaterMachineHas += water;
    }

    private void fillMilk() {
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = scanner.nextInt();
        amountOfMilkMachineHas += milk;
    }

    private void fillCoffeeBeans() {
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int beans = scanner.nextInt();
        amountOfCoffeeBeansMachineHas += beans;
    }

    private void fillDisposableCups() {
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int cups = scanner.nextInt();
        amountOfDisposableCupsMachineHas += cups;
    }

    private void buy(String chooise) {
        if (chooise.equals("1"))
            buyEspresso();
        if (chooise.equals("2"))
            buyLatte();
        if (chooise.equals("3"))
            buyCappuccino();
    }

    private void buyEspresso() {
        if (amountOfWaterMachineHas < Espresso.AMOUNT_OF_WATER_PER_CUP)
            System.out.println("Sorry, not enough water!");
        else if (amountOfCoffeeBeansMachineHas < Espresso.AMOUNT_OF_COFFEE_BEANS_PER_CUP)
            System.out.println("Sorry, not enough coffee beans!");
        else if (amountOfDisposableCupsMachineHas < Espresso.DISPOSABLE_CUPS_NEEDED)
            System.out.println("Sorry, not enough disposable cups!");
        else {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWaterMachineHas -= Espresso.AMOUNT_OF_WATER_PER_CUP;
            amountOfCoffeeBeansMachineHas -= Espresso.AMOUNT_OF_COFFEE_BEANS_PER_CUP;
            amountOfDisposableCupsMachineHas -= Espresso.DISPOSABLE_CUPS_NEEDED;
            amountOfMoneyMachineHas += Espresso.price;
        }
    }

    private void buyLatte() {
        if (amountOfWaterMachineHas < Latte.AMOUNT_OF_WATER_PER_CUP)
            System.out.println("Sorry, not enough water!");
        else if (amountOfCoffeeBeansMachineHas < Latte.AMOUNT_OF_COFFEE_BEANS_PER_CUP)
            System.out.println("Sorry, not enough coffee beans!");
        else if (amountOfDisposableCupsMachineHas < Latte.DISPOSABLE_CUPS_NEEDED)
            System.out.println("Sorry, not enough disposable cups!");
        else if (amountOfMilkMachineHas < Latte.AMOUNT_OF_MILK_PER_CUP)
            System.out.println("Sorry, not enough milk!");
        else {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWaterMachineHas -= Latte.AMOUNT_OF_WATER_PER_CUP;
            amountOfMilkMachineHas -= Latte.AMOUNT_OF_MILK_PER_CUP;
            amountOfCoffeeBeansMachineHas -= Latte.AMOUNT_OF_COFFEE_BEANS_PER_CUP;
            amountOfDisposableCupsMachineHas -= Latte.DISPOSABLE_CUPS_NEEDED;
            amountOfMoneyMachineHas += Latte.price;
        }
    }

    private void buyCappuccino() {
        if (amountOfWaterMachineHas < Cappuccino.AMOUNT_OF_WATER_PER_CUP)
            System.out.println("Sorry, not enough water!");
        else if (amountOfCoffeeBeansMachineHas < Cappuccino.AMOUNT_OF_COFFEE_BEANS_PER_CUP)
            System.out.println("Sorry, not enough coffee beans!");
        else if (amountOfDisposableCupsMachineHas < Cappuccino.DISPOSABLE_CUPS_NEEDED)
            System.out.println("Sorry, not enough disposable cups!");
        else if (amountOfMilkMachineHas < Cappuccino.AMOUNT_OF_MILK_PER_CUP)
            System.out.println("Sorry, not enough milk!");
        else {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWaterMachineHas -= Cappuccino.AMOUNT_OF_WATER_PER_CUP;
            amountOfMilkMachineHas -= Cappuccino.AMOUNT_OF_MILK_PER_CUP;
            amountOfCoffeeBeansMachineHas -= Cappuccino.AMOUNT_OF_COFFEE_BEANS_PER_CUP;
            amountOfDisposableCupsMachineHas -= Cappuccino.DISPOSABLE_CUPS_NEEDED;
            amountOfMoneyMachineHas += Cappuccino.price;
        }
    }



}

