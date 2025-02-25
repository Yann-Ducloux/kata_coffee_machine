package org.example.service;

import org.example.checker.MoneyChecker;
import org.example.entity.Command;
import org.example.Drink;

public class DrinkMakerService {

    public static final int STICK = 0;
    public static final int ZERO_SUGAR = 0;
    public static final String SEPARATOR = ":";
    public static final double CENT = 100.0;
    public static final int SUPERIOR_OF_ZERO = 1;
    public MoneyChecker moneyChecker;

    public DrinkMakerService(MoneyChecker moneyChecker) {
        this.moneyChecker = moneyChecker;
    }

    public Command make(Drink drink, Integer numberOfSugar, Double price) {
        StringBuilder stringBuilder = new StringBuilder();
        moneyChecker(drink, price);
        addDrink(drink, stringBuilder);
        AddOrNotSugarAndCuillere(numberOfSugar, stringBuilder);
        return new Command(stringBuilder.toString(), calculRendered(drink, price));
    }

    private static Double calculRendered(Drink drink, Double price) {
        Double rendered = price - drink.getPrice();
        Double renderedWithTwoDecimal = Math.round(rendered*CENT)/CENT;
        return renderedWithTwoDecimal;
    }

    private static void moneyChecker(Drink drink, Double price) {
        MoneyChecker.NegativeMoneyChecker(price);
        MoneyChecker.LackMoneyChecker(drink, price);
    }


    private static void addDrink(Drink drink, StringBuilder stringBuilder) {
        stringBuilder.append(drink.getBoisson());
        stringBuilder.append(SEPARATOR);
    }

    private static void AddOrNotSugarAndCuillere(Integer numberOfSugar, StringBuilder stringBuilder) {
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
}
