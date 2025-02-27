package org.example.service;

import org.example.Report;
import org.example.checker.MoneyChecker;
import org.example.entity.Command;
import org.example.entity.Drink;
import org.example.exception.LackMoneyException;

public class DrinkMakerService {

    private static final int STICK = 0;
    private static final int ZERO_SUGAR = 0;
    private static final String SEPARATOR = ":";
    private static final int SUPERIOR_OF_ZERO = 1;
    public MoneyChecker moneyChecker;
    private Report report;

    public DrinkMakerService(MoneyChecker moneyChecker, Report report) {
        this.moneyChecker = moneyChecker;
        this.report = report;
    }

    public Command make(Drink drink, Integer numberOfSugar, Double price) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            moneyChecker(drink, price);
            addDrink(drink, stringBuilder);
            addOrNotSugarAndStick(numberOfSugar, stringBuilder);
            this.report.addDrinkCommand(drink);
        } catch (LackMoneyException e) {
            stringBuilder.append("M: ").append(e.getMessage());
        }
        return new Command(stringBuilder.toString());
    }


    private static void moneyChecker(Drink drink, Double price) {
        MoneyChecker.LackMoneyChecker(drink, price);
    }


    private static void addDrink(Drink drink, StringBuilder stringBuilder) {
        stringBuilder.append(drink.getBoisson());
        stringBuilder.append(SEPARATOR);
    }

    private static void addOrNotSugarAndStick(Integer numberOfSugar, StringBuilder stringBuilder) {
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

    public String reportPrint() {
        return this.report.print();
    }
}
