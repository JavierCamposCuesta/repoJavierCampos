package primeraPruebaJavierCamposExamen;

import java.util.Scanner;

public class Contestador {
	private String mensaje1;
	private String mensaje2;
	private String mensaje3;
	private int cuentaMensajes;
	private String mensaje;
	Scanner teclado=new Scanner(System.in);
	
	//constructor
	public Contestador() {
		this.mensaje1=mensaje1;
		this.mensaje2=mensaje2;
		this.mensaje3=mensaje3;
		this.cuentaMensajes=0;
		this.cuentaMensajes=cuentaMensajes;
		
	}
	
	
		
	/**
	 * Este metodo recibirá el mensaje y lo añadira
	 * @param mensaje Este mensaje sera introducido por teclado
	 * @throws Exception devuelve si el numero de mensajes esta completo
	 */
	public void introducirMensaje1(String mensaje) throws Exception {
		if (this.cuentaMensajes>=3) {
			throw new Exception("Buzon completo");
		}
		else if (this.cuentaMensajes>=2) {
			mensaje3+=mensaje;
			this.cuentaMensajes++;
		}
		else if (this.cuentaMensajes>=1) {
			mensaje2+=mensaje;
			this.cuentaMensajes++;
		}
		else if (this.cuentaMensajes>=0) {
			mensaje1=mensaje1+mensaje;
			this.cuentaMensajes++;
		}
	}
	
	/**
	 * Este metodo hara todo el grueso del programa
	 * @return
	 */
	public String oirMensaje() {
		int opcion=0;
		System.out.println("1Consultar numero mensajes\n"
				+ "2.Consultar mensaje\n"
				+ "3.añadir mensaje.\n"
				+ "4.Borrar todos los mensajes.\n"
				+ "5.Salir \n"
				+ "¿Que opcion quiere realizar?");
		opcion=Integer.parseInt(teclado.nextLine());
		
		if (opcion==1) {
			System.out.println("Hay un total de: " + this.cuentaMensajes + " mensajes");
		}
		
		else if(opcion==2) {
			System.out.println("Que mensaje quiere consultar?");
			opcion=Integer.parseInt(teclado.nextLine());
			
			if (opcion==1 && this.cuentaMensajes>=1) {
				System.out.println("Pulse 1 para oir el mensaje y 2 para borrarlo");
				opcion=Integer.parseInt(teclado.nextLine());
				
				if (opcion==1) {
					System.out.println(this.mensaje1);
				}
				else if (opcion==2) {
					this.mensaje1=null;
					System.out.println("Mensaje borrado");
				}
				else {
					System.out.println("Eleccion no valida");
				}
			}
			else if (opcion==2 && this.cuentaMensajes>=2) {
				System.out.println("Pulse 1 para oir el mensaje y 2 para borrarlo");
				opcion=Integer.parseInt(teclado.nextLine());
				if (opcion==1) {
					System.out.println(this.mensaje1);
				}
				else if (opcion==2) {
					this.mensaje1=null;
					System.out.println("Mensaje borrado");
				}
				else {
					System.out.println("Eleccion no valida");
				}
				
			}
			else if (opcion==3 && this.cuentaMensajes==3) {
				System.out.println("Pulse 1 para oir el mensaje y 2 para borrarlo");
				opcion=Integer.parseInt(teclado.nextLine());
				if (opcion==1) {
					System.out.println(this.mensaje1);
				}
				else if (opcion==2) {
					this.mensaje1=null;
					System.out.println("Mensaje borrado");
				}
				
				else if(opcion<=3 && opcion>=1) {
					System.out.println("No existe mensaje para este numero");
				}
				else {
					System.out.println("Eleccion no valida");
				}
				
				
			}
		}
			else if (opcion==3) {
				System.out.println("Introduce el mensaje");
				mensaje=teclado.nextLine();
				try {
					this.introducirMensaje1(mensaje);
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
				
				
			}
		
		else if (opcion==4) {
			this.mensaje1=null;
			this.mensaje2=null;
			this.mensaje3=null;
			System.out.println("Se han eliminado todos los mensajes");
			
		}
		else if (opcion==5) {
			System.out.println("Vuelva pronto");
		}
		else {
			System.out.println("La opcion introducida no es correcta");
		}
	
		return "Fin";
	}
}
	
	
	


