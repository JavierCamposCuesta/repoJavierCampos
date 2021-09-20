package Juego;

public class Jugador extends Elemento{
	private int fuerza;
	private int magia;
	private int velocidad;
	private int fil;
	private int col;
	private int dinero=0;
	private int pociones=0;
	private int gemas=0;
	private int resultadoDado;
	
	
	
	public Jugador(char simbolo, int fil, int col) {
		super(simbolo);
		this.fil=fil;
		this.col=col;
	}
	
	public int lanzarDado() {
		resultadoDado=(int)(Math.random()*(this.velocidad)+1);
		return resultadoDado;
	
	}
	
	public void moverJugador(char direccion) {
		String antiguaPosicion=LogicaJuego.tablero[this.fil][this.col];
		String nuevaPosicion=" "+ LogicaJuego.nombreJugador+" ";
		String moverI=LogicaJuego.tablero[this.fil-2][this.col];
		String moverD=LogicaJuego.tablero[this.fil+2][this.col];
		String moverS=LogicaJuego.tablero[this.fil][this.col-2];
		String moverB=LogicaJuego.tablero[this.fil][this.col+2];
		int contador=0;
		switch (direccion) {
		case 'I': {
			if(this.fil-2>=1) {
				if(moverI==" "+Constantes.DINERO+" ") {
					this.dinero++;
					this.fil=this.fil-2;
					LogicaJuego.tablero[this.fil][this.col]=nuevaPosicion;
				}
				else if(moverI==" "+Constantes.GEMA+" ") {
					this.gemas++;
					this.fil=this.fil-2;
					LogicaJuego.tablero[this.fil][this.col]=nuevaPosicion;
					LogicaJuego.imprimirTablero();
					LogicaJuego.tablero[this.fil][this.col]="   ";
				}
				else if(moverI==" "+Constantes.ROCA+" ") {
					if(this.magia>Constantes.MAGIA_ROCA) {
						this.gemas=this.gemas-Constantes.MAGIA_ROCA;
						this.fil=this.fil-2;
						LogicaJuego.tablero[this.fil][this.col]=nuevaPosicion;

					}
				}
				else if(contador>=1 && (antiguaPosicion==" "+Constantes.ROCA+" " || antiguaPosicion=="   " )) {
					
				}
			}
			
			break;
		}
		case 'D': {
			
			break;
		}
		case 'S': {
			
			break;
		}
		case 'B': {
			
			break;
		}
		}

		
	}




	
	public int getFil() {
		return fil;
	}
	public void setFil(int fil) {
		this.fil = fil;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getPociones() {
		return pociones;
	}
	public void setPociones(int pociones) {
		this.pociones = pociones;
	}
	public int getGemas() {
		return gemas;
	}
	public void setGemas(int gemas) {
		this.gemas = gemas;
	}
	
	

}
