package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Product;
import java.io.BufferedWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CaTEringCapstoneCLI {

	private Menu menu;
	private Scanner inputScanner;
	// doubles to BigDecimal
	private BigDecimal currentMoneyProvided = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
	private BigDecimal newMoneyProvided = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
	private double newMoneyDouble;
	private BigDecimal change = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
	private Product activeItem;
	private boolean keepRunning = true;


	File auditFile = new File("audit.txt");


	public CaTEringCapstoneCLI(Menu menu) {
		this.inputScanner = new Scanner(System.in);
		this.menu = new Menu();
	}


	public static void main(String[] args) {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public void run() {
		keepRunning = true;
		while (keepRunning) {

			System.out.println("(D) Display CaTEring Items\n(P) Purchase\n(E) Exit");
			String level1MenuInput = inputScanner.nextLine();
			if (level1MenuInput.equalsIgnoreCase("d")) {
				menu.displayItems();
			} else if (level1MenuInput.equalsIgnoreCase("p")) {
				keepRunning = false;
				displayLevel1_P();


			} else if (level1MenuInput.equalsIgnoreCase("e")) {
				System.out.println("Thank you for your patronage! Come again soon!");
				System.exit(0);
			} else {
				System.out.println("Invalid input!");
			}
		}

	}

	public void displayLevel1_P() {
		boolean keepRunningP = true;
		while (keepRunningP) {

			System.out.println("(M) Feed Money\n(S) Select Item\n(F) Finish Transaction\nCurrent Money Provided: " + "$" + currentMoneyProvided);
			String choice = inputScanner.nextLine();
			if (choice.equalsIgnoreCase("m")) {
				// insert money
				// back to purchase menu after this
				displayLevel1_P_M();
			} else if (choice.equalsIgnoreCase("s")) {
				displayLevel1_P_S();
			} else if (choice.equalsIgnoreCase("f")) {
				displayLevel1_P_F();
				keepRunningP = false;
			} else {
				System.out.println("Invalid input!");
			}
		}
	}

	public void displayLevel1_P_M() {
		System.out.println("Enter value of bill (1|5|10|20): ");

		newMoneyDouble = inputScanner.nextDouble();
		inputScanner.nextLine();
		if (newMoneyDouble == 1 || newMoneyDouble == 5 || newMoneyDouble == 10 || newMoneyDouble == 20) {
			newMoneyProvided = newMoneyProvided.valueOf(newMoneyDouble).setScale(2, RoundingMode.HALF_UP);
			currentMoneyProvided = currentMoneyProvided.add(newMoneyProvided);
			auditMoney("feed");
			System.out.println("Thank you!");
			// back to purchase menu

		} else {
			System.out.println("Invalid currency! Please feed a $1, $5, $10 or $20 bill.");
			// back to purchase menu

		}
	}

	public void displayLevel1_P_S() {
		menu.displayItems();
		System.out.println("Enter the slot: ");
		String slotChoice = inputScanner.nextLine();
		if (menu.confirmKey(slotChoice)) {

			activeItem = menu.getValueFromKey(slotChoice);
			if (activeItem.getInventory() == 0) {
				System.out.println("This item is no longer available.");
				// return to purchase menu
				displayLevel1_P();
			}

			if (currentMoneyProvided.compareTo(activeItem.getPrice()) > 0) {
				auditMoney("purchase");
				currentMoneyProvided = currentMoneyProvided.subtract(activeItem.getPrice());
				activeItem.setInventory(activeItem.getInventory() - 1);
				System.out.println(activeItem.getName() + " $" + activeItem.getPrice() + " Money Remaining: $" + currentMoneyProvided);
				System.out.println(activeItem.getSound());
				//back to purchase menu

			} else {
				System.out.println("Insufficient funds! Please feed more money.");
				//back to purchase menu

			}

		} else {
			System.out.println("Invalid slot!");
			//back to purchase menu
			displayLevel1_P();
		}
	}

	public void displayLevel1_P_F() {
		System.out.println("Enjoy!");
		int[] changeArray = calculateChange(currentMoneyProvided);
		auditMoney("change");
		System.out.println("Your change is $" + currentMoneyProvided + " in total.\n" + "The machine will dispense " + changeArray[0] + " dollar(s), " + changeArray[1] + " quarter(s), " + changeArray[2] + " dime(s), " + changeArray[3] + " nickel(s).\n");
		currentMoneyProvided = currentMoneyProvided.subtract(currentMoneyProvided);
		// return to main menu
		keepRunning = true;
	}

	private void auditMoney(String type) {
		// fix column width in line writes

		FileWriter fw = null;
		try {
			fw = new FileWriter(auditFile, true);
		} catch (IOException e) {
			System.out.println("Error opening audit file.");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		Date date = new Date();
		BufferedWriter bw = new BufferedWriter(fw);

		if (type == "feed") {

			try {
				bw.write(formatter.format(date) + " " + "MONEY FED: \t\t" + "$" + newMoneyProvided + " " + "$" + currentMoneyProvided);
				bw.newLine();
				bw.close();
			} catch (IOException f) {
				System.out.println("Error writing feed to file.");
			}
		} else if (type == "purchase") {

			try {
				bw.write(formatter.format(date) + " " + activeItem.getName() + " " + activeItem.getSlot() + "\t" + "$" + currentMoneyProvided + " " + "$" + currentMoneyProvided.subtract(activeItem.getPrice()));
				bw.newLine();
				bw.close();
			} catch (IOException f) {
				System.out.println("Error writing purchase to file.");
			}
		} else if (type == "change") {
			try {
				bw.write(formatter.format(date) + " " + "CHANGE GIVEN: \t\t" + "$" + currentMoneyProvided + " " + "$" + currentMoneyProvided.subtract(currentMoneyProvided));
				bw.newLine();
				bw.close();
			} catch (IOException f) {
				System.out.println("Error writing change to file.");
			}


		}

	}

	public int[] calculateChange (BigDecimal moneyLeft) {

		BigDecimal bigChange = moneyLeft.multiply(new BigDecimal("100"));
		int changeInt = bigChange.intValue();
		int dollars = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int[] changeArray = {0,0,0,0};

		dollars = changeInt / 100;
		changeInt -= dollars * 100;
		changeArray[0] = dollars;


		if (changeInt > 0) {
			quarters = changeInt / 25;
			changeInt -= quarters * 25;
			changeArray[1] = quarters;

		}
		if (changeInt > 0) {
			dimes = changeInt / 10;
			changeInt -= dimes * 10;
			changeArray[2] = dimes;

		}
		if (changeInt > 0) {
			nickels = changeInt / 5;
			changeInt -= nickels * 5;
			changeArray[3] = nickels;

		}

		return changeArray;
	}
}

