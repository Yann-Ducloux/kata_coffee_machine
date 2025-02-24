package org.example;

public class DrinkMakerService {

    public static final int CUILLERE = 0;
    public static final int ZERO_SUGAR = 0;
    public static final String SEPARATOR = ":";

    public Command make(Drink drink, int numberOfSugar, float prive) {
        Command command = new Command();
        StringBuilder stringBuilder = new StringBuilder();
        addDrink(drink, stringBuilder);
        AddOrNotSugarAndCuillere(numberOfSugar, stringBuilder);
        command.setDrinkDemand(stringBuilder.toString());
        return command;
    }

    private static void addDrink(Drink drink, StringBuilder stringBuilder) {
        stringBuilder.append(drink.boisson);
        stringBuilder.append(SEPARATOR);
    }

    private static void AddOrNotSugarAndCuillere(int numberOfSugar, StringBuilder stringBuilder) {
        if (numberOfSugar > ZERO_SUGAR) {
            addSugar(numberOfSugar, stringBuilder);
        } else {
            stringBuilder.append(SEPARATOR);
        }
    }

    private static void addSugar(int numberOfSugar, StringBuilder stringBuilder) {
        stringBuilder.append(numberOfSugar);
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(CUILLERE);
    }
}
