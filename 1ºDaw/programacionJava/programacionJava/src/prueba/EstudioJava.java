package prueba;

import java.util.Scanner;

public class EstudioJava {
	//Ejercicio 1
	private String cadena;
	private char caracter;
	private String palabra;
	private String reemplazo;
	private String codigo;
	public final int VALOR_MAXIMO=12;
	public final int VALOR_MINIMO=3;
	public final int MINIMO_NUMEROS=3;
	
	public EstudioJava() {}
	public EstudioJava(String codigo) {
		this.codigo=codigo;
	}
	
	public void solicitarValores() {
		System.out.println("Introduce la cadena");
		Scanner teclado= new Scanner(System.in);
		cadena = teclado.nextLine();
		System.out.println("Introduce el caracter");
		caracter=teclado.next().charAt(0);
		
	}
	
	//Ejercicio 1
	public int charactersInString() {
		int contador=0;
		cadena=cadena.toLowerCase();
		caracter=Character.toLowerCase(caracter);
		for (int i=0; i< cadena.length();i++) {
			if (cadena.charAt(i)==caracter) {
				contador++;
				
			}
		}
		return contador;
	}
	// Ejercicio 2
	public int lowCaseInString(String cadena) {
		int contador=0;
		
		for (int i=0; i<cadena.length();i++) {
			if (Character.isLowerCase(cadena.charAt(i))) {
				contador ++;
			}
		}
		return contador;
	}

		// Ejercicio 3
	public int upperCaseInString(String cadena) {
		int contador=0;
		for (int i=0; i<cadena.length();i++) {
			if (Character.isUpperCase(cadena.charAt(i))) {
				contador++;
			}
		}
		return contador;
	}
	
	// Ejercicio 4
	public int numberInString(String cadena) {
		int contador=0;
		for (int i=0;i<cadena.length();i++) {
			if (Character.isDigit(cadena.charAt(i))) {
				contador++;
			}
		}
		return contador;
	}
	
	//Ejercicio 5
	public boolean palindromo(String cadena) {
		cadena =cadena.replace(" ", "");
		String cadena2="";
		for (int i=0; i<cadena.length();i++) {
			cadena2=cadena.charAt(i)+cadena2;
		}
		return cadena.equals(cadena2);
	}
	
	//Ejercicio 6
	public boolean palabraEscondida(String cadena, String palabra) {
		int contador=0;
		int j=0;
		for (int i=0;i<cadena.length();i++) {
			while (  j <palabra.length() && palabra.charAt(j)==cadena.charAt(i)) {
				
					contador++;
					j++;
				
			}
		}
		return contador==palabra.length();
	}
	
	//Ejercicio 7
	public String reemplazaCadena(String cadena, String palabra, String reemplazo)
	{
		String cadenaNueva=cadena.replace(palabra, reemplazo);
		return cadenaNueva;
	}
	
	public boolean compruebaCodigo() throws Exception {
		int contador=0;
		if (this.codigo==null) {
			throw new Exception("El valor no puede ser nulo");
		}
		 else if (this.codigo.length()<this.VALOR_MINIMO || this.codigo.length() > this.VALOR_MAXIMO) {
			throw new Exception("La longitud de la cadena no es correcta, debe estar entre "+this.VALOR_MINIMO + " y "+this.VALOR_MAXIMO);
		}
		for (int i=0; i<codigo.length();i++) {
			if (Character.isDigit(codigo.charAt(i))) {
				contador++;
			}
		}
		if (contador<this.MINIMO_NUMEROS) {
			throw new Exception("El codigo no es correcto, debe tener "+ this.MINIMO_NUMEROS+ " numeros como minimo");
		}
		return true;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
