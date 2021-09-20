package Juego;

public class Ogro extends Jugador{
	private int fuerza=Constantes.OGRO_FUERZA;
	private int magia=Constantes.OGRO_MAGIA+this.getGemas();
	private int velocidad=Constantes.OGRO_VELOCIDAD;
	
	public Ogro(char simbolo, int fil, int col) {
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

