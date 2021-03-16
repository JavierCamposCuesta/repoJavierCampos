package RelacionProblemas8_Arrays;

import java.util.Scanner;

import EjerciciosArrays.EjerciciosMatrices;

public class Ej1 {
	

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int longitudLista=10;
		int[]lista;
		lista= new int[longitudLista];
		System.out.println("Introduce un valor de la lista");
		 for (int i=longitudLista; i>0; i--) {
			 lista[i-1]=Integer.parseInt(teclado.nextLine());
			 System.out.println("Introduce otro valor de la lista");
		 }
		 EjerciciosMatrices.imprimirVector(lista);
		
		}

	}


