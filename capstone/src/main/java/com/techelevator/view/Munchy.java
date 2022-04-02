package com.techelevator.view;

import java.math.BigDecimal;

public class Munchy extends Product{


    public Munchy(String name, BigDecimal price, String slot, int inventory) {
        super(name, price, slot, inventory);



    }

    public String getSound() {
         return "Munchy, Munchy, so Good!";
    }
}
