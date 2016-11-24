package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDao{
	
	private Pizza[] pizzas = {
			new Pizza(1, "MAR", "Margherita", 14),
			new Pizza(2, "ORI", "Oriental", 16),
	};

	@Override
	public Pizza[] findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza p) {
		
	}

}
