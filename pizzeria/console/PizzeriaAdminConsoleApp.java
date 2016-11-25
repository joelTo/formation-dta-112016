package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatesPizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MainMenu;

public class PizzeriaAdminConsoleApp {

	

	
	public static void main(String[] args) {
		//	initPizzas();
		//	printMenu();
	
		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDaoTableau());
		MainMenu Core = new MainMenu(ihmUtil);
		
		Boolean Arret = false;
		
		while(Arret == false) {
			Core.displayMenu();
			try {
				Core.parseAndExec();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SavePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DeletePizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UpdatesPizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}