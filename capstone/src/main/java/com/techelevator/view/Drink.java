package com.techelevator.view;

public class Drink extends Product {

    public Drink(String name, double price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public void getSound() {
        System.out.println("Drinky, Drinky, Slurp Slurp!");
    }
}
