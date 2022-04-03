package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    private Drink testItem;

    @Before
    public void setup() {

        this.testItem = new Drink("milk", new BigDecimal("3.00"), "B4", 7);
    }

    @Test
    public void test_instantiate_drink(){

        assertEquals("milk", testItem.getName());
        assertEquals(new BigDecimal("3.00"), testItem.getPrice());
        assertEquals("B4", testItem.getSlot());
        assertEquals((Integer) 7, testItem.getInventory());
        assertEquals("Drinky, Drinky, Slurp Slurp!", testItem.getSound());

    }

}
