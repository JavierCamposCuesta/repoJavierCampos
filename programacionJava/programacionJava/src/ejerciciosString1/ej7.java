package ejerciciosString1;

import java.util.ArrayList;
import java.util.List;

public class ej7 {

	public static String prueba() {
		return "HOla";
	}
	
	
	public static void main(String[] args) {
		/*
		 * Diseñar una función que reciba como parámetro tres cadenas, la primera será una frase y 
		 * deberá buscar si existe la palabra que recibe como segundo parámetro y reemplazarla por la 
		 * tercera
		 */
		System.out.println(cambiaCadena("hola que haces", "haces", "tal"));
		
		
	}
	public static String cambiaCadena(String texto, String palabra, String reemplazo)
	{
		 List<String> lista = new ArrayList<String>();
		 String palabraCambiante="";
		 String textoNuevo="";
		 
		for (int i =0; i<texto.length();i++)
		{
			if (texto.charAt(i)!=' ')
			{
				palabraCambiante=palabraCambiante+texto.charAt(i);
			}
			else {
				lista.add(palabraCambiante);
				lista.add(" ");
				palabraCambiante="";
			}
		}
		for (int i=0;i<lista.size();i++) {
			if (lista.get(i).equals(palabra)) {
				lista.set(i, reemplazo);
			}
		}
		for (int i=0;i<lista.size();i++) {
			textoNuevo=textoNuevo+lista.get(i).toString();
		}
		return textoNuevo;
	}
	
}
