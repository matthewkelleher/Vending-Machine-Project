package com.techelevator.view;

import java.io.*;
import java.util.*;

public class Menu {


    private HashMap<String, Product> menuList = new HashMap<>();
    File file = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-7\\capstone\\catering1.csv");
    Scanner fileScanner;

    {
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");

                if (Objects.equals(lineArray[2], "Munchy")) {
                    menuList.put(lineArray[0], new Munchy(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Drink")) {
                    menuList.put(lineArray[0], new Drink(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Sandwich")) {
                    menuList.put(lineArray[0], new Sandwich(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Dessert")) {
                    menuList.put(lineArray[0], new Sandwich(lineArray[1], Double.parseDouble(lineArray[3]), lineArray[0], 7));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void displayItems() {
        String returnValue = "";
        for (Map.Entry<String, Product> entry : menuList.entrySet()) {
            String key = entry.getKey();

            Object value = entry.getValue();
            returnValue += value + "\n";
        }
        System.out.println(returnValue);
    }


}




