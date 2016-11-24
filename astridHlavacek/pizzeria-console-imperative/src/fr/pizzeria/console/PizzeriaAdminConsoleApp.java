package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		String Pizzas[][] = {
				{"0","PEP","Pépéroni","12.50"},
				{"1","MAR","Margherita","14.00"},
				{"2","REI","La Reine","11.50"},
				{"3","FRO","La 4 fromages","12.00"},
				{"4","CAN","La cannibale","12.50"},
				{"5","SAV","La savoyarde","13.00"},
				{"6","ORI","L’orientale","13.50"},
				{"7","IND","L’indienne","14.00"}};
		
		Scanner sc = new Scanner(System.in);
		
		affichageOption();
		String choice = sc.next();
		
		while(choice.equals("99")!=true){
			switch(choice){
				case "1":
					for(int i=0;i<Pizzas.length;i++){
						for(int j=1;j<4;j++){
							System.out.print(Pizzas[i][j] + " ");
						}
						System.out.println("");
					}
					break;
				case "2":
					System.out.println("Créez votre Pizza");
					System.out.println("Code de la Pizza");
					String code = sc.next();
					System.out.println("Nom de la Pizza");
					String nom = sc.next();
					System.out.println("Prix de la Pizza");
					String prix = sc.next();
					String Etape[][]=new String[(Pizzas.length)+1][4];
					for(int i=0;i<Pizzas.length;i++){
						Etape[i][0] = Pizzas[i][0];
						Etape[i][1] = Pizzas[i][1];
						Etape[i][2] = Pizzas[i][2];
						Etape[i][3] = Pizzas[i][3];
					}
					int idF =  Integer.parseInt(Pizzas[(Pizzas.length)-1][0])+1;
					Etape[Pizzas.length][0] = String.valueOf(idF);
					Etape[Pizzas.length][1] = code;
					Etape[Pizzas.length][2] = nom;
					Etape[Pizzas.length][3] = prix;
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
							if((Pizzas[i][1]).equals(id)==true){
								Pizzas[i][1]=codeU;
								Pizzas[i][2]=nomU;
								Pizzas[i][3]=prixU;
							} 
						}
					break;
				case "4":
					System.out.println("Supprimer votre Pizza");
					System.out.println("Code de la Pizza que vous voulez supprimer");
					String idS = sc.next();
					int j = 0;
					for(int i=0;i<Pizzas.length;i++){
						if((Pizzas[i][1]).equals(idS)==true){
							 j = i;
						}
					}
					String EtapeS[][]=new String[(Pizzas.length)-1][4];
					for(int k=0;k<Pizzas.length;k++){
						if(k<j){
							EtapeS[k][0] = Pizzas[k][0];
							EtapeS[k][1] = Pizzas[k][1];
							EtapeS[k][2] = Pizzas[k][2];
							EtapeS[k][3] = Pizzas[k][3];
						}else if(k==j){
							
						}else{
							EtapeS[k-1][0] = Pizzas[k][0];
							EtapeS[k-1][1] = Pizzas[k][1];
							EtapeS[k-1][2] = Pizzas[k][2];	
							EtapeS[k-1][3] = Pizzas[k][3];
						}
					}
					
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
