package fr.pizzeria.model;

public class Pizza {
	
	public int id;
	public static int nbPizza;
	public String code, name;
	public double price;
	
	public Pizza(int id, String code, String name, double price) {
		nbPizza++;
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public Pizza() {
		nbPizza++;
	}

}
