package feria;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		ListaCalles lc = new ListaCalles("./casetasferia2021.csv");
		
		
		showMenu();
		int opc;
		opc = leerEntero("Seleccione la opción deseada:");
		while (opc != 8) {
			switch (opc) {
			case 1:
				String nombreCalle = leerCadena("Introduzca el nombre de la calle");
				System.out.println(lc.mostrarCasetas(nombreCalle));
				break;
			case 2:{
				System.out.println(lc.mostrarNumeroCasetas());
			}
				break;
			case 3:{
				String nombreCalle1 = leerCadena("Introduzca el nombre de la calle");
				int numero= leerEntero("Introduce el numero de la caseta");
				System.out.println(lc.eliminarCaseta(nombreCalle1, numero));
			}
				break;
			case 4:{
				Gson gson = new Gson();
				final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
				final String representacionBonita = prettyGson.toJson(lc);
				try {
					FileWriter flujoEscritura=new FileWriter("./salida.json");
					PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
					filtroEscritura.println(representacionBonita);
					filtroEscritura.close();
					flujoEscritura.close();
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
				break;
			case 5:{
				System.out.println(lc.toString());
			}
				break;
		
			case 6:
				System.out.println("Saliendo....");
				break;
	
			default:
				System.out.println("Opción no permitida. Inténtelo de nuevo");
				break;
			}
			opc = leerEntero("Seleccione la opción deseada:");

		}

	}
	public static int leerEntero(String msg) {
		System.out.println(msg);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		return teclado.nextLine();
	}
	
	public static void showMenu() {
		System.out.println("1. Mostrar todas las casetas existentes en una calle.");
		System.out.println("2. Mostrar para cada una de las calles del recinto ferial el número de casetas que hay en lacalle");
		System.out.println("3. Eliminar una caseta.");
		System.out.println("4. Crear fichero Json");
		System.out.println("5. Mostrar todo");
		System.out.println("6. Salir");
		
	}

}
