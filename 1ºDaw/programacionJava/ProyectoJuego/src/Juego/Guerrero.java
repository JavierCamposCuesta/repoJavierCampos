package Juego;

public class Guerrero extends Jugador{
	private int fuerza=Constantes.GUERRERO_FUERZA;
	private int magia=Constantes.GUERRERO_MAGIA+this.getGemas();
	private int velocidad=Constantes.GUERRERO_VELOCIDAD;
	
	
	public Guerrero(char simbolo, int fil, int col) {
		super(simbolo, fil, col);
		
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public int getMagia() {
		return magia;
	}
	public void setMagia(int magia) {
		this.magia = magia;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	

}
