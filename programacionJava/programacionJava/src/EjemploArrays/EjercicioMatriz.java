package EjemploArrays;

import java.util.Arrays;

import Examen5Marzo.Empleado;

public class EjercicioMatriz {
	
	public static void matriz() {
		
		
		int[][] matriz = new int[4][4];

		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[i].length; j++) {
				if (i==j) {
					matriz[i][j]=1;
				}
				else {
					matriz[i][j]=0;
				}
				
			System.out.println(matriz[i][j]+ "\t");
			System.out.println("");
			}
			
				
			}
		
		
		
			
		}
	
public static void matriz5() {
		
		
		int[][] matriz5 = new int[4][4];

		for (int i=0; i<matriz5.length; i++) {
			for (int j=0; j<matriz5[i].length; j++) {
				if (i==j) {
					matriz5[i][j]=1;
				}
				else {
					matriz5[i][j]=5;
				}
				
			System.out.println(matriz5[i][j]+ "\t");
			System.out.println("");
			}
			
				
			}
		
		
		
			
		}
		
		
	
	public static void main(String[] args) {
	matriz();
	matriz5();
	

	}

}
