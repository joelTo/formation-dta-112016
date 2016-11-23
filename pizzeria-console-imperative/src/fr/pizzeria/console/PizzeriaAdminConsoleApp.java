package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	String nom;

	/*
	 *	Ci-dessous les variables sont d�clar�es en "Global"
	 *	Cela permet d'y acc�der � partir de n'importe quelle fonction
	 */
	public static String[] menu = {							// Phrases du menu principal
			"***** Pizzeria Administration *****",
			"1. Lister les pizzas",
			"2. Ajouter une nouvelle pizza",
			"3. Mettre � jour une pizza",
			"4. Supprimer une pizza",
			"99. Sortir",
	};
	public static Scanner reader = new Scanner(System.in);  // D�claration du "Reader" pour les saisies utilisateur
	public static String[][] pizzas = {						// Tableau r�pertoriant les pizzas
			{"0", "PEP", "P�p�roni", "12.50"},
			{"1", "MAR", "Margherita", "14.00"},
			{"2", "REI", "La Reine", "11.50"},
			{"3", "FRO", "La 4 fromages", "12.00"},
			{"4", "CAN", "La cannibale", "12.50"},
			{"5", "SAV", "La savoyarde", "13.00"},
			{"6", "ORI", "L�orientale", "13.50"},
			{"7", "IND", "L�indienne", "14.00"},
	};

	/**
	 * Recopie int�gralement le tableau de pizzas
	 * En y ajoutant la pizza pass�e en param�tre
	 * La copie du tableau est alors affect�e au tableau initial
	 * Cela permet la cr�ation
	 * @param newPizza
	 */
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

	/**
	 * Recopie int�gralement le tableau de pizzas
	 * En laissant de c�t� la pizza dont le code est pass� en param�tre
	 * La copie du tableau est alors affect�e au tableau initial
	 * Cela permet la suppression
	 * @param code
	 */
	public static void removePizzaFromArray(String code) {

		String[][] newMenu = new String[pizzas.length - 1][4];

		int index = 0;
		for (int i = 0; i < pizzas.length; i++) {

			if (!code.equals(pizzas[i][1])) {
				for (int j = 0; j < 4; ++j) {
					newMenu[index][j] = pizzas[i][j];
				}
				index++;
			}
		}

		pizzas = newMenu;
	}

	/**
	 * Une fonction utile qui va permettre d'afficher le tableau de pizzas
	 * Format� en fonction des param�tres
	 * @param initial
	 * @param action
	 */
	public static void printPizzaList(boolean initial, String action) {

		String separateur = initial ? " -> ": " - ";
		
		for (String[] p: pizzas) {
			System.out.println(p[1] + separateur + p[2] + " (" + p[3] + " �)");
		}
		
		if (!initial) {
			System.out.println("Veuillez choisir la pizza � " + action + ".");
			System.out.println("(99 pour abandonner).");	
		}
	}

	/**
	 * La fonction qui va lancer la cr�ation d'une pizza
	 */
	public static void createPizza() {

		System.out.println("Veuillez saisir le code");
		String code = reader.next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = reader.next();

		System.out.println("Veuillez saisir le prix");
		String price = reader.next();

		String[] newPizza = {code, name, price};
		pushPizzaToArray(newPizza);
	}

	/**
	 * Une fonction utile qui r�cup�re l'ID d'une pizza dans le tableau
	 * en fonction de son code
	 * @param code
	 * @return
	 */
	public static int getIdFromCode(String code) {

		for(int i = 0; i < pizzas.length; i++) {
			if (pizzas[i][1].equals(code))
				return i;
		}

		return -1;	
	}

	/**
	 * La fonction qui affiche le menu de modification des pizzas en boucle
	 * Traitement des saisies utilisateur
	 */
	public static void updatePizza() {

		while (true) {
			printPizzaList(false, "modifier");

			String code = reader.next();
			Integer pizzaId = getIdFromCode(code);

			if (pizzaId != -1) {
				System.out.println("Veuillez saisir le code");
				String newCode = reader.next();
				pizzas[pizzaId][1] = newCode;

				System.out.println("Veuillez saisir le nom (sans espace)");
				String name = reader.next();
				pizzas[pizzaId][2] = name;

				System.out.println("Veuillez saisir le prix");
				String price = reader.next();
				pizzas[pizzaId][3] = price;

				break;
			}
			else if (code.equals("99")) {
				break;
			}
		}	
	}

	/**
	 * La fonction qui affiche le menu de suppression des pizzas en boucle
	 * Traitement des saisies utilisateur
	 */
	public static void deletePizza() {

		while (true) {
			printPizzaList(false, "supprimer");

			String code = reader.next();

			if (code.equals("99")) {
				break;
			}
			else if (getIdFromCode(code) != -1) {
				removePizzaFromArray(code);
				break;
			}
		}
	}

	/**
	 * Affichage du message de fin de programme
	 */
	public static void printBye() {
		System.out.println("Aurevoir :(");
	}

	/**
	 * La fonction qui affiche le menu principal en boucle
	 * Traitement des saisies utilisateur
	 */
	public static void printMenu() {

		boolean flag = false;
		while (!flag) {
			for (String s: menu) {
				System.out.println(s);
			}

			int choice = reader.nextInt();

			switch (choice) {
			case 1:
				printPizzaList(true, null);
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
		}
		reader.close();
	}

	/**
	 * Point d'entr�e du programme
	 * On execute la fonction qui va afficher le menu principal
	 * en boucle
	 * @param args
	 */
	public static void main(String[] args) {

		printMenu();
	}
}
