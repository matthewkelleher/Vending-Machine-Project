package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DessertTest {

    private Dessert testItem;

    @Before
    public void setup() {

        this.testItem = new Dessert("yummy", new BigDecimal("1.50"), "A4", 7);
    }

    @Test
    public void test_instantiate_dessert(){

        assertEquals("yummy", testItem.getName());
        assertEquals(new BigDecimal("1.50"), testItem.getPrice());
        assertEquals("A4", testItem.getSlot());
        assertEquals((Integer) 7, testItem.getInventory());
        assertEquals("Sugar, Sugar, so Sweet!", testItem.getSound());
    }

}
