package RelacionProblemas8_Arrays;

import java.util.Scanner;

import EjerciciosArrays.EjerciciosMatrices;

public class Ej3_SolicitarNumeros1_1000 {
	/*Realizar un programa que solicite por teclado números entre 1 y 1000hasta   que   el   usuario
	 *    informe   de   que   ya   no   desea   introducir   másnúmeros. Después debe mostrar:
	 *    •La media de los números leídos.
	 *    •Cuántos números terminan en cada uno de los dígitos (0 .. 9).
	 *    •El dígito en el que más números terminan.
	 *    •En qué dígitos no ha terminado ningún número.
	 *    
	 *    Pista: crear un vector de contadores de 10 elementos*/
	
	
	/* Esta forma no es como lo pide
	
	public static double calcularMedia(int[] lista) {
		double total=0;
		for(int i = 0; i<lista.length; i++) {
			total+=lista[i];
		}
		double media= total/(lista.length);
		return media;
	}
	
	public static int[] ultimoDigito(int[] lista) {
		int contador0=0, contador1=0, contador2=0, contador3=0, contador4=0, contador5=0, contador6=0,
				contador7=0, contador8=0, contador9=0;
		int [] listaDigitos= new int[10];
		
		for(int i =0; i<lista.length;i++) {
			listaDigitos[lista[i]%10]++;
			
		}
		return listaDigitos;
		
	}
	
	public static String digitoMasRepetido(int []lista) {
	 int mayor=lista[0];
	 for (int i=0; i<lista.length;i++) {
		 if(mayor<lista[i]) {
			 mayor=i;
		 }
	 }
		return ("El digito que mas se repite es "+mayor);
	}
	public static String digitoNoUtilizado(int []lista) {
		 String noUtilizado="Los digitos no utilizados son: ";
		 for (int i=0; i<lista.length;i++) {
			 if(lista[i]==0) {
				 noUtilizado+=", "+i;
			 }
		 }
			return noUtilizado;
		}
	*/
	
	
	
	// La forma correcta de hacerlo
	
	 public static String solicitarNumeros() {
		 int suma=0;
		 int numero=1;
		int contador=0;
		double media=0;
		int mayor=-1;
		int [] listaDigitos= new int[10];
		String noUtilizado=null;
		
		Scanner teclado= new Scanner(System.in);
		
		
		System.out.println("Introduce el primer numero:");
		numero=Integer.parseInt(teclado.nextLine());
		while (numero!=0) {
			//Aqui calculo la media
			suma+=numero;
			contador ++;
			
			media = suma/contador;
			
			//Aqui realizamos un vector con el numero de digitos en los que acaban los numeros
			listaDigitos[numero%10]++;
			
			
			//Aqui buscamos el numero que más se repite
			mayor=listaDigitos[0];
			for (int i=0; i<listaDigitos.length;i++) {
				if(mayor<listaDigitos[i]) {
					mayor=i;
				}
			}
			
			//Aqui buscamos los numeros que no se utilizan
			noUtilizado="Los digitos no utilizados son: ";
			 for (int i=0; i<listaDigitos.length;i++) {
				 if(listaDigitos[i]==0) {
					 noUtilizado+=", "+i;
				 }
			 }
			
			
			
			System.out.println("Introduce otro numero:");
			numero=Integer.parseInt(teclado.nextLine());
		
		}
				
			
			
		
		return "La media de los numeros es: "+media+ "\n El numero en el que acaban los digitos es: "+ EjerciciosMatrices.imprimirVector(listaDigitos)
		+"\n El digito que mas se repite es "+mayor + "\n" +noUtilizado;
		
		 
		 
	 }
		
	
	

	public static void main(String[] args) {
		//int[]lista={0,1,1,1,2,3,3,3,3,3,3,3,4,5,6};
		//System.out.println(calcularMedia(lista));
		//EjerciciosMatrices.imprimirVector(ultimoDigito(lista));
		//System.out.println(digitoNoUtilizado(ultimoDigito(lista)));
		
		
		System.out.println(solicitarNumeros());
		

	}

}
