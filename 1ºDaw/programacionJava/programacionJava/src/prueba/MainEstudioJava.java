package prueba;

import java.util.Scanner;

public class MainEstudioJava {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		EstudioJava prueba1 = new EstudioJava();
		/*
		prueba1.solicitarValores();
		System.out.println(prueba1.charactersInString());
		*/

		/*
		System.out.println("Introduce la cadena y la palabra");
		System.out.println(prueba1.reemplazaCadena(teclado.nextLine(), teclado.nextLine(), teclado.nextLine()));
		*/
		System.out.println("Introduce el codigo del producto");
		EstudioJava prueba2 = new EstudioJava(teclado.nextLine());
		while (true) {
			try {
				System.out.println(prueba2.compruebaCodigo());
			}
			catch (Exception hola){
				System.out.println(hola.getMessage());
			}
			System.out.println("Introduce el codigo del producto");
			prueba2.setCodigo(teclado.nextLine());
		}
		
	
	}
}

