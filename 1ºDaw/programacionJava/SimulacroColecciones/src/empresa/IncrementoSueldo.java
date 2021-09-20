package empresa;

public enum IncrementoSueldo {
	EMPLEADO(2.5), JEFE(10);
	
	private double incremento;

	IncrementoSueldo(double incremento) {
		this.incremento=incremento;
	}
	
	public double getIncremento() {
		return incremento;
	}

}
