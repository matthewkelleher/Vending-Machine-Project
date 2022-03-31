package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product {

    private String name;
    private String slot;
    private double price;
    private int inventory;


    public Product(String slot, String name, double price) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.inventory = 7;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSlot() { return slot; }

    public Integer getInventory() { return inventory; }



}


