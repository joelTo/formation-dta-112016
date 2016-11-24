package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.UpdatePizza;

public class MainMenu {

	Action[] menu = new Action[5];
	Scanner reader = new Scanner(System.in);

	public MainMenu(Scanner reader2, PizzaDao pizzaDao) {
		this.reader = reader2;
		
	}

	public MainMenu(IhmUtil ihmUtil) {
		this.menu[0] = new ListPizza(ihmUtil);
		this.menu[1] = new AddPizza(ihmUtil);
		this.menu[2] = new UpdatePizza();
		this.menu[3] = new DeletePizza();
		this.menu[4] = new ExitMenu();
		}

	public void displayMenu() {
		for (int i = 0; i < this.menu.length; ++i) {
			this.menu[i].describeAction();
		}
	}
	
	public void parseAndExec() {
		String input = reader.next();

		if (Integer.parseInt(input) < 4)
			this.menu[Integer.parseInt(input) - 1].doAction();
		else if (Integer.parseInt(input) == 99) {
			this.menu[4].doAction();
		}
	}
}
