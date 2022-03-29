package com.techelevator;

import com.techelevator.view.Menu;

public class CaTEringCapstoneCLI {



	private Menu menu;

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public void run() {
		while (true) {
			//  to do -- build out main menu

		}
	}
}
