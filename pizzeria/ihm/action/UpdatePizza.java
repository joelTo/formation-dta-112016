package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.UpdatesPizzaException;
//import java.util.Scanner;
//import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;

public class UpdatePizza extends Action {

	private IhmUtil ihmUtil;

	public UpdatePizza(IhmUtil e) {
		super();
		this.setDescription("3. Mettre à jour une pizza");
		this.ihmUtil = e;
	}

	@Override
	public void doAction() throws UpdatesPizzaException {
		System.out.println("");
		System.out.println("Quelle pizza voulez-vous modifier ? ");
		String numPizzaModiffier=ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification de l'Alias de votre Pizza");
		String saisieAlias=ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification  du nom de votre Pizza");
		String saisieNom = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification  du prix de votre Pizza");
		Double saisiePrix = ihmUtil.getScanner().nextDouble();
		ihmUtil.getPizzaDao().update(numPizzaModiffier,saisieAlias,saisieNom ,saisiePrix);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
