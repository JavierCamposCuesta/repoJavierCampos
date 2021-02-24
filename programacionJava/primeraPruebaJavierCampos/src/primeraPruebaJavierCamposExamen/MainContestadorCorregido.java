package primeraPruebaJavierCamposExamen;

import java.util.Scanner;

public class MainContestadorCorregido {
	
	public static final String MENU= "1Consultar numero mensajes\n"
			+ "2.Consultar mensaje\n"
			+ "3.Añadir mensaje.\n"
			+ "4.Borrar todos los mensajes.\n"
			+ "5.Salir \n"
			+ "¿Que opcion quiere realizar?";
	
	public static final String MENU_MENSAJES="1. Mensaje numero 1 \n "+
											"2. Mensaje numero 2 \n "+
											"3. Mensaje numero 3";
	public static final String OPCIONES_MENSAJES="1. Oir \n 2. Borrar\n";	
	static int opcion;
	private static Scanner teclado =new Scanner (System.in);

	public static void main(String[] args) {
		mostrarMenu();
		int opcionMenuPrincipal =Integer.parseInt(teclado.nextLine());
		ContestadorCorregido contestador = new ContestadorCorregido();
		
		while(opcionMenuPrincipal!=5) {
			switch (opcionMenuPrincipal) {
			case 1: {
				System.out.println("Existen "+ contestador.getNumeroMensajes()+" numero de mensajes");
				
					break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				System.out.println("Introduzca el mensaje que quiere guardar");
				String mensaje=teclado.nextLine();
				try {
					contestador.addMensaje(mensaje);
				} catch (Exception e) {
					
				System.out.println(e.getMessage());
				}
				
				
				break;
			}
			case 4: {
				contestador.borrarTodosLosMensajes();
				break;
			}
			default:
				break;
			}
			mostrarMenu();
			opcionMenuPrincipal =Integer.parseInt(teclado.nextLine());
			
		}

	}
	public static void subMenu(Contestador contestador) {
		System.out.println("¿Que mesaje desea consultar?");
		System.out.println(MENU_MENSAJES);
		int numMensaje=Integer.parseInt(teclado.nextLine());
		if (numMensaje>0 && numMensaje<=3) {
			System.out.println(OPCIONES_MENSAJES);
			switch (numMensaje) {
			case 1: {
				opcion=Integer.parseInt(teclado.nextLine());
				if (opcion==1) {
					try {
						System.out.println("E");
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
				
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + numMensaje);
			}
			
			
			
		}
		else {
			System.out.println("Opcion no válida");
		}
		
	}
	

	public static void mostrarMenu() {
		System.out.println(MENU);
	}
	
	
}
