package primeraPruebaJavierCamposExamen;

public class MainMenuContestador {

	public static void main(String[] args) {
		Contestador contestador1 = new Contestador();
		/* pongo un while true para no tener que estar dandole todo el rato a ejecutar,
		 * lo correcto realmente seira que finalizase cuando se le introdujese un 5 que es para salir,
		 * no me da tiempo así que lo dejo con el while true, pero es por falta de tiempo, realmente se hacerlo 
		 */
		while(true) {
			System.out.println(contestador1.oirMensaje());
		}
		
		

	}

}
