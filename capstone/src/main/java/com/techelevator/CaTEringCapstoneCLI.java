package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Product;

import java.io.BufferedWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CaTEringCapstoneCLI {

	private Menu menu;
	private Scanner inputScanner;
	private double currentMoneyProvided = 0;
	private double newMoneyProvided;
	private double change;
	private Product activeItem;
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

		// put the Main Menu and Purchase Menu in separate do-while loops?

		boolean keepGoing = true;

		do {
			System.out.println("(D) Display CaTEring Items\n(P) Purchase\n(E) Exit");
			String level1MenuInput = inputScanner.nextLine();
			if (level1MenuInput.equalsIgnoreCase("d")) {
				menu.displayItems();
			} else if (level1MenuInput.equalsIgnoreCase("p")) {
				System.out.println("(M) Feed Money\n(S) Select Item\n(F) Finish Transaction\n Current Money Provided: " + "$" + currentMoneyProvided);
				String choice = inputScanner.nextLine();
				if (choice.equalsIgnoreCase("m")) {
					System.out.println("Enter cash amount: ");
					newMoneyProvided = inputScanner.nextDouble();
					if (newMoneyProvided == 1 || newMoneyProvided == 5 || newMoneyProvided == 10 || newMoneyProvided == 20) {
						currentMoneyProvided += newMoneyProvided;
						auditMoney("feed");
						System.out.println("Thank you!");
						// back to purchase menu
					} else System.out.println("Invalid currency!");
					// back to purchase menu
				} else if (choice.equalsIgnoreCase("s")) {
					menu.displayItems();
					System.out.println("Enter the slot: ");
					String slotChoice = inputScanner.nextLine();
					if (menu.confirmKey(slotChoice)) {
						activeItem = menu.getValueFromKey(slotChoice);

						if (currentMoneyProvided >= activeItem.getPrice()) {

							currentMoneyProvided -= activeItem.getPrice();
							activeItem.setInventory(activeItem.getInventory() - 1);
							auditMoney("purchase");

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
					}


				} else if (choice.equalsIgnoreCase("f")) {
					// return change and update audit with return change event

					// return to main menu
					change = currentMoneyProvided;
					currentMoneyProvided -= currentMoneyProvided;
					auditMoney("change");
				}
			} else if (level1MenuInput.equalsIgnoreCase("e")) {
				keepGoing = false;
			}


		} while (keepGoing);

//    public void processSubD() {
//       this.menu.displayLevel1_D();
//
//    }
// }
	}

	private void auditMoney(String type) {
		// fix column width in line writes

		FileWriter fw = null;
		try {
			fw = new FileWriter(auditFile, true);
		} catch (IOException e) {
			e.printStackTrace();
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
				f.printStackTrace();
			}
		} else if (type == "purchase") {

			try {
				bw.write(formatter.format(date) + " " + activeItem.getName() + " " + activeItem.getSlot() + "\t" + "$" + newMoneyProvided + " " + "$" + currentMoneyProvided);
				bw.newLine();
				bw.close();
			} catch (IOException f) {
				f.printStackTrace();
			}
		} else if (type == "change") {
			try {
				bw.write(formatter.format(date) + " " + "CHANGE GIVEN: \t\t" + "$" + change + " " + "$" + currentMoneyProvided);
				bw.newLine();
				bw.close();
			} catch (IOException f) {
				f.printStackTrace();
			}


		}

	}


	//  to do -- build out main menu

	public void displayLevel1() {


	}

	public void displayLevel1_P() {

		System.out.println("(M) Feed Money\n(S) Select Item\n(C) Finish Transaction\n Current Money Provided: " + "$" + currentMoneyProvided);


	}

	public void displayLevel1_P_M() {


	}

	public void displayLevel1_P_S() {

	}

	public void displayLevel1_P_F() {

	}
}
//public void processSubP() {
//
//		boolean keepGoing = true;
//		do {
//		this.displayLevel1_P();
//		String choice = inputScanner.nextLine();
//		if (choice.equals("M")) {
//		displayLevel1_P_M();
//		} else if (choice.equals("S")) {
//		displayLevel1_P_S();
//		} else if (choice.equals("C")) {
//		displayLevel1_P_F();
//		}
//
//
//	}
//}
