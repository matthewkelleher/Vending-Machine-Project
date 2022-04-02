package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product {

    private String name;
    private String slot;
    // doubles to BigDecimal
    private double price;
    private int inventory;

    public Product(String name, double price, String slot, int inventory) {
       this.name = name;
       this.price = price;
       this.slot = slot;
       this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSlot() { return slot; }

    public Integer getInventory() { return inventory; }

    public String stringifyInventory() {
        if(this.inventory != 0) {
            return String.valueOf(inventory);
        } else {
            return "NO LONGER AVAILABLE";
        }
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public abstract String getSound();


    @Override
    public String toString() {
        return this.getSlot () + " " + this.getName() + " " + " $" + this.getPrice() + " " + this.stringifyInventory();
    }

}


