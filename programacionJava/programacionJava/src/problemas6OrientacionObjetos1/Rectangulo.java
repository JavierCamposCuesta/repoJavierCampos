package problemas6OrientacionObjetos1;

public class Rectangulo {
	private double ancho=1;
	private double longitud=1;
	
	
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		if ((ancho>0) && (ancho <20)) {
		this.ancho = ancho;
		}
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		if ((longitud>0) && (longitud <20)) {
			this.longitud = longitud;
			}
	}

	public static double perimetro(longitud, ancho) {
		double totalPerimetro = longitud*2 + ancho*2;
		
	}
	public static double area(longitud, ancho) {
		double totalArea = longitud*  ancho;
		
	}
	
	

}
