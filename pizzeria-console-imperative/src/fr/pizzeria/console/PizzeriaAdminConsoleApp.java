package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	public static String[] menu = new String[6];
	public static Scanner reader = new Scanner(System.in);  // Reading from System.in.
	public static String[][] pizzas = {{"0", "PEP", "Pépéroni", "12.50"},
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
	
	public static void printPizzaList() {

		for (String[] p: pizzas)
		{
			System.out.println(p[1] + " -> " + p[2] + " (" + p[3] + " €)");
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

	public static void updatePizza() {

		System.out.println("Veuillez saisir le code");
		String code = reader.next(); // Scans the next token of the input as an int.

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = reader.next(); // Scans the next token of the input as an int.
		
		System.out.println("Veuillez saisir le prix");
		String price = reader.next(); // Scans the next token of the input as an int.
		
		String[] newPizza = {code, name, price};
		System.out.println(newPizza[2]);
	}	

	public static void deletePizza() {
		System.out.println("Suppression d’une pizza");
	}	

	public static void printBye() {
		System.out.println("Aurevoir :(");
	}

	public static void printMenu(String[][] pizzas) {

		menu[0] = "***** Pizzeria Administration *****";
		menu[1] = "1. Lister les pizzas";
		menu[2] = "2. Ajouter une nouvelle pizza";
		menu[3] = "3. Mettre à jour une pizza";
		menu[4] = "4. Supprimer une pizza";
		menu[5] = "99. Sortir";

		boolean flag = false;

		while (true) {
			for (String s: menu)
			{
				System.out.println(s);
			}

			int choice = reader.nextInt(); // Scans the next token of the input as an int.

			switch (choice) {
			case 1:
				printPizzaList();
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
		printMenu(pizzas);
	}
}
