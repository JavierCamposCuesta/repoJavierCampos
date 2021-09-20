package relacionDeProblemas7;

public class Linea {
	private Punto puntoA;
	private Punto puntoB;
	
	//Constructores
	public Linea () {}
	
	public Linea(Punto puntoA, Punto puntoB) {
		this.puntoA=puntoA;
		this.puntoB=puntoB;
	}
	
	//getters and setters
	public Punto getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	public Punto getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}


	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=true;
		if (this == obj)
			sonIguales=true;
		if (obj == null)
			sonIguales= false;
		if (getClass() != obj.getClass())
			sonIguales= false;
		Linea other = (Linea) obj;
		if (puntoA == null) {
			if (other.puntoA != null)
				sonIguales= false;
		} else if (!puntoA.equals(other.puntoA))
			sonIguales= false;
		if (puntoB == null) {
			if (other.puntoB != null)
				sonIguales= false;
		} else if (!puntoB.equals(other.puntoB))
			sonIguales= false;
		return sonIguales;
	}
	
	//Metodos
	
	public void moverDerecha(double movimiento) {
		puntoA.moverDerecha(movimiento);
		puntoB.moverDerecha(movimiento);
		mostrarInformacion();
	}
	
	public void moverIzquierda(double movimiento) {
		puntoA.moverIzquierda(movimiento);
		puntoB.moverIzquierda(movimiento);
		mostrarInformacion();
	}
	
	public void moverArriba(double movimiento) {
		puntoA.moverArriba(movimiento);
		puntoB.moverArriba(movimiento);
		mostrarInformacion();
	}
	
	public void moverAbajo(double movimiento) {
		puntoA.moverAbajo(movimiento);
		puntoB.moverAbajo(movimiento);
		mostrarInformacion();
	}
	public void mostrarInformacion() {
		System.out.println(" la posicion actual es: ("+puntoA.getEjeX() + ","+ puntoA.getEjeY()+") , (" + puntoB.getEjeX() + ","+ puntoB.getEjeY()+")");
	}
	
	
	
	
	
	
	
	
	

}
