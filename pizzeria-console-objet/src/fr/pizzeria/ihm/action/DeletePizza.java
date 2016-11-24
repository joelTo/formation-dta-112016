package fr.pizzeria.ihm.action;

public class DeletePizza extends Action {

	
	public DeletePizza() {
		super();
		this.setDescription("4. Supprimer une pizza");
	}

	@Override
	public void doAction() {
		System.out.println("JE SUPPRIME UNE PIZZA :D");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
