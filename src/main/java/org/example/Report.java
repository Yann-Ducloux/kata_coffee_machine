package org.example;

import org.example.entity.Drink;

import java.util.EnumMap;
import java.util.Map;

public class Report {
    private final Map<Drink, Integer> drinks;
    public static final String SEPARATOR_REPORT = "     : ";
    public static final String LEGEND_REPORT = "Drinks : quantity";
    public static final String TITLE_REPORT = "report:";

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
        int increaseCounterOfDrink = drinks.get(drink) + 1;
        drinks.put(drink, increaseCounterOfDrink);
    }

    public String print() {
        StringBuilder report = new StringBuilder(TITLE_REPORT + System.lineSeparator() +
                LEGEND_REPORT + System.lineSeparator());
        Drink.getDrinksByOrderAlphabetic().forEach(drink -> {
            report.append(drink.getBoissonReport());
            report.append(SEPARATOR_REPORT);
            report.append(drinks.get(drink));
            report.append(System.lineSeparator());
        });
        return report.toString();
    }
}
