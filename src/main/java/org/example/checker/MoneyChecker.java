package org.example.checker;

import org.example.Drink;
import org.example.exception.LackMoneyException;
import org.example.exception.NegativeMoneyException;

public class MoneyChecker {

    public static void LackMoneyChecker(Drink drink, double price) {
        if (drink.getPrice() > price) {
            double difference = drink.getPrice() - price;
            throw new LackMoneyException(difference);
        }
    }

    public static void NegativeMoneyChecker(double price) {
        if (price < 0) {
            throw new NegativeMoneyException(price);
        }
    }
}
