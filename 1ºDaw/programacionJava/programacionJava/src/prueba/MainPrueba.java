package prueba;


import java.util.Scanner;

public class MainPrueba {

	public static void main(String[] args) {
		EstudioPrueba prueba1 = new EstudioPrueba();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nombre");
		prueba1.setNombre(teclado.nextLine());
		prueba1.setAltura(teclado.nextDouble());
		prueba1.setEdad(0);
		System.out.println("HOla");
		while (prueba1.getEdad()<=0 || prueba1.getEdad()>50) {
			System.out.println("Introduce la edad");
			prueba1.setEdad(teclado.nextInt());
			try {
				prueba1.calcularSiEsJoven();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Fin");

	}

	
}
