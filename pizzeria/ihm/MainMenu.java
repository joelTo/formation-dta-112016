package fr.pizzeria.ihm;
import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatesPizzaException;
import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.UpdatePizza;
import fr.pizzeria.model.Pizza;

public class MainMenu {
	private Map<Integer,Action> map = new HashMap<Integer,Action>();
	private IhmUtil ihmUtil;

	public MainMenu(IhmUtil ihmUtil){
		 
		 map.put(0,  new ListPizza(ihmUtil));
		 map.put(1,  new AddPizza(ihmUtil));
		 map.put(2,  new UpdatePizza(ihmUtil));
		 map.put(3,  new DeletePizza(ihmUtil));
		 map.put(4,  new ExitMenu());
		 this.ihmUtil = ihmUtil; 
	}
	
	public void displayMenu() {
		for (int i = 0; i < this.map.size(); ++i) {
			this.map.get(i).describeAction();
		}
	}
	
	public void parseAndExec() throws NumberFormatException, SavePizzaException, DeletePizzaException, UpdatesPizzaException {
		String input = ihmUtil.getScanner().next();

		if (Integer.parseInt(input) < 4)
			this.map.get(Integer.parseInt(input) - 1).doAction();
		else if (Integer.parseInt(input) == 99) {
			this.map.get(4).doAction();
		}
	}
}
