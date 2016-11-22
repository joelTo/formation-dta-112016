package fr.operateurs.console;

import java.math.BigDecimal;
import java.util.Scanner;

public class OperateursApp {

	private static Scanner scanner;

	public static void main(String[] args) {
		boolean restart = true;
		scanner = new Scanner(System.in);
		while(restart){
			boolean value = false;
			float nb1 = 0, nb2 = 0;
			System.out.println("***** Application Opérateurs *****");
			System.out.println("Veuillez saisir le premier nombre...");
			while(!value){

				String temp = scanner.next();

				try{
					nb1 = Float.parseFloat(temp);
					value = true;
				} catch(NumberFormatException e){
					value = false;
					System.out.println("Saisie incorrect veuillez entrez un nombre...");
					nb1=0;
				}

			}
			value = false;
			System.out.println("Veuillez saisir le deuxieme nombre...");
			while(!value){

				String temp = scanner.next();

				try{
					nb2 = Float.parseFloat(temp);
					value = true;
				} catch(NumberFormatException e){
					value = false;
					System.out.println("Saisie incorrect veuillez entrez un nombre...");
					nb2=0;
				}

			}
			System.out.println(nb1+" + "+nb2+" = "+(new BigDecimal(nb1+"").add(new BigDecimal(nb2+""))));
			System.out.println(nb1+" - "+nb2+" = "+(new BigDecimal(nb1+"").subtract(new BigDecimal(nb2+""))));
			System.out.println(nb1+" * "+nb2+" = "+(new BigDecimal(nb1+"").multiply(new BigDecimal(nb2+""))));
			System.out.println(nb1+" / "+nb2+" = "+(new BigDecimal(nb1+"").divide(new BigDecimal(nb2+""),5)));
			System.out.println(nb1+" % "+nb2+" = "+(nb1%nb2));

			System.out.println("Voulez vous recommencer? y = Oui, n = Non");
			switch(scanner.next()){
			case "y":
				restart = true;
				System.out.println("Restart ...");
				break;
			case "n":
				restart = false;
				System.out.println("Exit ...");
				scanner.close();
				break;
			default:
				restart = false;
				System.out.println("Commande non reconnu\r\nExit ...");
				scanner.close();
				break;
			}
		}
	}

}
