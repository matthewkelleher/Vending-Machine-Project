package com.techelevator.view;

import java.io.*;
import java.util.*;

public class Menu {


    private List<Product> menuList = new ArrayList<>();
    File file = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-7\\capstone\\catering1.csv");
    Scanner fileScanner;

    {
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");

                if (Objects.equals(lineArray[2], "Munchy")) {
                    menuList.add(new Munchy(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Drink")) {
                    menuList.add(new Drink(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Sandwich")) {
                    menuList.add(new Sandwich(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Dessert")) {
                    menuList.add(new Sandwich(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }



    @Override
    public String toString() {

        String str = "";
        for (Product product : menuList) {
            str += product.getSlot() + "    " + product.getName() + "   " + "$" + product.getPrice() + "    " + product.getInventory() + "\n";

        }
        return str;
    }
}



