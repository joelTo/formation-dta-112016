package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatesPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDao{

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>() {{
	    add(new Pizza(0, "MAR", "Margherita", 14));
	    add(new Pizza(1, "ORI", "Oriental", 16));
	    
	}};

	public int tailleTableauPizza(){
		return pizzas.size();
	}

	@Override
	public  ArrayList<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(String code,String nom,Double prix) throws SavePizzaException {
		if(isValid(code,nom,prix))
		{
			throw new SavePizzaException();
		}
		Pizza pizzaAjoutee= new Pizza(pizzas.size(),code,nom,prix);
		pizzas.add(pizzaAjoutee);
	}

	private boolean isValid(String code, String nom, Double prix) {
		return code.isEmpty() && nom.isEmpty() && prix!=0;
	}

	public void supprime(int numPizzaSupprimee) throws DeletePizzaException{
		if(numIsValide(numPizzaSupprimee))
		{
			throw new DeletePizzaException();
		}
		pizzas.remove(numPizzaSupprimee);
	}


	private boolean numIsValide(int numPizzaSupprimee) {
		return numPizzaSupprimee<pizzas.size();
	}

	public void update(String numPizza,String code,String nom,Double prix) throws UpdatesPizzaException{
		if(isExisting(numPizza,code,nom,prix))
		{
			throw new UpdatesPizzaException();
		}
		Pizza pizzaModifiee= new Pizza(Integer.parseInt(numPizza),code,nom,prix);
		pizzas.set(Integer.parseInt(numPizza),pizzaModifiee);

	}

	private boolean isExisting(String numPizza, String code, String nom, Double prix) {
		return numIsValide(Integer.parseInt(numPizza)) && code.isEmpty() && nom.isEmpty() && prix!=0;
	}

}