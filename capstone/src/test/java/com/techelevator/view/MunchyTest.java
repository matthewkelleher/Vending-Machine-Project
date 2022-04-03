package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MunchyTest {

    private Munchy testItem;

    @Before
    public void setup() {

        this.testItem = new Munchy("aquarium gravel", new BigDecimal("843.10"), "C2", 4);
    }

    @Test
    public void test_instantiate_munchy(){

        assertEquals("aquarium gravel", testItem.getName());
        assertEquals(new BigDecimal("843.10"), testItem.getPrice());
        assertEquals("C2", testItem.getSlot());
        assertEquals((Integer) 4, testItem.getInventory());
        assertEquals("Munchy, Munchy, so Good!", testItem.getSound());

    }

}
