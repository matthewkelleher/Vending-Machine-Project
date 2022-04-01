package com.techelevator.view;

public class Dessert extends Product {

    public Dessert(String name, double price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}


