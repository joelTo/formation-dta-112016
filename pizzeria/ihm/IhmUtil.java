package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public class IhmUtil {
	
	private Scanner scanner;
	private PizzaDao pizzaDao;

	public IhmUtil(Scanner scanner, PizzaDao pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}
	
	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

}
