package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;


public class PizzeriaAdminConsoleApp {


	public static void main(String[] args) {

		Pizza Pizzas[] = {
				new Pizza(0,"PEP","Pépéroni",12.50),
				new Pizza(1,"MAR","Margherita",14.00),
				new Pizza(2,"REI","La Reine",11.50),
				new Pizza(3,"FRO","La 4 fromages",12.00),
				new Pizza(4,"CAN","La cannibale",12.50),
				new Pizza(5,"SAV","La savoyarde",13.00),
				new Pizza(6,"ORI","L’orientale",13.50),
				new Pizza(7,"IND","L’indienne",14.00)};

		Scanner sc = new Scanner(System.in);

		affichageOption();
		String choice = sc.next();

		while(choice.equals("99")!=true){
			switch(choice){
			case "1":
				for(int i=0;i<Pizzas.length;i++){
					System.out.println(Pizzas[i].code + " " + Pizzas[i].nom + " " + Pizzas[i].prix);
				}
				System.out.println(Pizza.nbPizzas+" pizzas créées");
				break;
			case "2":
				System.out.println("Créez votre Pizza");
				System.out.println("Code de la Pizza");
				String code = sc.next();
				System.out.println("Nom de la Pizza");
				String nom = sc.next();
				System.out.println("Prix de la Pizza");
				String prix = sc.next();
				Pizza[] Etape=new Pizza[(Pizzas.length)+1];
				for(int i=0;i<Pizzas.length;i++){
					Etape[i] = Pizzas[i];
				}
				int idF =  (Pizzas[(Pizzas.length)-1].id)+1;
				Pizza etape = new Pizza(idF,code,nom,Double.parseDouble(prix));
				Etape[Pizzas.length]=etape;
				Pizzas=Etape;
				break;
			case "3":
				System.out.println("Modifiez votre Pizza");
				System.out.println("Code de la Pizza que vous voulez modifier");
				String id = sc.next();
				System.out.println("Nouveau Code de la Pizza");
				String codeU = sc.next();
				System.out.println("Nouveau Nom de la Pizza");
				String nomU = sc.next();
				System.out.println("Nouveau Prix de la Pizza");
				String prixU = sc.next();
				for(int i=0;i<Pizzas.length;i++){
					if((Pizzas[i].code).equals(id)==true){
						Pizzas[i].code = codeU;
						Pizzas[i].nom = nomU;
						Pizzas[i].prix = Double.parseDouble(prixU);
					} 
				}
				break;
			case "4":
				System.out.println("Supprimer votre Pizza");
				System.out.println("Code de la Pizza que vous voulez supprimer");
				String idS = sc.next();
				int j = 0;
				for(int i=0;i<Pizzas.length;i++){
					if((Pizzas[i].code).equals(idS)==true){
						j = i;
					}
				}
				Pizza[] EtapeS=new Pizza[(Pizzas.length)-1];
				for(int k=0;k<Pizzas.length;k++){
					if(k<j){
						EtapeS[k] = Pizzas[k];
					}else if(k==j){

					}else{
						EtapeS[k-1] = Pizzas[k];
					}
				}
				int nbPizza = Pizza.nbPizzas;	
				nbPizza--;
				Pizza.nbPizzas = nbPizza;
				Pizzas=EtapeS;
				break;
			default:
				break;
			}
			affichageOption();
			choice = sc.next();
		} 
		sc.close();
	}


	public static void affichageOption(){
		System.out.println("*****	Pizzeria	Administration	*****"); 
		System.out.println("1.	Lister	les	pizzas"); 
		System.out.println("2.	Ajouter une	nouvelle	pizza"); 
		System.out.println("3.	Mettre	à	jour	une	pizza"); 
		System.out.println("4.	Supprimer	une	pizza");  
		System.out.println("99.	Sortir"); 
	}

}
