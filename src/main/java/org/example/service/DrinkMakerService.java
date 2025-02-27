package org.example.service;

import org.example.checker.MoneyChecker;
import org.example.entity.Command;
import org.example.Drink;
import org.example.exception.LackMoneyException;

public class DrinkMakerService {

    public static final int STICK = 0;
    public static final int ZERO_SUGAR = 0;
    public static final String SEPARATOR = ":";
    public static final double CENT = 100.0;
    public static final int SUPERIOR_OF_ZERO = 1;
    public MoneyChecker moneyChecker;
    public int commandCoffee = 0;
    public int commandHotCoffee = 0;
    public int commandChocolate = 0;
    public int commandHotChocolate = 0;
    public int commandOrange = 0;
    public int commandTea = 0;
    public int commandHotTea = 0;


    public DrinkMakerService(MoneyChecker moneyChecker) {
        this.moneyChecker = moneyChecker;
    }

    public Command make(Drink drink, Integer numberOfSugar, Double price) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            moneyChecker(drink, price);
            addDrink(drink, stringBuilder);
            AddOrNotSugarAndStick(numberOfSugar, stringBuilder);
            historyDrinkOfDay(drink);
        } catch (LackMoneyException e) {
            stringBuilder.append("M: ").append(e.getMessage());
        }
        return new Command(stringBuilder.toString());
    }

    private void historyDrinkOfDay(Drink drink) {
        if (drink == Drink.HOT_COFFEE) {
            commandHotCoffee++;
        } else if (drink == Drink.COFFEE) {
            commandCoffee++;
        } else if (drink == Drink.CHOCOLATE) {
            commandChocolate++;
        } else if (drink == Drink.HOT_CHOCOLATE) {
            commandHotChocolate++;
        } else if (drink == Drink.ORANGE_JUICE) {
            commandOrange++;
        } else if (drink == Drink.TEA) {
            commandTea++;
        } else if (drink == Drink.HOT_TEA) {
            commandHotTea++;
        }
    }

    private static void moneyChecker(Drink drink, Double price) {
        MoneyChecker.LackMoneyChecker(drink, price);
    }


    private static void addDrink(Drink drink, StringBuilder stringBuilder) {
        stringBuilder.append(drink.getBoisson());
        stringBuilder.append(SEPARATOR);
    }

    private static void AddOrNotSugarAndStick(Integer numberOfSugar, StringBuilder stringBuilder) {
        boolean haveSugar = numberOfSugar.compareTo(ZERO_SUGAR) == SUPERIOR_OF_ZERO;
        if (haveSugar) {
            addSugar(numberOfSugar, stringBuilder);
        } else {
            stringBuilder.append(SEPARATOR);
        }
    }

    private static void addSugar(Integer numberOfSugar, StringBuilder stringBuilder) {
        stringBuilder.append(numberOfSugar);
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(STICK);
    }

    public String report() {
        String report = "report:" + System.lineSeparator() +
                "Drinks : quantity"+ System.lineSeparator() +
                "C      : " + commandCoffee + System.lineSeparator() +
                "Ch     : " + commandHotCoffee + System.lineSeparator() +
                "H      : " + commandChocolate + System.lineSeparator() +
                "Hh     : " + commandHotChocolate + System.lineSeparator() +
                "O      : " + commandOrange + System.lineSeparator() +
                "T      : " + commandTea + System.lineSeparator() +
                "Th     : " + commandHotTea;
        return report;
    }
}
