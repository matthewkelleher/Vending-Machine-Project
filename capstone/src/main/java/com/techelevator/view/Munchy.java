package com.techelevator.view;

public class Munchy extends Product{


    public Munchy(String name, double price, String slot, int inventory) {
        super(name, price, slot, inventory);



    }

    public String getSound() {
         return "Munchy, Munchy, so Good!";
    }
}
