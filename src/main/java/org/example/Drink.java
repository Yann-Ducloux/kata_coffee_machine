package org.example;

public enum Drink {
    TEA("T", 0.4F),
    CHOCOLATE("H", 0.5F),
    COFFEE("C", 0.6F);

    Drink(String boisson, float price) {
        this.boisson = boisson;
        this.price = price;
    }

    String boisson;
    float price;
}
