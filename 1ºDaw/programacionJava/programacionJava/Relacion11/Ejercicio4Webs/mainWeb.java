
package Ejercicio4Webs;


import java.time.LocalDate;

public class mainWeb {

	public static void main(String[] args) {
		Historial historial = new Historial();
		historial.nuevaPagina("facebook");
		historial.nuevaPagina("instagram");
		historial.nuevaPagina("pokemon");
		System.out.println(historial.mostrarHistorialCompleto());
		System.out.println(" ");
		System.out.println(historial.mostrarHistorialDia(LocalDate.now()));
		System.out.println(" ");
		historial.borrarHistorial();
		System.out.println(historial.mostrarHistorialCompleto());
		

	}
	}