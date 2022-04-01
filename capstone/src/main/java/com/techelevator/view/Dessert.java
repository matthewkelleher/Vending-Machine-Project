package com.techelevator.view;

public class Dessert extends Product {

    public Dessert(String name, double price, String slot, int inventory) {
        super(name, price, slot, inventory);

    }

    public void getSound() {
        System.out.println("Sugar, Sugar, so Sweet!");
    }
}


