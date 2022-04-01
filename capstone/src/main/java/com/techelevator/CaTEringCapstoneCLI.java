package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;

public class CaTEringCapstoneCLI {

	private Menu menu;
	private Scanner inputScanner;
	private double currentMoneyProvided = 0;
	private double newMoneyProvided;


	public void displayLevel1() {

		System.out.println("(D) Display CaTEring Items\n.(P) Purchase\n(E) Exit");
		String level1MenuInput = inputScanner.nextLine().toLowerCase();
		if(level1MenuInput == "D") {
			menu.displayItems();
		} else if(level1MenuInput == "P") {
			displayLevel1_P();
		} else if(level1MenuInput == "E") {
			System.exit(0);
		}
	}

		public void displayLevel1_P() {

		System.out.println("(M) Feed Money\n(S) Select Item\n(C) Finish Transaction\n Current Money Provided: " + "$" + currentMoneyProvided);


	}

	public void displayLevel1_P_M() {
		System.out.println("Enter cash amount: ");
		newMoneyProvided = inputScanner.nextDouble();
		if (newMoneyProvided == 1 || newMoneyProvided == 5 || newMoneyProvided == 10 || newMoneyProvided == 20) {
			currentMoneyProvided += newMoneyProvided;
			System.out.println("Thank you!");
		} else System.out.println("Invalid currency!");

		displayLevel1_P();


	}

	public void displayLevel1_P_S() {

	}

	public void displayLevel1_P_C() {

	}




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

		boolean keepGoing = true;

		do {
			this.displayLevel1();
			String level1Input = inputScanner.nextLine();
			if (level1Input.equals("D")) {
				displayLevel1_D();
			} else if (level1Input.equals("P")) {
				displayLevel1_P();
			} else if (level1Input.equals("E")) {
				keepGoing = false;
			}
		} while (keepGoing);

//    public void processSubD() {
//       this.menu.displayLevel1_D();
//
//    }
// }
	}

	public void processSubP() {

		boolean keepGoing = true;
		do {
			this.displayLevel1_P();
			String choice = inputScanner.nextLine();
			if (choice.equals("M")) {
				displayLevel1_P_M();
			} else if (choice.equals("S")) {
				displayLevel1_P_S();
			} else if (choice.equals("C")) {
				displayLevel1_P_C();
			}

		} while (keepGoing);

		//  to do -- build out main menu


	}
}
