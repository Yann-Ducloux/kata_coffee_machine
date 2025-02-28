package org.example.exception;

import java.text.DecimalFormat;

public class LackMoneyException extends RuntimeException {

    public static final String MONEY = "€";
    public static final String IL_MANQUE = "Il manque ";
    public static final String PATTERN = "#.##";

    public LackMoneyException(double money) {
        DecimalFormat df = new DecimalFormat(PATTERN);
        super(IL_MANQUE + df.format(money) + MONEY);
    }
}
