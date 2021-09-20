package EjemploEnum;

public enum Bonificacion {

	CUENTA_JOVEN(0.25);
	private double porcentaje;
	
	Bonificacion(double porcentaje){
		this.porcentaje=porcentaje;
	}

	public double getPorcentaje() {
		return porcentaje;
	}
}
