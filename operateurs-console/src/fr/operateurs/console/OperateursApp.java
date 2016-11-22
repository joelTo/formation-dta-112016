package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {

	public static void main(String[] args) {
		System.out.println("***** Application Opérateurs *****");
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in.
		System.out.println("Veuillez saisir le premier nombre...");
		float first = reader.nextFloat(); // Scans the next token of the input as an int.
		System.out.println("Veuillez saisir le second nombre...");
		float second = reader.nextFloat(); // Scans the next token of the input as an int.
		
		float add = first + second;
		System.out.printf(first + " + " + second + " = " + add + "\n");
		
		float min = first - second;
		System.out.printf(first + " - " + second + " = " + min + "\n");
		
		float mult = first * second;
		System.out.printf(first + " * " + second + " = " + mult + "\n");
		
		float div = first / second;
		System.out.printf(first + " / " + second + " = " + "%.2f" + "\n", div);
		
		float mod = first % second;
		System.out.println(first + " % " + second + " = " + mod);
		
		reader.close();
		}
}
