package ejerciciosString1;

import java.util.Scanner;

public class Ej1Practica2Main {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);	
		

		Ej1Practica2Producto producto= new Ej1Practica2Producto();
		System.out.println("Introduce el codigo");	
	producto.setCodigo(teclado.nextLine());
	System.out.println("Introduce la categoría");
	producto.setCategoria(teclado.nextLine());
	
		
		System.out.println(producto.compruebaCodigo());
		System.out.println(producto.compruebaCategoria());
	}

}
