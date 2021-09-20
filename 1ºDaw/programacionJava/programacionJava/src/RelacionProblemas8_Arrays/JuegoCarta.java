package RelacionProblemas8_Arrays;

import java.util.Random;

public class JuegoCarta {
	private JugadorCarta jugador1;
	private JugadorCarta jugador2;
	private int cantidadARepartir;
	
	public JuegoCarta(int cantidadARepartir) throws Exception{
		super();
		if(cantidadARepartir <= Baraja.NUMERO_CARTAS/2) {
			jugador1= new JugadorCarta();
			jugador2=new JugadorCarta();
			this.cantidadARepartir=cantidadARepartir;
		}
		else {
			throw new Exception("No se puede repartir cartas");
		}
	}
	
//	public void repartirCartas() {
//		Baraja baraja = new Baraja();
//		
//		repartirMano(baraja, jugador1);
//		repartirMano(baraja, jugador2);
//	}
	
//	public void repartirMano(Baraja baraja, JugadorCarta j) {
//		for(int i=0; i<cantidadARepartir;i++) {
//			Carta carta = baraja.getCartas()baraja.get(new Random().nexInt(baraja.getCartas().size()-1));	
//			j.addCarta(carta);
//			barajas.getCartas().remove(carta);
//			}
//	}
	
	
	
	public JugadorCarta getJugador1() {
		return jugador1;
	}
	public void setJugador1(JugadorCarta jugador1) {
		this.jugador1 = jugador1;
	}
	public JugadorCarta getJugador2() {
		return jugador2;
	}
	public void setJugador2(JugadorCarta jugador2) {
		this.jugador2 = jugador2;
	}
	

}
