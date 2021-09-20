package EjemploMapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

	public MapExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Map<String, String> diccionario = new HashMap<String, String>();
		diccionario.put("perro", "Mamífero doméstico de la familia de los cánidos");
		diccionario.put("vida", "Fuerza o actividad esencial mediante la que ...");
		
		
		
		//keySet te da el conjunto de claves
		System.out.println(diccionario.get("perro"));
		for(String clave : diccionario.keySet()) {
			System.out.println(clave);
		}
		
		// values te da todos los valores que hay listados
		for(String valor : diccionario.values()){
			System.out.println(valor);
		}
		
		
		System.out.println(diccionario.containsKey("perro"));
		System.out.println(diccionario.containsKey("gato"));
		
		
		Map<String, List<Integer>> numeros = new HashMap<String, List<Integer>>();
		

		
		//Incluir en mapas los de los 100 primeros numero los pares, impares, y primos
		
		
		numeros.put("Primos", new ArrayList<Integer>());
		
		for(int i=1; i<101; i++) {
			boolean esPrimo=true;
			
			
			//Transformarlo para que cuando no sea primo deje de entrar
			for(Integer n : numeros.get("Primos")) {
				if(i%n == 0) {
					esPrimo=false;
				}
			}
			
			if(esPrimo) {
				numeros.get("Primos").add(i);
			}
		}
		
		
		
		
		
		
//		for(int i=1; i<101;i++) {
//			if(i%2==0) {
//				if(numeros.containsKey("Pares")) {
//					numeros.get("Pares").add(i);
//				}
//				else {
//					numeros.put("Pares", new ArrayList<Integer>());
//					numeros.get("Pares").add(i);
//				}
//			}
//			else {
//				
//				if(numeros.containsKey("Impares")) {
//					numeros.get("Impares").add(i);
//				}
//				else {
//					numeros.put("Impares", new ArrayList<Integer>());
//					numeros.get("Impares").add(i);
//				}
//			}
//		}
		System.out.println(numeros);
		
		
		
		
		
		
		System.out.println(numeros.values());
		
		System.out.println(introducirPrimos());
		
		//primeros primos
		//primeros pares
		//primeros impares
	}

	Map<String, List<Integer>> numeros = new HashMap<String, List<Integer>>();
	
	
	
	
	public static List introducirPrimos() {
		List<Integer> numerosPrimos = new ArrayList<Integer>();
		boolean esPrimo = false;
		int contador=2;
		for(int i =1; i<100; i++) {
			while(contador<i) {
				if(i%contador==0) {
					esPrimo=true;
				}
				contador++;
			}
			if(esPrimo==true) {
				numerosPrimos.add(i);
			}
			contador=2;
			
		}
		return numerosPrimos;
		
	}
	
	
	
	
	public static boolean esPrimo(int numero) {
		boolean primo=false;
		int divisores =0;
		for(int i=2; i<=numero; i++) {
			if(numero%i==0) {
				primo=true;
				divisores++;
			}
			if(primo==true && divisores >3) {
				primo=true;
			}
			{
				primo=false;
			}
		}
		
		return primo;
	}
	
	
	
	
	
	
	
	
	
}
