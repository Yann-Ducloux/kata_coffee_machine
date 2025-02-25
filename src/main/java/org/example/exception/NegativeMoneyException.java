package org.example.exception;

import java.text.DecimalFormat;

public class NegativeMoneyException extends RuntimeException {
    public NegativeMoneyException(double money) {
      DecimalFormat df = new DecimalFormat("#.##");
      super("La somme est " + df.format(money) + "€ négative");
    }
}
