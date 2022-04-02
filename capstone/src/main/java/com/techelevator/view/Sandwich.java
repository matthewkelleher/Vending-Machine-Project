package com.techelevator.view;

import java.math.BigDecimal;

public class Sandwich extends Product {

    public Sandwich(String name, BigDecimal price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public String getSound() {
        return "Sandwich So Delicious, Yum!";
    }
}
