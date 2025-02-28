package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public String getBoissonReport() {
        if(boisson.length() == 1)
            return boisson + " ";
        return boisson;
    }

    public Double getPrice() {
        return price;
    }

    public static List<Drink> getDrinksByOrderAlphabetic() {
        List<Drink> drinks = new ArrayList<>();
        Collections.addAll(drinks, Drink.values());
        drinks.sort(Comparator.comparing(Drink::getBoisson));
        return drinks;
    }

}
