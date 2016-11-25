package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.DeletePizzaException;
//import java.util.Scanner;
//import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
//import fr.pizzeria.model.Pizza;

public class DeletePizza extends Action {

	private IhmUtil ihmUtil;
	public DeletePizza(IhmUtil e) {
		super();
		this.setDescription("4. Supprimer une pizza");
		this.ihmUtil = e;
	}

	@Override
	public void doAction() throws DeletePizzaException {
		System.out.println("");
		System.out.println("Veuillez entrer un numéro de pizza à supprimer, s'il vous plait");
		int numPizzaSupprimee=ihmUtil.getScanner().nextInt();
		ihmUtil.getPizzaDao().supprime(numPizzaSupprimee);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
