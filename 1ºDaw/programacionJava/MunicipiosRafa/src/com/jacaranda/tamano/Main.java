package com.jacaranda.tamano;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TamanoMunicipioComunidad resultado= new TamanoMunicipioComunidad();
		resultado.leer("./tamanoMunicipioComunidad.json");
		
		//System.out.println(resultado.toString());
		
		Scanner teclado= new Scanner(System.in);
		final String MENU="\n1.Mostrar todos los datos de un año\n"
				+ "2.Mostrar los datos de una comunidad y un año\n"
				+ "3.Añadir un dato\n"
				+ "4.Comprobar Total\n"
				+ "5.Salir";
		
		int menu=0;
		while (menu!=6) {
			System.out.println(MENU);
			menu=Integer.parseInt(teclado.nextLine());
			switch (menu) {
			case 1:
				System.out.println("Introduzca el año a buscar:");
				int anio=Integer.parseInt(teclado.nextLine());
			
				try {System.out.println(resultado.muestraPorAno(anio));	} 
				catch (Exception e) {	System.out.println(e.getMessage());	}
				
				break;
			case 2:
				System.out.println("Introduzca el año a buscar:");
				int anio1=Integer.parseInt(teclado.nextLine());
				System.out.println("Introduzca la comunidad a buscar:");
				String com=teclado.nextLine();
				
				try {System.out.println(resultado.muestraComunidadAno(anio1, com));}
				catch (Exception e) { System.out.println(e.getMessage());			}
				
				break;
			case 3:
				System.out.println("Introduzca la comunidad (primera mayuscula)");
				String com1=teclado.nextLine();
				System.out.println("Introduzca la descripcion");
				String desc=teclado.nextLine();
				try {
					if (resultado.verificaDatos(com1, desc)==true) {
						System.out.println("Introduzca el año");
						int anio2=Integer.parseInt(teclado.nextLine());
						System.out.println("Introduzca el dato");
						int dato=Integer.parseInt(teclado.nextLine());
						
						if (resultado.anadeDato(com1, desc, anio2, dato)==true) {
							System.out.println("Dato añadido con Exito");
						}else {
							System.out.println("No se pudo añadir el dato");
						}
						;
					}
					else {
						System.out.println("-Datos Incorrectos-");
					}
				
				
				} catch (Exception e) { System.out.println(e.getMessage());	}
				break;
			case 4:
				System.out.println("Introduzca la comunidad (Primera mayus)");
				String com2=teclado.nextLine();
				System.out.println("Introduzca el año");
				int anio3=Integer.parseInt(teclado.nextLine());
				
				System.out.println(resultado.verificaTotal(com2, anio3));
				break;
			case 5:System.out.println("Saliendo...");
				//falta escribir en fichero
				break;

			default: System.out.println("Opcion no valida");
				break;
			}
		}
		
	}
	
	
	
	
	
}
