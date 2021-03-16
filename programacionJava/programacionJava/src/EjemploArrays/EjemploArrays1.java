package EjemploArrays;

import Examen5Marzo.Empleado;

public class EjemploArrays1 {
	
	public static void trabajansoConArrays() {
		int[] vector = new int[5];
		System.out.println(vector);
		System.out.println(vector[vector.length-1]);
		
		
		int[][] matrix = new int[5][5];
		matrix[3][0]=7;
		System.out.println(matrix[3][0]);
		
		Empleado[][] listaEmpleados = new Empleado[3][10];
		
		for (int i=0; i<listaEmpleados.length; i++) {
			for (int j=0; j<listaEmpleados[i].length;j++) {
				listaEmpleados[i][j]= new Empleado();
				System.out.println(listaEmpleados[i][j]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		trabajansoConArrays();
	}

}