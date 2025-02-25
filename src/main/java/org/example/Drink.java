package org.example;

public enum Drink {
    TEA("T", 0.4),
    HOT_TEA("Th", 0.4),
    CHOCOLATE("H", 0.5),
    HOT_CHOCOLATE("Hh", 0.5),
    COFFEE("C", 0.6),
    HOT_COFFEE("Ch", 0.6),
    ORANGE_JUICE("O", 0.6);

    Drink(String boisson, Double price) {
        this.boisson = boisson;
        this.price = price;
    }

    final String boisson;
    final Double price;

    public String getBoisson() {
        return boisson;
    }

    public Double getPrice() {
        return price;
    }
}
