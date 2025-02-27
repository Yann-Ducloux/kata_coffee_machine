package org.example.service;

import org.example.checker.MoneyChecker;
import org.example.entity.Command;
import org.example.Drink;
import org.example.exception.LackMoneyException;

import java.util.*;

public class DrinkMakerService {

    private static final int STICK = 0;
    private static final int ZERO_SUGAR = 0;
    private static final String SEPARATOR = ":";
    private static final int SUPERIOR_OF_ZERO = 1;
    public static final String SEPARATOR_REPORT = "     : ";
    public static final String LEGEND_REPORT = "Drinks : quantity";
    public static final String TITLE_REPORT = "report:";
    public MoneyChecker moneyChecker;
    private Map<Drink, Integer> drinks = new HashMap<>();

    public DrinkMakerService(MoneyChecker moneyChecker) {
        this.moneyChecker = moneyChecker;
        drinks.put(Drink.COFFEE, 0);
        drinks.put(Drink.HOT_COFFEE, 0);
        drinks.put(Drink.CHOCOLATE, 0);
        drinks.put(Drink.HOT_CHOCOLATE, 0);
        drinks.put(Drink.ORANGE_JUICE, 0);
        drinks.put(Drink.TEA, 0);
        drinks.put(Drink.HOT_TEA, 0);
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
        int increaseCounterOfDrink = drinks.get(drink) + 1;
        drinks.put(drink, increaseCounterOfDrink);
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
        StringBuilder report = new StringBuilder(TITLE_REPORT + System.lineSeparator() +
                LEGEND_REPORT + System.lineSeparator());
        List<Drink> drinkss = new ArrayList<>();
        for (Drink drinksss : Drink.values()) {
            drinkss.add(drinksss);
        }
        drinkss.sort(Comparator.comparing(drink -> drink.getBoisson()));
        drinkss.forEach(drink -> {
                    report.append(drink.getBoissonReport());
                    report.append(SEPARATOR_REPORT);
                    report.append(drinks.get(drink));
                    report.append(System.lineSeparator());
                });
        return report.toString();
    }
}
