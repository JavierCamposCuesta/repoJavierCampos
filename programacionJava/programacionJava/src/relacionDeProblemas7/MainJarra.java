package relacionDeProblemas7;

import java.util.Scanner;

public class MainJarra {

	public static void main(String[] args) {
		
	Jarra A= new Jarra(50);
	Jarra B= new Jarra(5);
		int opcion=0;
		Scanner teclado= new Scanner(System.in);
		System.out.println("¿Que desea hacer?\n"
			+ "1. LLenar jarra \n"
			+ "2. Vaciar jarra \n"
			+ "3. Volcar jarra A en B \n"
			+ "4. Volcar jarra B en A \n"
			+ "5. Ver estado de las jarras \n"
			+ "6. Mostrar menú \n"
			+ "7. Salir");
		opcion=teclado.nextInt();
	while (opcion!=7) {
		
		switch (opcion) {
		case 1: {
			System.out.println("¿Que jarra desea llenar? \n"
					+ "1. Jarra A \n"
					+ "2. Jarra B");
			opcion=teclado.nextInt();
			while (opcion!=1 && opcion!=2) {
				System.out.println("La opcion introducida no es válida, prueba otra vez");
				opcion=teclado.nextInt();
			}
			if (opcion==1) {
				try {
					A.llenarJarra();
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
			}
			else {
				try {
					B.llenarJarra();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			break;
		}
		case 2: {
			System.out.println("¿Que jarra desea vaciar? \n"
					+ "1. Jarra A \n"
					+ "2. Jarra B");
			opcion=teclado.nextInt();
			while (opcion!=1 && opcion!=2) {
				System.out.println("La opcion introducida no es válida, prueba otra vez");
				opcion=teclado.nextInt();
			}
			if (opcion==1) {
				A.vaciarJarra();;
			}
			else {
				B.vaciarJarra();;
			}
			break;
		}
		case 3: {
			A.volcarAenB(B);
			break;
		}
		case 4: {
			B.volcarAenB(A);
			break;
		}
		case 5: {
			System.out.println(A.estadoJarra(B));
			break;
		}
		case 6: {
			System.out.println("¿Que desea hacer?\n"
					+ "1. LLenar jarra \n"
					+ "2. Vaciar jarra \n"
					+ "3. Volcar jarra A en B \n"
					+ "4. Volcar jarra B en A \n"
					+ "5. Ver estado de las jarras \n"
					+ "6. Mostrar menú \n"
					+ "7. Salir");
			break;
		}
		
		}
		if (opcion >7 || opcion <=0) {
			System.out.println("Opcion no válidad");
		}
		System.out.println("¿Que opción quiere realizar?");
		opcion=teclado.nextInt();
	}
	System.out.println(A.calcularAguaMovidad(B));	
	}
	
}
