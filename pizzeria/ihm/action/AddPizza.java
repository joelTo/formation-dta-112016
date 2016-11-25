package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.SavePizzaException;
//import java.util.Scanner;
//import fr.pizzeria.dao.PizzaDao;
//import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.ihm.IhmUtil;
//import fr.pizzeria.model.Pizza;

public class AddPizza extends Action {


	private IhmUtil ihmUtil;

	public AddPizza(IhmUtil ihmUtil) {
		super();
		this.setDescription("2. Ajouter une nouvelle pizza");
		this.ihmUtil = ihmUtil;
	}

	
	
	@Override
	public void doAction() throws SavePizzaException {
		
		System.out.println("");
		System.out.println("Veuillez entrer l'alias de la nouvelle pizza s'il vous plait");
		String code=ihmUtil.getScanner().next();
		System.out.println("Veuillez entrer le nom de la nouvelle pizza s'il vous plait");
		String nom=ihmUtil.getScanner().next();
		System.out.println("Veuillez entrer le prix de la nouvelle pizza s'il vous plait");
		Double prix=ihmUtil.getScanner().nextDouble();
		ihmUtil.getPizzaDao().save(code,nom, prix);
		
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
