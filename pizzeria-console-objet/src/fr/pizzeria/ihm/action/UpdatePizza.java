package fr.pizzeria.ihm.action;

public class UpdatePizza extends Action {

	public UpdatePizza() {
		super();
		this.setDescription("3. Mettre � jour une pizza");
	}

	@Override
	public void doAction() {
		System.out.println("JE MODIFIE UNE PIZZA :D YOLOOOOO :O");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
