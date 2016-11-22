package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void printPizzaList() {
		System.out.println("Liste des pizzas");
	}

	public static void createPizza() {
		System.out.println("Ajout d’une nouvelle pizza");
	}

	public static void updatePizza() {
		System.out.println("Mise à jour d’une pizza");
	}	

	public static void deletePizza() {
		System.out.println("Suppression d’une pizza");
	}	

	public static void printBye() {
		System.out.println("Aurevoir :(");
	}

	public static void printMenu() {

		String[] menu = new String[6];

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

			Scanner reader = new Scanner(System.in);  // Reading from System.in.
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
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		printMenu();
	}
}
