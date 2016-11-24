package fr.pizzeria.ihm.action;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class AddPizza extends Action {


	private IhmUtil ihmUtil;

	public AddPizza(IhmUtil ihmUtil) {
		super();
		this.setDescription("2. Ajouter une nouvelle pizza");
		this.ihmUtil = ihmUtil;
	}

	@Override
	public void doAction() {
		System.out.println("JE CREE UNE PIZZA :D");
		
		
		
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
