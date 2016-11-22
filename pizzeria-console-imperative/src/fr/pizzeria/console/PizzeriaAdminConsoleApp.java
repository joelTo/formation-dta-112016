package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static String[] menu = {
			"***** Pizzeria Administration *****",
			"1. Lister les pizzas",
			"2. Ajouter une nouvelle pizza",
			"3. Mettre à jour une pizza",
			"4. Supprimer une pizza",
			"99. Sortir",
	};
	public static Scanner reader = new Scanner(System.in);  // Reading from System.in.
	public static String[][] pizzas = {
			{"0", "PEP", "Pépéroni", "12.50"},
			{"1", "MAR", "Margherita", "14.00"},
			{"2", "REI", "La Reine", "11.50"},
			{"3", "FRO", "La 4 fromages", "12.00"},
			{"4", "CAN", "La cannibale", "12.50"},
			{"5", "SAV", "La savoyarde", "13.00"},
			{"6", "ORI", "L’orientale", "13.50"},
			{"7", "IND", "L’indienne", "14.00"},
	};

	public static void pushPizzaToArray(String[] newPizza) {

		String[][] newMenu = new String[pizzas.length + 1][4];

		for (int i = 0; i < pizzas.length; ++i) {
			for (int j = 0; j < 4; ++j) {
				newMenu[i][j] = pizzas[i][j];
			}
		}

		newMenu[pizzas.length][0] = Integer.toString(pizzas.length);
		newMenu[pizzas.length][1] = newPizza[0];
		newMenu[pizzas.length][2] = newPizza[1];
		newMenu[pizzas.length][3] = newPizza[2];

		pizzas = newMenu;
	}

	public static void printPizzaList(boolean initial) {

		if (initial) {
			for (String[] p: pizzas)
			{
				System.out.println(p[1] + " -> " + p[2] + " (" + p[3] + " €)");
			}	
		}
		else {
			for (String[] p: pizzas)
			{
				System.out.println(p[1] + " - " + p[2] + " (" + p[3] + " €)");
			}
			System.out.println("Veuillez choisir la pizza à modifier.");
			System.out.println("(99 pour abandonner).");
		}
	}

	public static void createPizza() {

		System.out.println("Veuillez saisir le code");
		String code = reader.next(); // Scans the next token of the input as an int.

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = reader.next(); // Scans the next token of the input as an int.

		System.out.println("Veuillez saisir le prix");
		String price = reader.next(); // Scans the next token of the input as an int.

		String[] newPizza = {code, name, price};
		pushPizzaToArray(newPizza);
	}

	public static int getIdFromCode(String code) {

		for(int i = 0; i < pizzas.length; i++) {
			if (pizzas[i][1].equals(code))
				return i;
		}

		return -1;	
	}

	public static void updatePizza() {

		while (true) {
			printPizzaList(false);

			String code = reader.next(); // Scans the next input
			int pizzaId = getIdFromCode(code);

			if (pizzaId != -1) {
				System.out.println("Veuillez saisir le code");
				String newCode = reader.next(); // Scans the next input
				pizzas[pizzaId][1] = newCode;

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next(); // Scans the next input
				pizzas[pizzaId][2] = name;

				System.out.println("Veuillez saisir le prix");
				String price = reader.next(); // Scans the next input
				pizzas[pizzaId][3] = price;
				
				break;
			}
			else if (code.equals("99")) {
				break;
			}
		}	
	}

	public static void deletePizza() {
		System.out.println("Suppression d’une pizza");
	}	

	public static void printBye() {
		System.out.println("Aurevoir :(");
	}

	public static void printMenu() {

		boolean flag = false;

		while (true) {
			for (String s: menu)
			{
				System.out.println(s);
			}

			int choice = reader.nextInt(); // Scans the next token of the input as an int.

			switch (choice) {
			case 1:
				printPizzaList(false); // display initial menu with false
				break;
			case 2:
				createPizza();
				break;
			case 3:
				updatePizza();
				break;
			case 4:
				deletePizza();
				break;
			case 99:
				printBye();
				flag = true;
				break;
			}
			if (flag) {
				reader.close();
				break;
			}
		}
	}

	public static void main(String[] args) {

		printMenu();
	}
}
