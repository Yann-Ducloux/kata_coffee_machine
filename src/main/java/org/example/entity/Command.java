package org.example.entity;

public class Command {
    String drinkDemand;
    double rendered;

    public String getDrinkDemand() {
        return drinkDemand;
    }

    public Command(String drinkDemand, double rendered) {
        this.drinkDemand = drinkDemand;
        this.rendered = rendered;
    }

    public void setDrinkDemand(String drinkDemand) {
        this.drinkDemand = drinkDemand;
    }

    public double getRendered() {
        return rendered;
    }
    public void setRendered(double rendered) {
        this.rendered = rendered;
    }
}
