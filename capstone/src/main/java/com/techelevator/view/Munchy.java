package com.techelevator.view;

public class Munchy extends Product{


    public Munchy(String name, double price, String slot, int inventory) {
        super(name, price, slot, inventory);



    }

    public void getSound() {
        System.out.println("Munchy, Munchy, so Good!");
    }
}
