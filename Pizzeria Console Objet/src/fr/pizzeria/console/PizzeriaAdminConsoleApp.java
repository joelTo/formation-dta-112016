package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	static Pizza[] listPizza = new Pizza[8];

	public static void main(String[] args) {
		listPizza[0] = new Pizza(0,"PEP","Pépéroni", 12.50);
		listPizza[1] = new Pizza(1,"MAR","Margharita", 14.00);
		listPizza[2] = new Pizza(2,"REI","La reine", 11.50);
		listPizza[3] = new Pizza(2,"FRO","La 4 fromage", 12.00);
		listPizza[4] = new Pizza(4,"CAN","La cannibale", 12.50);
		listPizza[5] = new Pizza(5,"SAV","La savoyarde", 13.00);
		listPizza[6] = new Pizza(6,"ORI","L'oriental", 13.50);
		listPizza[7] = new Pizza(7,"IND","L'indienne", 14.00);
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1.Lister les pizzas");
			System.out.println("2.Ajouter une nouvelle pizza");
			System.out.println("3.Mettre à jour une pizzas");
			System.out.println("4.Supprimer une pizzas");
			System.out.println("99.Sortir");
			int option = 0;
			while (true){
				String temp = sc.next();
				try{
					option = Integer.parseInt(temp);
					if(option==99||(1<=option&option<=4)){
						break;
					}
					System.out.println("Saisie incorrect veuillez entrez une option valide...");
				} catch(NumberFormatException e){
					System.out.println("Saisie incorrect veuillez entrez un nombre...");
				}
			}
			switch(option){
			case 1:
				if(listPizza!=null&listPizza.length>=1){
					System.out.println("***** Liste des pizzas *****");
					showListPizzas(listPizza, false);
				} else {
					System.out.println("Aucune pizza n'est actuellement pr�sente");
				}
				break;
			case 2:
				System.out.println("***** Ajouter une nouvelle pizza *****");
				Pizza[] temp = listPizza;
				listPizza = new Pizza[listPizza.length+1];
				for (int i=0; i<temp.length; i++){
					listPizza[i] = temp[i];
				}
				listPizza[listPizza.length-1] = addPizza(sc, listPizza.length-1);
				break;
			case 3:
				System.out.println("***** Mettre à jour une pizza *****");
				showListPizzas(listPizza, true);
				System.out.println("Veuillez choisir la pizza � modifier.");
				System.out.println("99.Abandonner");
				int option1;
				while (true){
					String temp1 = sc.next();
					try{
						option1 = Integer.parseInt(temp1);
						if(option1==99||(0<=option1&option1<listPizza.length)){
							break;
						}
						System.out.println("Saisie incorrect veuillez entrez une option valide...");
					} catch(NumberFormatException e){
						System.out.println("Saisie incorrect veuillez entrez un nombre...");
					}
				}
				if(option1==99){
					break;
				} else {
					modifyPizza(sc, option1);
				}
				break;
			case 4:
				System.out.println("***** Supprimer une pizza *****");
				showListPizzas(listPizza, true);
				System.out.println("Veuillez choisir la pizza à Supprimer.");
				System.out.println("99.Abandonner");
				int option2;
				while (true){
					String temp1 = sc.next();
					try{
						option2 = Integer.parseInt(temp1);
						if(option2==99||(0<=option2&option2<listPizza.length)){
							break;
						}
						System.out.println("Saisie incorrect veuillez entrez une option valide...");
					} catch(NumberFormatException e){
						System.out.println("Saisie incorrect veuillez entrez un nombre...");
					}
				}
				if(option2==99){
					break;
				} else {
					Pizza[] tempPizzaList = listPizza;
					listPizza = new Pizza[listPizza.length-1];
					for(int i=0,iL=0; iL<tempPizzaList.length; i++,iL++){
						if(i==option2){
							iL++;
						}
						if(i<listPizza.length){
							listPizza[i] = tempPizzaList[iL];
						}
					}
				}
				Pizza.nbPizza--;
				break;
			case 99:
				System.out.println("***** Arret en cours veuillez patientez *****");
				for(int i=0; i<5; i++){
					System.out.print(".");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				System.out.println("***** Arret effectué, merci d'avoir utilisé notre système *****");
				System.exit(-1);
				break;

			}
		}
	}

	private static void modifyPizza(Scanner sc, int index) {
		listPizza[index].id = index;
		System.out.println("Veuillez saisir le code");
		listPizza[index].code = sc.next();
		System.out.println("Veuillez saisir le nom");
		sc.nextLine();
		listPizza[index].name = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		while(true){

			String temp = sc.next();

			try{
				listPizza[index].price = Float.parseFloat(temp);
				break;
			} catch(NumberFormatException e){
				System.out.println("Saisie incorrect veuillez entrez un nombre...");
			}

		}
	}

	private static void showListPizzas(Pizza[] listPizza, boolean index) {
		for(int i=0; i<listPizza.length; i++){
			if(index){
				System.out.print(listPizza[i].id+". ");
			}
			System.out.println(listPizza[i].code+" -> "+listPizza[i].name+" ("+ listPizza[i].price +")");
		}
		System.out.println("------- "+Pizza.nbPizza+" pizzas créées depuis l’initialisation du programme");
	}

	private static Pizza addPizza(Scanner sc, int index) {
		Pizza tempPizza = new Pizza();
		tempPizza.id = index;
		System.out.println("Veuillez saisir le code");
		tempPizza.code = sc.next();
		System.out.println("Veuillez saisir le nom");
		sc.nextLine();
		tempPizza.name = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		while(true){

			String temp = sc.next();

			try{
				tempPizza.price = Float.parseFloat(temp);
				break;
			} catch(NumberFormatException e){
				System.out.println("Saisie incorrect veuillez entrez un nombre...");
			}

		}
		return tempPizza;
	}

}
