package fr.pizzeria.ihm.action;

import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatesPizzaException;

public abstract class Action {

	private String description;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void doAction() throws SavePizzaException, DeletePizzaException, UpdatesPizzaException;
	public abstract void describeAction();
}
