package fr.pizzeria.ihm.action;

public class ListPizza extends Action {


	public ListPizza() {
		super();
		this.setDescription("1. Lister les pizzas");
	}

	@Override
	public void doAction() {
		System.out.println("JE LISTE LES PIZZAS :D");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
