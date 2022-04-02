package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Product {

    public Drink(String name, BigDecimal price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public String getSound() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
