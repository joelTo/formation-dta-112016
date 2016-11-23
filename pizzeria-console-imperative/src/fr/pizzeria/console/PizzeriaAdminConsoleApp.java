package fr.pizzeria.console;
import java.io.*;
import java.util.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	

		String nomFichier = "bdd_pizza.csv";
		Scanner sc = new Scanner(System.in);
		int getOut=1;
		
		
		do{
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas\n"
					+ "2. Ajouter une nouvelle pizza\n"
					+ "3. Mettre a jour une pizza\n"
					+ "4. Supprimer une pizza\n"
					+ "99. Sortir\n");	
			
			
			int choix =sc.nextInt();
			switch (choix) {

			case (1) : System.out.println("***** Liste des pizzas *****");
			
			int nbrFileLine=menuLength(nomFichier);
			printMenu(loadMenu(nbrFileLine,nomFichier));
			
			break;

			case (2) : System.out.println("***** Ajouter une nouvelle pizza *****");

			String[] newPizza = new String[4];
			System.out.println("Veuillez saisir le code");
			newPizza[1] =sc.next();

			System.out.println("Veuillez saisir le nom");
			sc.nextLine();
			newPizza[2] =sc.nextLine();


			System.out.println( "Veuillez saisir le prix");				
			newPizza[3] =sc.next();

			newPizza[0]="0";

			/*for(int i=0;i<4;i++){
					System.out.println(newEntry[i]);	
				}*/

			//addPizza(pizza,newPizza);



			break;

			case (3) : System.out.println("***** Mettre a jour une pizza *****");

			break;

			case (4) : System.out.println("***** Supprimer une pizza *****");

			break;

			case (99) : System.out.println("***** Au revoir ! *****");
			System.exit(0);
			break;

			default :

			}
		}while(getOut==1);
		sc.close();

	}
	
	public static int menuLength(String nomFichier) throws IOException {
		int nbrFileLine=0;
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line = null;
		while((line = br.readLine()) != null){			
			nbrFileLine++;
		}
		br.close();
		
		return nbrFileLine;
	}
	
	public static String[][] loadMenu(int nbrFileLine,String nomFichier) throws IOException{
		String[][] pizza = new String[4][nbrFileLine];
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line = null;
		int j=0;
		while((line = br.readLine()) != null){
			String[] data = line.split(";");
			for(int i=0;i<4;i++){
					pizza[i][j]=data[i];				
			}
			j++;
		}
		br.close();
		return pizza;
	}
	
	public static void printMenu(String[][] pizza){
		
		for (int i=0; i<pizza[0].length; i++){
			System.out.println(pizza[1][i]+"->"+pizza[2][i]+"("+pizza[3][i]+")");
		}
		
	}
	

	public static int addPizza(String[][] pizza, String[] newEntry) throws IOException {

		int nbrCol = pizza.length;
		int nbrLine = pizza[0].length;
		int tmpNbrLine=nbrLine+1;		

		String[][] tmp = new String[nbrCol][tmpNbrLine];

		//Copie du tableau pizza dans un tableau temporaire
		for(int i=0;i<nbrCol;i++){
			for(int j=0;j<nbrLine;j++){
				tmp[i][j]=pizza[i][j];
			}
		}

		//Ajout en fin de tableau tmp de la nouvelle pizza
		for(int i=0;i<4;i++){
			tmp[i][tmpNbrLine-1]=newEntry[i];
		}
		
		//copie de tmp dans le fichier bbd_pizza
		FileWriter write=new FileWriter("bdd_pizza.csv");       
		for (int i=0; i<tmpNbrLine; i++){
			write.write(tmp[0][i]+";"+tmp[1][i]+";"+tmp[2][i]+";"+tmp[3][i]+"\n");						
			//System.out.println(tmp[1][i]+"->"+tmp[2][i]+"("+tmp[3][i]+")");
		}
		write.close();
		
		return (tmpNbrLine);

	}
}
