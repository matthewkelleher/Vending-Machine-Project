package com.techelevator.view;

import java.math.BigDecimal;

public class Dessert extends Product {

    public Dessert(String name, BigDecimal price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}


