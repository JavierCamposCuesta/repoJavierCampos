package empresa;

public enum TipoSueldo {
	ADMINISTRATIVO(1150), OPERARIO(1100), CONTABLE(1350);
	
	private double sueldo;

	TipoSueldo(double sueldo) {
		this.sueldo=sueldo;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	

}
