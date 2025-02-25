package org.example;

public enum Drink {
    TEA("T", 0.4),
    CHOCOLATE("H", 0.5),
    COFFEE("C", 0.6);

    Drink(String boisson, Double price) {
        this.boisson = boisson;
        this.price = price;
    }

    String boisson;
    Double price;

    public String getBoisson() {
        return boisson;
    }

    public Double getPrice() {
        return price;
    }
}
