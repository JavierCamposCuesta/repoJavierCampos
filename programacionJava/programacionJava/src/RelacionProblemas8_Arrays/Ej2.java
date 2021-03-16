package RelacionProblemas8_Arrays;

import java.util.Scanner;

import EjerciciosArrays.EjerciciosMatrices;

public class Ej2 {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		
		int longitudLista=10;
		int[] lista;
		lista= new int[longitudLista];
		System.out.println("Introduce un valor de la lista");
		for(int i=0; i<longitudLista; i++) {
			if (i+1<longitudLista) {
				lista[i+1]=Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce otro valor de la lista");
				
			}
			else {
				lista[0]=Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce otro valor de la lista");
			}
		}
		
		EjerciciosMatrices.imprimirVector(lista);
	}
	

}
