package Editorial;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class MainEditorial {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
	
		
		
ListaProvincia l = new ListaProvincia("./Ficheros/gratuidadlibrosdetextoandalucia.csv");
		
		Gson gson = new Gson();
		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String representacionBonita = prettyGson.toJson(l);
		try {
			FileWriter flujoEscritura=new FileWriter("./Ficheros/salida.json");
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			filtroEscritura.println(representacionBonita);
			filtroEscritura.close();
			flujoEscritura.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		showMenu();
		int opc;
		opc = leerEntero("Seleccione la opción deseada:");
		while (opc != 8) {
			switch (opc) {
			case 1:
				System.out.println(l.editorialMasUsada());
				break;
			case 2:{
				String nombre = leerCadena("Introduzca el nombre de la provincia");
				System.out.println(l.editorialMasUsada(nombre));
			}
				break;
			case 3:{
				String nombreProvincia = leerCadena("Introduzca el nombre de la provincia");
				String nombreLocalidad = leerCadena("Introduzca el nombre de la localidad");
				System.out.println(l.editorialMasUsada(nombreProvincia, nombreLocalidad));
			}
				break;
			case 4:{
				String nombreMateria = leerCadena("Introduzca el nombre de la materia");
				System.out.println(l.editorialMasUsadaMateria(nombreMateria));
			}
				break;
			case 5:{
				String codigoCentro = leerCadena("Introduzca el código del centro");
				System.out.println(l.listadoLibros(codigoCentro,1));
			}
				break;
			case 6:{
				String nombreCentro = leerCadena("Introduzca el nombre del centro");
				System.out.println(l.listadoLibros(nombreCentro,2));
			}
				break;
			case 7:{
				String nombreMateria = leerCadena("Introduzca el nombre de la materia");
				String localidad = leerCadena("Introduzca el nombre de la localidad");
				String provincia = leerCadena("Introduzca el nombre de la provincia");
				System.out.println(l.editorialMasUsadaMateria(provincia, localidad, nombreMateria));
			}
				
				break;
			case 8:
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
		System.out.println("1. Editorial más usada en cada una de las provincias");
		System.out.println("2. Editorial más usada en una provincia");
		System.out.println("3. Editorial más usada en una localidad.");
		System.out.println("4. Editorial más usada en una materia");
		System.out.println("5. Listado de todos los libros usados en todas las materias en un centro. Código");
		System.out.println("6. Listado de todos los libros usados en todas las materias en un centro. Nombre");
		System.out.println("7. Listado de todos los libros usados en una materia en una localidad");
		System.out.println("8. Salir");
	}

}
