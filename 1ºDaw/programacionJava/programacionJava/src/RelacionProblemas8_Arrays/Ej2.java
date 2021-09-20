package RelacionProblemas8_Arrays;

import java.util.Scanner;

import EjerciciosArrays.EjerciciosMatrices;

public class Ej2 {
	static Scanner teclado= new Scanner(System.in);
	public static int[] desplazar1Derecha(int[]lista) {
		int ultimoElemento=lista[lista.length-1];
		for(int i=lista.length-1; i>0; i--) {
			
			lista[i]=lista[i-1];
			
	}
		lista[0]=ultimoElemento;
		return lista;
	}
	
	public final static int MAX_ITERACIONES=10;
	
	public static void foo() {
		Scanner teclado= new Scanner(System.in);
		int[] vector = new int[MAX_ITERACIONES];
		
		for(int i=0; i<MAX_ITERACIONES; i++) {
			System.out.println("Introduce el numero en la posicion ("+ (i+1)+"/"+MAX_ITERACIONES+"): ");
			vector[i]= Integer.parseInt(teclado.nextLine());
		}
		EjerciciosMatrices.imprimirVector((vector));
		EjerciciosMatrices.imprimirVector((desplazar1Derecha(vector)));
		
	}
	public static void main(String[] args) {
		/*
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
		*/
		int[] listaA= {1,2,3,4};
		
		
		//EjerciciosMatrices.imprimirVector(lista);
		//EjerciciosMatrices.imprimirVector(desplazar1Derecha(listaA));
		foo();
	}
	

}
