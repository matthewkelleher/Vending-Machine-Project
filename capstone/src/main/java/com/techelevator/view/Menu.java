package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Menu {


    private HashMap<String, Product> menuList = new HashMap<>();
//    private List<String> reportList = new ArrayList();
    private File file = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-7\\capstone\\catering1.csv");


  {
        try {

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");

                if (Objects.equals(lineArray[2], "Munchy")) {
//                    reportList.add(lineArray[0]);
                    menuList.put(lineArray[0], new Munchy(lineArray[1], new BigDecimal(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Drink")) {
//                    reportList.add(lineArray[0]);
                    menuList.put(lineArray[0], new Drink(lineArray[1], new BigDecimal(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Sandwich")) {
//                    reportList.add(lineArray[0]);
                    menuList.put(lineArray[0], new Sandwich(lineArray[1], new BigDecimal(lineArray[3]), lineArray[0], 7));
                } else if (Objects.equals(lineArray[2], "Dessert")) {
//                    reportList.add(lineArray[0]);
                    menuList.put(lineArray[0], new Dessert(lineArray[1], new BigDecimal(lineArray[3]), lineArray[0], 7));
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Menu input file not found.");
        }


    }
@Override
    public String toString() {
        String returnValue = "";
        for (Map.Entry<String, Product> entry : menuList.entrySet()) {

            Product value = entry.getValue();
            returnValue += value + "\n";
        }
         return returnValue;
    }

    public Product getValueFromKey(String key) {return menuList.get(key);    }

    public Boolean confirmKey(String key) {return menuList.containsKey(key); }
}

//    public void populateSalesReport (Map map) {
//        for(String i : reportList) {
//            map.put(i, 0);
//        }
//
//
//    }








