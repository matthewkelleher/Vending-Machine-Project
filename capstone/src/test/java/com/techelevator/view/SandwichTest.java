package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SandwichTest {

    private Sandwich testItem;

    @Before
    public void setup() {

        this.testItem = new Sandwich("knuckle", new BigDecimal("0.10"), "E4", 100);
    }

    @Test
    public void test_instantiate_sandwich(){

        assertEquals("knuckle", testItem.getName());
        assertEquals(new BigDecimal("0.10"), testItem.getPrice());
        assertEquals("E4", testItem.getSlot());
        assertEquals((Integer) 100, testItem.getInventory());
        assertEquals("Sandwich So Delicious, Yum!", testItem.getSound());

    }

}
