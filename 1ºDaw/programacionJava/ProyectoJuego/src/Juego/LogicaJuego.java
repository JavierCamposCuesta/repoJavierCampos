package Juego;

import java.util.List;

public class LogicaJuego{
	
	private int ancho=Constantes.ANCHO;
	private int alto=Constantes.ALTO;
	private int numeroRocas=Constantes.NUM_ROCAS;
	private int numeroArboles=Constantes.NUM_ARBOLES;
	private int numeroPociones=Constantes.NUM_POCIONES;
	private int numeroDinero=Constantes.NUM_DINERO;
	private int numeroGemas=Constantes.NUM_GEMAS;
	private Jugador[] jugadores;
	public static String[][] tablero;
	private int numeroJugadores;
	public static char nombreJugador;
	
	
	public LogicaJuego() {
		
	}
	public LogicaJuego(int numeroJugadores) {
		this.numeroJugadores=numeroJugadores; 
		jugadores= new Jugador[numeroJugadores];
	}
	
	/**
	 * Este metodo recibe el tamaño del tablero y lo genera
	 * @param ancho 
	 * @param alto
	 * @return Devuelve la matriz del tablero, la cual para al metrodo imprimirTablero
	 */
public void tablero() {
	tablero = new String[this.ancho*2+1][this.alto*2+1];
	for (int i=0;i<tablero.length;i++) {
		for(int j=0; j<tablero[i].length;j++) {
			if(i%2==0) {
				if(j%2==0) {
					tablero[i][j]="-";
				}
				else {
					tablero[i][j]="---";
				}
			}
	
			else {
				if(j%2==0) {
					tablero[i][j]="|";
				}
				else {
					tablero[i][j]="   ";
				}
			}
		}
	}
	
}


/**
 * Este metodo sirve para imprimir el tablero
 * @param matriz Recibe la matriz del tablero
 */
public static void imprimirTablero() {
	
	
	

	StringBuilder cadena= new StringBuilder();
	int contador=0;
	

	for (int i=0; i<tablero.length; i++) {
		for (int j=0; j<tablero[i].length; j++) {
			if (contador==i) {
				if(j+1<tablero[i].length) {
					
					cadena.append(tablero[i][j]);
				}
				else {
					cadena.append(tablero[i][j]);
				}

			}
			else {
				
				cadena=new StringBuilder();
				cadena.append(tablero[i][j]);
				contador++;
				
			}
			
		
		}
		System.out.println(cadena);
	}	
	}

public void crearRocas() {
	int contador=0;
	while (numeroRocas>contador) {
		int posicionX=(int)(Math.random()*(ancho*2)+1);
		int posicionY=(int)(Math.random()*(ancho*2)+1);
		if(posicionX%2!=0 && posicionY%2!=0 && tablero[posicionX][posicionY]=="   ") {
			tablero[posicionX][posicionY]=" "+Constantes.ROCA+" ";
			contador++;
		}
	}
}

public void crearArboles() {
	int contador=0;
	while (numeroArboles>contador) {
		int posicionX=(int)(Math.random()*(ancho*2)+1);
		int posicionY=(int)(Math.random()*(ancho*2)+1);
		if(posicionX%2!=0 && posicionY%2!=0 && tablero[posicionX][posicionY]=="   ") {
			tablero[posicionX][posicionY]=" "+Constantes.ARBOL+" ";
			contador++;
		}
	}
}

public void crearPociones() {
	int contador=0;
	while (numeroPociones>contador) {
		int posicionX=(int)(Math.random()*(ancho*2)+1);
		int posicionY=(int)(Math.random()*(ancho*2)+1);
		if(posicionX%2!=0 && posicionY%2!=0 && tablero[posicionX][posicionY]=="   ") {
			tablero[posicionX][posicionY]=" "+Constantes.POCION+" ";
			contador++;
		}
	}
}

public void crearDinero() {
	int contador=0;
	while (numeroDinero>contador) {
		int posicionX=(int)(Math.random()*(ancho*2)+1);
		int posicionY=(int)(Math.random()*(ancho*2)+1);
		if(posicionX%2!=0 && posicionY%2!=0 && tablero[posicionX][posicionY]=="   ") {
			tablero[posicionX][posicionY]=" "+Constantes.DINERO+" ";
			contador++;
		}
	}
}

public void crearGemas() {
	int contador=0;
	while (numeroGemas>contador) {
		int posicionX=(int)(Math.random()*(ancho*2)+1);
		int posicionY=(int)(Math.random()*(ancho*2)+1);
		if(posicionX%2!=0 && posicionY%2!=0 && tablero[posicionX][posicionY]=="   ") {
			tablero[posicionX][posicionY]=" "+Constantes.GEMA+" ";
			contador++;
		}
	}
}

/**
 * Este metodo introduce en el tablero a cada jugador que juega con
 * su correspondiente letra
 * @param numeroJugadores le indicaremos el numero de jugadores que van a participar
 * maximo 6
 */


public void crearJugador(int numJugador, int tipoJugador ) {
	
	
		int contador=0;
		nombreJugador = Constantes.NOMBRE_JUGADORES[numJugador];

		
		boolean entrar=false;
		
		while(entrar==false) {
			int posicionX=(int)(Math.random()*(ancho*2)+1);
			int posicionY=(int)(Math.random()*(ancho*2)+1);
		if(posicionX%2!=0 && posicionY%2!=0 && tablero[posicionX][posicionY] == "   ") {
			tablero[posicionX][posicionY] = " " + nombreJugador + " ";
			entrar=true;

			switch (tipoJugador) {
				case 1: {
					Guerrero guerrero = new Guerrero(nombreJugador, posicionX, posicionY);
					jugadores[numJugador]=guerrero;
					break;
				}
				case 2: {
					Mago mago = new Mago(nombreJugador, posicionX, posicionY);
					jugadores[numJugador]=mago;
					break;
				}
				case 3: {
					Elfo elfo = new Elfo(nombreJugador, posicionX, posicionY);
					jugadores[numJugador]=elfo;
					break;
				}
				case 4: {
					Ogro ogro = new Ogro(nombreJugador, posicionX, posicionY);
					jugadores[numJugador]=ogro;
					break;
				}
			}
		
		
		}
		}
			
			

		
	
}

public void crearTablero(){
	tablero();
}
public void iniciarTablero(){
	crearRocas();
	crearArboles();
	crearPociones();
	crearDinero();
	crearGemas();
	imprimirTablero();
}


public void moverJugador() {
	
}

public void comenzarJuego() {
	for(int i=0; i<this.numeroJugadores; i++) {
		
	}
}
public Jugador[] getJugadores() {
	return jugadores;
}







}
