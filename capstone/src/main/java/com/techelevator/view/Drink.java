package com.techelevator.view;

public class Drink extends Product {

    public Drink(String name, double price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public String getSound() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
