package relacionDeProblemas7;

public class Punto {
	private double ejeX;
	private double ejeY;
	
	//Constructores 
	public Punto() {}
	
	public Punto(double ejeX, double ejeY){
		this.ejeX=ejeX;
		this.ejeY=ejeY;
		
	}

	public double getEjeX() {
		return ejeX;
	}

	public void setEjeX(double ejeX) {
		this.ejeX = ejeX;
	}

	public double getEjeY() {
		return ejeY;
	}

	public void setEjeY(double ejeY) {
		this.ejeY = ejeY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ejeX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ejeY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(ejeX) != Double.doubleToLongBits(other.ejeX))
			return false;
		if (Double.doubleToLongBits(ejeY) != Double.doubleToLongBits(other.ejeY))
			return false;
		return true;
	}
	 
	public void moverDerecha(double movimiento) {
		this.ejeX=this.ejeX+movimiento;
	}
	
	public void moverIzquierda(double movimiento) {
		this.ejeX=this.ejeX-movimiento;
	}
	
	public void moverArriba(double movimiento) {
		this.ejeY=this.ejeY+movimiento;
	}
	
	public void moverAbajo(double movimiento) {
		this.ejeY=this.ejeY-movimiento;
	}
	

	
	
}

