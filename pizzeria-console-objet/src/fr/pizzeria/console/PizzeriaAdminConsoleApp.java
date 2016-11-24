package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {

	

	/**
	 * Point d'entr�e du programme
	 * On execute la fonction qui va afficher le menu principal
	 * en boucle
	 * @param args
	 */
	public static void main(String[] args) {
		//	initPizzas();
		//	printMenu();
	
		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDaoTableau());

		MainMenu Core = new MainMenu(ihmUtil);

		while (true) {
			Core.displayMenu();
			Core.parseAndExec();
		}
	}
}