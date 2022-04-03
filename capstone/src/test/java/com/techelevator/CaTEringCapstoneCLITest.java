package com.techelevator;


import com.techelevator.view.Menu;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;



public class CaTEringCapstoneCLITest {


    @Test
    public void test_make_change() {
        Menu menu = new Menu();
        CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
        int[] expectedArray = {7, 2, 0, 1};
        assertArrayEquals(expectedArray, cli.calculateChange(new BigDecimal("7.55")));



    }
}

