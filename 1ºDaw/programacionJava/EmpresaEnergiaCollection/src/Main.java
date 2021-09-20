import java.time.LocalDate;
import java.util.Scanner;

public class Main {

public static Scanner teclado = new Scanner(System.in);


	
	public static void main(String[] args) {
		Empresa empresa1 = new Empresa("TheBest");
		int opc;
		LocalDate fechaInicio;
		String localidad;
		int potencia;
		int paneles;
		double metros;
		
		int numeroAspas;
		int codigo;
		do {
			menu();
			opc = leerEntero("Introduzca la opción deseada");
			switch (opc) {
			case 1:
				System.out.println("Introduce la fecha en la que empezó a funcionar");
				 fechaInicio = obtenerFecha();
				
				System.out.println("Introduce la localidad");
				 localidad = teclado.nextLine();
				
				System.out.println("Introduce la potencia");
				 potencia = Integer.parseInt(teclado.nextLine());
				
				System.out.println("Introduce el numero de paneles");
				 paneles = Integer.parseInt(teclado.nextLine());
				
				System.out.println("Introduce los metros cuadrados");
				 metros = Double.parseDouble(teclado.nextLine());
				
				System.out.println("Introduce el tipo de panel");
				String tipito;
				tipito=teclado.nextLine();
				tipito=tipito.toUpperCase();
				TipoPanel tipo=TipoPanel.valueOf(tipito);
			
				
				
				empresa1.addGeneradorSolar(new GeneradorSolar(fechaInicio, localidad, potencia, paneles, metros, tipo));
				
				
				
				
				break;
			case 2:
				System.out.println("Introduce la fecha en la que empezó a funcionar");
				 fechaInicio = obtenerFecha();
				
				System.out.println("Introduce la localidad");
				 localidad = teclado.nextLine();
				
				System.out.println("Introduce la potencia");
				 potencia = Integer.parseInt(teclado.nextLine());
				
				System.out.println("Introduce el numero de aspas");
				numeroAspas = Integer.parseInt(teclado.nextLine());
				
				
				
				empresa1.addGeneradorEolico(new GeneradorEolico(fechaInicio, localidad, potencia, numeroAspas));
				break;
			case 3:
				System.out.println(empresa1.generadoresPorFecha());
				break;
			case 4:
				System.out.println(empresa1.generadoresPorLocalidad());
				break;
			case 5:
				System.out.println(empresa1.mostrarGeneradoresEolicos());
				break;
			case 6:
				System.out.println("Estos son los generadores que hay disponibles \n" + empresa1.generadoresPorFecha()
				+ "\n Introduce el código del que deseas borrar");
				codigo=Integer.parseInt(teclado.nextLine());
				try {
					System.out.println(empresa1.eliminarGenerador(codigo));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println(empresa1.mostrarTotalEnergia());
				break;
			case 8:
				System.out.println("Introduce la localidad");
				 localidad = teclado.nextLine();
				 System.out.println(empresa1.existeGeneradorEnLocalidad(localidad));
				break;
			case 9:
				
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			
			
		}while (opc !=9);
	}
	
	public static void menu() {
		System.out.println("1.- Añadir generador solar\n"+
							"2.-Añadir generador eólico\n"+
							"3.-Mostrar generadores por fecha\n"+
							"4.-Mostrar generadores por localidad\n"+
							"5.-Mostrar generadores eólicos\n"+
							"6.-Borrar generador\n"+
							"7.-Total energía\n"+
							"8.-¿Existe generador en Localidad? \n"+
							"9.-Salir\n"
				);
	}
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		return teclado.nextLine();
	}
	
	public static double leerReal(String msg) {
		System.out.println(msg);
		return Double.parseDouble(teclado.nextLine());
	}
	
	private static LocalDate obtenerFecha() {

		System.out.println("Introduzca la fecha paso a paso. Introduzca día: ");
		int day = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca mes: ");
		int month = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca año: ");
		int year = Integer.parseInt(teclado.nextLine());
		
		return LocalDate.of(year, month, day);
	}

}
