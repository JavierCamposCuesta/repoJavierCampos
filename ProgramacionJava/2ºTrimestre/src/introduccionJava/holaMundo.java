package introduccionJava;

import java.util.Scanner;

public class holaMundo {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int x;
		char c;
		String nombre;
		x=23;

		System.out.println("Introduce un caracter: ");
		System.out.println("Introduce un numero entero: ");
		System.out.println("Introduce tu nombre: ");
		c = teclado.nextLine().charAt(0);
		x = Integer.parseInt(teclado.nextLine());
		nombre = teclado.nextLine();
		System.out.println("El caracter es: "+c);
		System.out.println("El numero entero es: "+x);
		System.out.println("Tu nombre es: " + nombre);
		
		int x1=23 , y=3;
		double result=(double)x/y;
		System.out.println(result);
		
		int opcion;
		System.out.println("1. Opcion \n2. Opcion\n3. Opcion");
		opcion=Integer.parseInt(teclado.nextLine());
		switch (opcion){
			case 1:
				{
				System.out.println("Has elegido la opcion 1");
				break;
				}
			case 2:
				{
				System.out.println("Has elegido la opcion 2");
				break;
				
				}
				
			case 3:
				{
				System.out.println("Has elegido la opcion 3");
				break;
				}
		}
		
		
		
		
		
	}

}
