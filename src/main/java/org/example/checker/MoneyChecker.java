package org.example.checker;

import org.example.Drink;
import org.example.exception.LackMoneyException;

public class MoneyChecker {

    public static void LackMoneyChecker(Drink drink, double price) {
        if (drink.getPrice() > price) {
            double difference = drink.getPrice() - price;
            throw new LackMoneyException(difference);
        }
    }
}
