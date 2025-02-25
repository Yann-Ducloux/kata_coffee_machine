package org.example.exception;

import java.text.DecimalFormat;

public class LackMoneyException extends RuntimeException {
    public LackMoneyException(double money) {
        DecimalFormat df = new DecimalFormat("#.##");
        super("Il manque " + df.format(money) + "€");
    }
}
