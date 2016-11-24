package fr.pizzeria.ihm.action;

import java.util.Scanner;

public class AddPizza extends Action {

	private Scanner reader;

	public AddPizza(Scanner reader) {
		super();
		this.reader = reader;
		this.setDescription("2. Ajouter une nouvelle pizza");
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
