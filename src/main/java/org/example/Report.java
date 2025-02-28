package org.example;

import org.example.entity.Drink;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public class Report {
    public static final String MONEY = "€";
    public static final String TOTAL_AMOUNT = "Total amount: ";
    public static final String PATTERN = "#.##";
    private final Map<Drink, Integer> drinks;
    private static final String SEPARATOR_REPORT = "     : ";
    private static final String LEGEND_REPORT = "Drinks : quantity";
    private static final String TITLE_REPORT = "report:";
    private double totalAmount = 0;
    public Report() {
        drinks = new EnumMap<>(Drink.class);
        drinks.put(Drink.COFFEE, 0);
        drinks.put(Drink.HOT_COFFEE, 0);
        drinks.put(Drink.CHOCOLATE, 0);
        drinks.put(Drink.HOT_CHOCOLATE, 0);
        drinks.put(Drink.ORANGE_JUICE, 0);
        drinks.put(Drink.TEA, 0);
        drinks.put(Drink.HOT_TEA, 0);
    }

    public void addDrinkCommand(Drink drink) {
        incrementDrintCommand(drink);
        addPriceInTotalAmount(drink);
    }
    private void incrementDrintCommand(Drink drink) {
        int increaseCounterOfDrink = drinks.get(drink) + 1;
        drinks.put(drink, increaseCounterOfDrink);
    }

    private void addPriceInTotalAmount(Drink drink) {
        totalAmount += drink.getPrice();
    }


    public String print() {
        StringBuilder report = new StringBuilder();
        displayTitle(report);
        displayDetailCommand(report);
        displayTotalAmount(report);
        return report.toString();
    }

    private static void displayTitle(StringBuilder report) {
        report.append(TITLE_REPORT + System.lineSeparator() +
                LEGEND_REPORT + System.lineSeparator());
    }

    private void displayDetailCommand(StringBuilder report) {
        Drink.getDrinksByOrderAlphabetic().forEach(drink -> {
            report.append(drink.getBoissonReport());
            report.append(SEPARATOR_REPORT);
            report.append(drinks.get(drink));
            report.append(System.lineSeparator());
        });
    }

    private void displayTotalAmount(StringBuilder report) {
        DecimalFormat df = new DecimalFormat(PATTERN);
        report.append(TOTAL_AMOUNT + df.format(totalAmount) + MONEY);
    }
}
