package Examen5Marzo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Empleado empleado1 = new Empleado();
		Profesor profesor1= new Profesor();
		PersonalDireccion director1 = new PersonalDireccion();
		Administracion administrador1 = new Administracion();
		Scanner teclado= new Scanner(System.in);
		int opcion=0;
		
		
		
		
		
		System.out.println("1.Profesor \n2.Personal Direccion \n3.Personal Administración");
		System.out.println("Bienvenido, ¿que tipo de empleado eres?");
		while (opcion!=1 && opcion!=2 && opcion!=3) {
			System.out.println("Introduce una opción válida: ");
			opcion=teclado.nextInt();
			
		}
		switch (opcion) {
		case 1: {
			System.out.println("¿Que desea hacer? \n"
					+ "1. Ver informacion \n"
					+ "2. Introducir informacion");
			opcion=teclado.nextInt();
			while (opcion!=1 && opcion!=2) {
				System.out.println("La opcion introducida no es válida, prueba otra vez");
				opcion=teclado.nextInt();
			}
			if (opcion==1) {
				System.out.println(profesor1);
			}
			else {
				System.out.println("Introduzca sus datos de empleado");
				profesor1.datosGenerales();
				
				System.out.println("Introduce su departamento");
				profesor1.setDepartamento(teclado.nextLine());
				
				System.out.println("Introduce su modulo");
				profesor1.setModulo(teclado.nextLine());
				
				System.out.println("Introduce su curso");
				profesor1.setCurso(teclado.nextLine());
			}
			break;
		}
		case 2: {
			System.out.println("¿Que desea hacer? \n"
					+ "1. Ver informacion \n"
					+ "2. Introducir informacion");
			opcion=teclado.nextInt();
			while (opcion!=1 && opcion!=2) {
				System.out.println("La opcion introducida no es válida, prueba otra vez");
				opcion=teclado.nextInt();
			}
			if (opcion==1) {
				System.out.println(director1);
			}
			else {
				System.out.println("Introduzca sus datos de empleado");
				director1.datosGenerales();
				
				System.out.println("Introduce su departamento");
				director1.setDepartamento(teclado.nextLine());
				
				System.out.println("Introduce su modulo");
				director1.setModulo(teclado.nextLine());
				
				System.out.println("Introduce su curso");
				director1.setCurso(teclado.nextLine());
				
				System.out.println("Introduce su ubicacion");
			director1.setUbicacion(teclado.nextLine());
			
				
				System.out.println("Introduce su competencia");
				director1.setCompetencias(teclado.nextLine());
				
			}
			break;
		}
		case 3: {
			System.out.println("¿Que desea hacer? \n"
					+ "1. Ver informacion \n"
					+ "2. Introducir informacion");
			opcion=teclado.nextInt();
			while (opcion!=1 && opcion!=2) {
				System.out.println("La opcion introducida no es válida, prueba otra vez");
				opcion=teclado.nextInt();
			}
			if (opcion==1) {
				System.out.println(administrador1);
			}
			else {
				System.out.println("Introduzca sus datos de empleado");
				director1.datosGenerales();
				
				System.out.println("Introduce su ubicacion");
			administrador1.setUbicacion(teclado.nextLine());
			
				
				System.out.println("Introduce su telefono");
				administrador1.setTelefono(teclado.nextInt());
				
				System.out.println("Introduce su area de responsabilidad");
				administrador1.setAreaResponsabilidad(teclado.nextLine());
				
			}
			break;
		}
		

	}
		if (opcion >3 || opcion <=0) {
			System.out.println("Opcion no válidad");
		}
		System.out.println("¿Que opción quiere realizar?");
		opcion=teclado.nextInt();
	
	}
	
}
