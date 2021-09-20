package Juego;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	
		Scanner teclado= new Scanner(System.in);
		
		System.out.println("Cuantos jugadores van a jugar?");
		int numeroJugadores=Integer.parseInt(teclado.nextLine());
		// TODO: controlar el numero maximo que pueden jugar
		LogicaJuego prueba1= new LogicaJuego(numeroJugadores);
		prueba1.crearTablero();
		
		int contador=0;
		while(contador<numeroJugadores) {
			System.out.println("1. Guerrero \n2. Mago \n3. Elfo \n4. Ogro");
			System.out.println("Tipo del jugador "+(contador+1));
			int tipoJugador=Integer.parseInt(teclado.nextLine());
			prueba1.crearJugador(contador, tipoJugador);
			
			
			contador++;
		}
		
		
		prueba1.iniciarTablero();
		Jugador[] jugadores = prueba1.getJugadores();
		jugadores[0].moverJugador('I');
		
//		int turno = 0;
//		boolean fin = false;
//		
//		while (!fin) {
//			System.out.println("Turno jugador: " + jugadores[turno]);
//			// Tirar dado
//			// Elige movimiento
//			// Setea movimiento en jugadores[turno]
//			
//			jugadores[turno].
//			
//			turno++;
//			if (turno==jugadores.length) {
//				turno = 0;
//			}
//		}
		
	}

}
