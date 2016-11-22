package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		String[][] listPizza = new String[8][];
		listPizza[0] = new String[]{"0","PEP","Pépéroni", "12.50"};
		listPizza[1] = new String[]{"1","MAR","Margharita", "14.00"};
		listPizza[2] = new String[]{"2","REI","La reine", "11.50"};
		listPizza[3] = new String[]{"2","FRO","La 4 fromage", "12.00"};
		listPizza[4] = new String[]{"4","CAN","La cannibale", "12.50"};
		listPizza[5] = new String[]{"5","SAV","La savoyarde", "13.00"};
		listPizza[6] = new String[]{"6","ORI","L'oriental", "13.50"};
		listPizza[7] = new String[]{"7","IND","L'indienne", "14.00"};
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
					System.out.println("Aucune pizza n'est actuellement présente");
				}
				break;
			case 2:
				System.out.println("***** Ajouter une nouvelle pizza *****");
				String[][] temp = listPizza;
				listPizza = new String[listPizza.length+1][3];
				for (int i=0; i<temp.length; i++){
					listPizza[i] = temp[i];
				}
				listPizza[listPizza.length-1] = setPizza(sc);
				break;
			case 3:
				System.out.println("***** Mettre à jour une pizza *****");
				showListPizzas(listPizza, true);
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("99.Abandonner");
				int option1;
				while (true){
					String temp1 = sc.next();
					try{
						option1 = Integer.parseInt(temp1);
						if(option1!=99||(0<=option1&option1<listPizza.length)){
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
					listPizza[option1]=setPizza(sc);
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
					String[][] tempPizzaList = listPizza;
					listPizza = new String[listPizza.length-1][3];
					for(int i=0,iL=0; iL<tempPizzaList.length; i++,iL++){
						if(i==option2){
							iL++;
						}
						if(i<listPizza.length){
							listPizza[i] = tempPizzaList[iL];
						}
					}
				}
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

	private static void showListPizzas(String[][] listPizza, boolean index) {
		for(int i=0; i<listPizza.length; i++){
			if(index){
				System.out.print(listPizza[i][0]+". ");
			}
			System.out.println(listPizza[i][1]+" -> "+listPizza[i][2]+" ("+ listPizza[i][3] +")");
		}
	}

	private static String[] setPizza(Scanner sc) {
		String[] tempPizza = new String[3];
		System.out.println("Veuillez saisir le code");
		tempPizza[1] = sc.next();
		System.out.println("Veuillez saisir le nom");
		sc.nextLine();
		tempPizza[2] = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		tempPizza[3] = sc.next();
		return tempPizza;		
	}

}
