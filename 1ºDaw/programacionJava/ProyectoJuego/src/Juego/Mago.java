package Juego;



	public class Mago extends Jugador{
		private int fuerza=Constantes.MAGO_FUERZA;
		private int magia=Constantes.MAGO_MAGIA+this.getGemas();
		private int velocidad=Constantes.MAGO_VELOCIDAD;
		
		public Mago(char simbolo, int fil, int col) {
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
