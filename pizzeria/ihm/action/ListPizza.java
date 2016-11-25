package fr.pizzeria.ihm.action;

//import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class ListPizza extends Action {


	private IhmUtil ihmUtil;

	public ListPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("1. Lister les pizzas");
	}

	@Override
	public void doAction() {
		System.out.println("JE LISTE LES PIZZAS :D");
		for(Pizza p : this.ihmUtil.getPizzaDao().findAll()) {
			System.out.println(p);
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
