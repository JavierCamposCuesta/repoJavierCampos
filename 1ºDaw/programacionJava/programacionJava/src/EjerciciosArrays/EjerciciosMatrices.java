package EjerciciosArrays;

public class EjerciciosMatrices {
	
public static void ejercicio1() {
		
		
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

//Ejercicio2
public static void imprimirMatrix(int[][] matriz) {
	
	
	

	StringBuilder cadena= new StringBuilder();
	int contador=0;
	

	for (int i=0; i<matriz.length; i++) {
		for (int j=0; j<matriz[i].length; j++) {
			if (contador==i) {
				if(j+1<matriz[i].length) {
					
					cadena.append(matriz[i][j]+",");
				}
				else {
					cadena.append(matriz[i][j]);
				}

			}
			else {
				
				cadena=new StringBuilder();
				cadena.append(matriz[i][j]+",");
				contador++;
				
			}
			
		
		}
		System.out.println("["+ cadena +"]");
	}
		
			
		}

//Imprimir vectores
public static String imprimirVector(int[] vector) {
	
	
	

	StringBuilder cadena= new StringBuilder();

	

	for (int i=0; i<vector.length; i++) {
			if (i+1<vector.length) {
				

					cadena.append(vector[i]+",");
				
			}
			else {
				cadena.append(vector[i]);
			}
			
		
		
	}
	return ("["+ cadena +"]");
		
			
		}
	
//Ejercicio 3
public static int[][]sumarMatrices(int[][]matrizA, int[][]matrizB) {
	
	
	int[][]resultado=new int[matrizA.length][matrizA[0].length];
	
	
	if (matrizA.length==matrizB.length && matrizA[0].length==matrizB[0].length) {
		
		
			for(int i=0; i<matrizA.length;i++) {
				for(int j=0; j<matrizA[i].length;j++) {
					resultado[i][j]=matrizA[i][j]+matrizB[i][j];
				}
			}
		
	}
		
	return resultado;
}
	
	

//Ejercicio 4
public static int[] concatenarMatriz(int[] listaA, int[] listaB){
	int[]resultado = new int[listaA.length+listaB.length];
	
	
	for (int i=0; i<listaA.length; i++) {
		
			resultado[i]=listaA[i];
		
	}
	for (int i=0; i<listaB.length; i++) {
		
		resultado[i+listaA.length]=listaB[i];
	
}
	
	return resultado;
}

//Ejercicio 5
public static int[][] rotarMatriz (int[][]matriz) {
	
	
	
	int[][] rotada= new int[matriz.length][matriz.length];
	
	for(int i=0; i<matriz.length; i++) {
		for(int j=0; j<matriz[i].length; j++) {
			rotada[j][matriz.length-1-i] = matriz[i][j]; //La columna pasa a ser fila y el primer valor pasa a ser el ultimo
		}
	}
		return rotada;
		
	}

public static boolean compararMatriz(int[][] matriz, int[][]matrizAComparar) {
	boolean resultado = true;
	
	if(matriz!=null && matrizAComparar!=null && matriz.length==matrizAComparar.length) {
		for (int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz[i].length; j++) {
				if (resultado==true) {
					if(matriz[i][j]!= matrizAComparar[i][j]) {
						resultado=false;
					}
				}
			}
		}
	}
	else {
		resultado=false;
	}
	
	return resultado;
}


public static boolean compararMatrizRotada(int[][] matriz, int[][]matrizAComparar) {
	
	return(compararMatriz(matriz, matrizAComparar) || compararMatriz(rotarMatriz(matriz), matrizAComparar)
			|| compararMatriz(rotarMatriz(rotarMatriz(matriz)), matrizAComparar)
			|| compararMatriz(rotarMatriz(rotarMatriz(rotarMatriz(matriz))), matrizAComparar));
		
	
	
}



//Ejercicio 6 Rotar matrices no cuadradas

public static int[][] rotarMatrizNoCuadrada(int[][] matriz){
	int[][] matrizRotada = new int[matriz[0].length][matriz.length];
	for(int i=0; i<matriz.length; i++) {
		for(int j=0; j<matriz[i].length; j++) {
			matrizRotada[j][matriz.length-1-i] = matriz[i][j]; //La columna pasa a ser fila y el primer valor pasa a ser el ultimo
		}
	}
		return matrizRotada;
	
}

	
	


	
	
	
		
			
		

	public static void main(String[] args) {
		
		int[][] matrizA = {{1,2,3,4},{2,5,6,7}};
		int[][] matrizB = {{1,2,3,4},{2,5,6,7}};
		int[] listaA= {1,2,3,4};
		int[] listaB= {1,2,3,4};
		int [][] matriz= {{3,1,0},{0,2,4},{0,5,1}};
		int [][] matrizRotadaD= {{0,0,3},{5,2,1},{1,4,0},{1,4,0}};
		int [][] matrizRotadaI= {{0,4,1},{1,2,5},{3,0,0}};
		
		
		//imprimirVector(concatenarMatriz(listaA, listaB));
		//imprimirMatrix(sumarMatrices(matrizA, matrizB));
		imprimirMatrix((rotarMatrizNoCuadrada(matrizRotadaD)));
		System.out.println(compararMatrizRotada(matrizA, matrizB));
		System.out.println(compararMatrizRotada(matriz, matrizRotadaI));

	}

}
